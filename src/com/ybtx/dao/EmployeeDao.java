package com.ybtx.dao;

import java.util.List;

import com.ybtx.domain.Employee;

public interface EmployeeDao {
	//����
	public void add(Employee employee);
	//�޸�
	public void update(Employee employee);
	//ɾ��
	public void delete(Employee employee);
	//��ѯȫ��
	public List<Employee> findAll(int currentPage,int pageSize);
	//���ز�ѯ����ļ�¼����
	public int findTotalCount();
	//����idȥ��ѯԱ��
	public Employee findById(int eid);
	/*public int findTotalCount();*/
	
	/*public Activity findActivityById(int aid);*/
}
