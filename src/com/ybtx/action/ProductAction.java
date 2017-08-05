package com.ybtx.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ybtx.domain.Employee;
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
		Product dproduct = productService.findById(product.getProductId());
		productService.delete(dproduct);
		return SUCCESS;	
	}
	
	//�������ݿ��е���������
	public String findAll() {
		if(product != null && product.getUsage()!=null)
		{
			//�������Ϊ���ڹ���ҳչʾ����ѯ���ǾͲ��÷�ҳ
			List<Product> productList = productService.findAllForList();
			ServletActionContext.getRequest().setAttribute("productPage", productList);
			return product.getUsage();
		}
		else {
			//��ҳ
			ProductPage productPage = productService.findAll(currentPage, pageSize);
			ServletActionContext.getRequest().setAttribute("productPage", productPage);
			return SUCCESS;
		}
	}
	
	public String findAllForUpdate() {
		List<Product> productList = productService.findAllForList();
		ServletActionContext.getRequest().setAttribute("productPage", productList);
		return "MakeRecordUpdate";
	}
	//����Id���Ҳ�Ʒ��Ϣ
	public String findById() {
		Product nproduct = productService.findById(product.getProductId());
		ServletActionContext.getRequest().setAttribute("nproduct", nproduct);
		return "findById";
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
