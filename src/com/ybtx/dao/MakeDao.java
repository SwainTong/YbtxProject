package com.ybtx.dao;

import java.util.List;

import com.ybtx.domain.Make;

public interface MakeDao {
	//增加
	public void add(Make make);
	//修改
	public void update(Make make);
	//删除
	public void delete(Make make);
	//查询全部
	public List<Make> findAll(int currentPage,int pageSize);
	//返回查询结果的记录条数
	public int findTotalCount();
	//根据id去查询生产记录
	public List<Make> findById(int Id,int currentPage,int pageSize);
	/*public Organization findBookById(int oid);
	public int findTotalCount();*/
	
	/*public Activity findActivityById(int aid);*/
}
