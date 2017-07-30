package com.ybtx.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ybtx.domain.Make;
import com.ybtx.service.EmployeeService;
import com.ybtx.service.MakeService;
import com.ybtx.service.ProductService;
import com.ybtx.vo.MakePage;

public class MakeAction extends ActionSupport implements ModelDriven<Make>{
	//模型驱动
	private Make make = new Make();
	//spring中调用service
	private MakeService makeService;
	private EmployeeService employeeService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	private ProductService productService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public void setMakeService(MakeService makeService) {
		this.makeService = makeService;
	}
	//分页规模
	private int currentPage = 1;
	private int pageSize = 10;
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
	
	
	public Make getMake() {
		return make;
	}
	public void setMake(Make make) {
		this.make = make;
	}
	
	//向数据库添加生产记录
	public String add() {
		//生产记录中，Employee和Product都是类对象，不能直接从页面表单获得到
		//从页面可以获得到Employee和Product对象的ID
		//再调用findById方法
		make.setEmployee(employeeService.findById(make.getEmployeeId()));
		make.setProduct(productService.findById(make.getProductId()));
		makeService.add(make);
		return SUCCESS;	
	}
	//查找数据库中的所有数据
	public String findAll() {
		MakePage makePage = makeService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("makePage", makePage);
		return SUCCESS;
	}
	//根据id查询生产记录
	public String fingById() {
		MakePage makePage = makeService.findById(make.getMakeId(),currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("makePage", makePage);
		return SUCCESS;		
	}
	
	@Override
	public Make getModel() {
		return make;
	}
	
}
