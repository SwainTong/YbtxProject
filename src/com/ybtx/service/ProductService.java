package com.ybtx.service;

import java.util.List;

import com.ybtx.domain.Product;
import com.ybtx.vo.ProductPage;

public interface ProductService {
	//����
	public void add(Product product);
	//�޸�
	public void update(Product product);
	//ɾ��
	public void delete(Product product);
	//��ѯȫ��
	public ProductPage findAll(int currentPage,int pageSize);
	//ͨ��ID����
	public Product findById(int pId);
}
