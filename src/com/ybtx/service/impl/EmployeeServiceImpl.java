package com.ybtx.service.impl;

import java.util.List;

import com.ybtx.dao.EmployeeDao;
import com.ybtx.domain.Employee;
import com.ybtx.domain.Make;
import com.ybtx.service.EmployeeService;
import com.ybtx.vo.EmployeePage;
import com.ybtx.vo.MakePage;


public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public void add(Employee employee) {
		employeeDao.add(employee);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}

	@Override
	public EmployeePage findAll(int currentPage, int pageSize) {
		//根据传入的参数（当前页、页规模），返回OrgPage对象，保存有分页信息:所有记录、当前页、页size、总记录数量、总页数
		EmployeePage employeePage = new EmployeePage();
		List<Employee> list = employeeDao.findAll(currentPage, pageSize);
		employeePage.setDataList(list);
		employeePage.setCurrentPage(currentPage);
		employeePage.setPageSize(pageSize);
		int totalCount = employeeDao.findTotalCount();
		employeePage.setTotalCount(totalCount);
		employeePage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return employeePage;
	}

	@Override
	public Employee findById(int eId) {
		return employeeDao.findById(eId);
	}
	
}
