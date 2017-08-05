package com.ybtx.service.impl;

import java.util.List;

import com.ybtx.dao.ProductDao;
import com.ybtx.domain.Employee;
import com.ybtx.domain.Product;
import com.ybtx.service.ProductService;
import com.ybtx.vo.ProductPage;

public class ProductServiceImpl implements ProductService{

	ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void add(Product product) {
		productDao.add(product);
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	@Override
	public void delete(Product product) {
		productDao.delete(product);
	}

	@Override
	public ProductPage findAll(int currentPage, int pageSize) {
		//根据传入的参数（当前页、页规模），返回OrgPage对象，保存有分页信息:所有记录、当前页、页size、总记录数量、总页数
		ProductPage productPage = new ProductPage();
		List<Product> list = productDao.findAll(currentPage, pageSize);
		productPage.setDataList(list);
		productPage.setCurrentPage(currentPage);
		productPage.setPageSize(pageSize);
		int totalCount = productDao.findTotalCount();
		productPage.setTotalCount(totalCount);
		productPage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return productPage;
	}

	@Override
	public Product findById(int pId) {
		return productDao.findById(pId);
	}

	@Override
	public List<Product> findAllForList() {
		return productDao.findAllForList();
	}
	
}
