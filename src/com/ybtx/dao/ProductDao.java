package com.ybtx.dao;

import java.util.List;

import com.ybtx.domain.Product;

public interface ProductDao {
	//����
	public void add(Product product);
	//�޸�
	public void update(Product product);
	//ɾ��
	public void delete(Product product);
	//��ѯȫ��
	public List<Product> findAll(int currentPage,int pageSize);
	//���ز�ѯ����ļ�¼����
	public int findTotalCount();
	//����idȥ��ѯ��Ʒ
	public Product findById(int pId);
	//����ҳ�Ĳ�ѯȫ��
	public List<Product> findAllForList();
	/*public Organization findBookById(int oid);
	public int findTotalCount();*/
	
	/*public Activity findActivityById(int aid);*/
}
