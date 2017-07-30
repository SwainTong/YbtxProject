package com.ybtx.service;


import java.util.List;

import com.ybtx.domain.Make;
import com.ybtx.vo.MakePage;

public interface MakeService {
	//增加
	public void add(Make make);
	//修改
	public void update(Make make);
	//删除
	public void delete(Make make);
	//查询全部
	public MakePage findAll(int currentPage,int pageSize);
	//按Id查询
	public MakePage findById(int Id,int currentPage,int pageSize);
	//直接使用sql查询
	public List queryBySql(String sql);
}
