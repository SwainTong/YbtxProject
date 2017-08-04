package com.ybtx.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
//import com.sun.org.apache.regexp.internal.recompile;
import com.ybtx.domain.Product;
import com.ybtx.service.ProductService;
import com.ybtx.vo.ProductPage;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//ģ������
	private Product product = new Product();
	//spring�е���service
	private ProductService productService;
	//��ҳ��ģ
	private int currentPage = 1;
	private int pageSize = 10;
	
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	//�����ݿ��������
	public String add() {
		productService.add(product);
		return SUCCESS;	
	}
	public String update() {
		productService.update(product);
		return SUCCESS;	
	}
	public String delete() {
		productService.delete(product);
		return SUCCESS;	
	}
	
	//�������ݿ��е���������
	public String findAll() {
		ProductPage productPage = productService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("productPage", productPage);
		if(product != null && product.getUsage()!=null)
		{
			return product.getUsage();
		}
		else {
			return SUCCESS;
		}
	}
	
	public String findAllForUpdate() {
		ProductPage productPage = productService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("productPage", productPage);
		return "MakeRecordUpdate";
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public Product getModel() {
		return product;
	}
	
}
