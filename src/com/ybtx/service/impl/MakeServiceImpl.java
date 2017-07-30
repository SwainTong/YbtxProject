package com.ybtx.service.impl;

import java.util.List;

import com.ybtx.dao.MakeDao;
import com.ybtx.domain.Make;
import com.ybtx.service.MakeService;
import com.ybtx.vo.MakePage;


public class MakeServiceImpl implements MakeService{

	MakeDao makeDao;
	
	public MakeDao getMakeDao() {
		return makeDao;
	}

	public void setMakeDao(MakeDao makeDao) {
		this.makeDao = makeDao;
	}

	public void setProductDao(MakeDao makeDao) {
		this.makeDao = makeDao;
	}

	@Override
	public void add(Make make) {
		makeDao.add(make);
	}

	@Override
	public void update(Make make) {
		makeDao.update(make);
	}

	@Override
	public void delete(Make make) {
		makeDao.delete(make);
	}

	@Override
	public MakePage findAll(int currentPage, int pageSize) {
		//���ݴ���Ĳ�������ǰҳ��ҳ��ģ��������OrgPage���󣬱����з�ҳ��Ϣ:���м�¼����ǰҳ��ҳsize���ܼ�¼��������ҳ��
		MakePage makePage = new MakePage();
		List<Make> list = makeDao.findAll(currentPage, pageSize);
		makePage.setDataList(list);
		makePage.setCurrentPage(currentPage);
		makePage.setPageSize(pageSize);
		int totalCount = makeDao.findTotalCount();
		makePage.setTotalCount(totalCount);
		makePage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return makePage;
	}

	@Override
	public MakePage findById(int Id,int currentPage, int pageSize) {
		//���ݴ���Ĳ�������ǰҳ��ҳ��ģ��������OrgPage���󣬱����з�ҳ��Ϣ:���м�¼����ǰҳ��ҳsize���ܼ�¼��������ҳ��
		MakePage makePage = new MakePage();
		List<Make> list = makeDao.findById(Id,currentPage, pageSize);
		makePage.setDataList(list);
		makePage.setCurrentPage(currentPage);
		makePage.setPageSize(pageSize);
		int totalCount = 1;
		makePage.setTotalCount(totalCount);
		makePage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return makePage;
	}
	
	@Override
	public List queryBySql(String sql) {    
        List<Object[]> list = makeDao.queryBySql(sql);    
        return list;    
    }   
}
