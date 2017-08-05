package com.ybtx.dao;

import java.util.List;

import com.ybtx.domain.Product;

public interface ProductDao {
	//增加
	public void add(Product product);
	//修改
	public void update(Product product);
	//删除
	public void delete(Product product);
	//查询全部
	public List<Product> findAll(int currentPage,int pageSize);
	//返回查询结果的记录条数
	public int findTotalCount();
	//根据id去查询产品
	public Product findById(int pId);
	//不分页的查询全部
	public List<Product> findAllForList();
	/*public Organization findBookById(int oid);
	public int findTotalCount();*/
	
	/*public Activity findActivityById(int aid);*/
}
