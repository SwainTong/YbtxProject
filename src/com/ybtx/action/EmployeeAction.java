package com.ybtx.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.regexp.internal.recompile;
import com.ybtx.domain.Employee;
import com.ybtx.domain.Product;
import com.ybtx.service.EmployeeService;
import com.ybtx.service.ProductService;
import com.ybtx.vo.EmployeePage;
import com.ybtx.vo.ProductPage;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//模型驱动
	private Employee employee = new Employee();
	//spring中调用service
	private EmployeeService employeeService;
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
	@Override
	public Employee getModel() {
		return employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	//向数据库添加数据
	public String add() {
		employeeService.add(employee);
		return SUCCESS;	
	}
	//查找数据库中的所有数据
	public String findAll() {
		EmployeePage employeePage = employeeService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("employeePage", employeePage);
		return SUCCESS;
	}
	
	//根据Id查找员工信息
	public String findById() {
		Employee employeeById = employeeService.findById(employee.getEmployeeId());
		ServletActionContext.getRequest().setAttribute("employeeById", employeeById);
		return "findById";
	}
	
}
