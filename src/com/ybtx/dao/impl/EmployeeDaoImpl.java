package com.ybtx.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ybtx.dao.EmployeeDao;
import com.ybtx.dao.ProductDao;
import com.ybtx.domain.Employee;
import com.ybtx.domain.Product;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{

	@Override
	public void add(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}

	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}

	@Override
	public List<Employee> findAll(int currentPage, int pageSize) {
		//找到所有产品，实现分页功能
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Employee");
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
		Long count = (Long) this.getHibernateTemplate().find("select count(*) from Employee").iterator().next();
		return count.intValue();
	}

	@Override
	public Employee findById(int eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public List<Employee> findAllForList() {
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Employee");
				List<Product> list = query.list();
				return list;
			}
		});
		return list;
	}
}
