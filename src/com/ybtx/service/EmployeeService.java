package com.ybtx.service;

import java.util.List;

import com.ybtx.domain.Employee;
import com.ybtx.vo.EmployeePage;


public interface EmployeeService {
	//增加
	public void add(Employee employee);
	//修改
	public void update(Employee employee);
	//删除
	public void delete(Employee employee);
	//查询全部
	public EmployeePage findAll(int currentPage,int pageSize);
	//根据Id查询
	public Employee findById(int eId);
	//查询全部，不分页
	public List<Employee> findAllForList();
}
