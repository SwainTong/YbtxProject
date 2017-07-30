package com.ybtx.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ybtx.dao.EmployeeDao;
import com.ybtx.dao.MakeDao;
import com.ybtx.dao.ProductDao;
import com.ybtx.domain.Employee;
import com.ybtx.domain.Make;
import com.ybtx.domain.Product;

public class MakeDaoImpl extends HibernateDaoSupport implements MakeDao{
	
	@Override
	public void add(Make make) {
		this.getHibernateTemplate().save(make);
	}

	@Override
	public void update(Make make) {
		this.getHibernateTemplate().update(make);
	}

	@Override
	public void delete(Make make) {
		this.getHibernateTemplate().delete(make);
	}

	@Override
	public List<Make> findAll(int currentPage, int pageSize) {
		//找到所有产品，实现分页功能
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Make");
				query.setFirstResult((currentPage-1)*pageSize);
				query.setMaxResults(pageSize);
				List<Product> list = query.list();
				return list;
			}
		});
		return list;
	}

	@Override
	public int findTotalCount() {
		Long count = (Long) this.getHibernateTemplate().find("select count(*) from Make").iterator().next();
		return count.intValue();
	}

	@Override
	public List<Make> findById(int Id,int currentPage, int pageSize) {
		List<Make> makeList = new ArrayList();
		makeList.add(this.getHibernateTemplate().get(Make.class,Id));
		return makeList;
	} 
    
   
    //直接执行sql语句进行查询的方法
	@Override
    public List queryBySql(String sql) {
    	List<Object[]> list = this.getSession().createSQLQuery(sql).list();
        return list;    
    }    
        
 /*   public int excuteBySql(String sql)    
    {    
        int result ;    
        SQLQuery query = this.getSession().createSQLQuery(sql);    
        result = query.executeUpdate();    
        return result;    
    }    */
}
