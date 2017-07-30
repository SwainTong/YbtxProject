package com.ybtx.dao;

import java.util.List;

import com.ybtx.domain.Make;

public interface MakeDao {
	//����
	public void add(Make make);
	//�޸�
	public void update(Make make);
	//ɾ��
	public void delete(Make make);
	//��ѯȫ��
	public List<Make> findAll(int currentPage,int pageSize);
	//���ز�ѯ����ļ�¼����
	public int findTotalCount();
	//����idȥ��ѯ������¼
	public List<Make> findById(int Id,int currentPage,int pageSize);
	/*public Organization findBookById(int oid);
	public int findTotalCount();*/
	
	/*public Activity findActivityById(int aid);*/
}
