package com.ybtx.dao;

import java.util.List;

import com.ybtx.domain.Employee;

public interface EmployeeDao {
	//增加
	public void add(Employee employee);
	//修改
	public void update(Employee employee);
	//删除
	public void delete(Employee employee);
	//查询全部
	public List<Employee> findAll(int currentPage,int pageSize);
	//返回查询结果的记录条数
	public int findTotalCount();
	//根据id去查询员工
	public Employee findById(int eid);
	/*public int findTotalCount();*/
	
	/*public Activity findActivityById(int aid);*/
}
