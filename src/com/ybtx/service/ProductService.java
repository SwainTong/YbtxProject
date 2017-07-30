package com.ybtx.service;

import java.util.List;

import com.ybtx.domain.Product;
import com.ybtx.vo.ProductPage;

public interface ProductService {
	//增加
	public void add(Product product);
	//修改
	public void update(Product product);
	//删除
	public void delete(Product product);
	//查询全部
	public ProductPage findAll(int currentPage,int pageSize);
	//通过ID查找
	public Product findById(int pId);
}
