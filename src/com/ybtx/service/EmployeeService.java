package com.ybtx.service;

import java.util.List;

import com.ybtx.domain.Employee;
import com.ybtx.vo.EmployeePage;


public interface EmployeeService {
	//����
	public void add(Employee employee);
	//�޸�
	public void update(Employee employee);
	//ɾ��
	public void delete(Employee employee);
	//��ѯȫ��
	public EmployeePage findAll(int currentPage,int pageSize);
	//����Id��ѯ
	public Employee findById(int eId);
	//��ѯȫ��������ҳ
	public List<Employee> findAllForList();
}
