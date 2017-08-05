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
		//���ݴ���Ĳ�������ǰҳ��ҳ��ģ��������OrgPage���󣬱����з�ҳ��Ϣ:���м�¼����ǰҳ��ҳsize���ܼ�¼��������ҳ��
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
