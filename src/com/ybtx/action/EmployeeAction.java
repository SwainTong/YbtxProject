package com.ybtx.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
//import com.sun.org.apache.regexp.internal.recompile;
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
	//更新数据库数据
	public String update() {
		employeeService.update(employee);
		return SUCCESS;
	}
	//删除
	public String delete() {
		Employee employeeById = employeeService.findById(employee.getEmployeeId());
		employeeService.delete(employeeById);
		return SUCCESS;
	}
	//查找数据库中的所有数据
	public String findAll() {
		
		if(employee != null && employee.getUsage() != null)
		{
			//如果不是为了在管理页展示而查询，那就不用分页
			List<Employee> employeeList = employeeService.findAllForList();
			ServletActionContext.getRequest().setAttribute("employeePage", employeeList);
			return employee.getUsage();
		}
		else {
			//分页，每页固定条数
			EmployeePage employeePage = employeeService.findAll(currentPage, pageSize);
			ServletActionContext.getRequest().setAttribute("employeePage", employeePage);
			return SUCCESS;
		}
	}

	public String findAllForUpdate() {
		List<Employee> employeeList = employeeService.findAllForList();
		ServletActionContext.getRequest().setAttribute("employeePage", employeeList);
		return "MakeRecordUpdate";
	}
	
	
	
	//根据Id查找员工信息
	public String findById() {
		Employee employeeById = employeeService.findById(employee.getEmployeeId());
		ServletActionContext.getRequest().setAttribute("employeeById", employeeById);
		return "findById";
	}
	
}
