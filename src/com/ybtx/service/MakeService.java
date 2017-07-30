package com.ybtx.service;


import java.util.List;

import com.ybtx.domain.Make;
import com.ybtx.vo.MakePage;

public interface MakeService {
	//����
	public void add(Make make);
	//�޸�
	public void update(Make make);
	//ɾ��
	public void delete(Make make);
	//��ѯȫ��
	public MakePage findAll(int currentPage,int pageSize);
	//��Id��ѯ
	public MakePage findById(int Id,int currentPage,int pageSize);
	//ֱ��ʹ��sql��ѯ
	public List queryBySql(String sql);
}
