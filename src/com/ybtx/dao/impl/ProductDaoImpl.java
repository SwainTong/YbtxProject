package com.ybtx.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ybtx.dao.ProductDao;
import com.ybtx.domain.Employee;
import com.ybtx.domain.Product;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao{

	@Override
	public void add(Product product) {
		this.getHibernateTemplate().save(product);
	}

	@Override
	public void update(Product product) {
		this.getHibernateTemplate().update(product);
	}

	@Override
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}

	@Override
	public List<Product> findAll(int currentPage, int pageSize) {
		//找到所有产品，实现分页功能
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Product");
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
		Long count = (Long) this.getHibernateTemplate().find("select count(*) from Product").iterator().next();
		return count.intValue();
	}

	@Override
	public Product findById(int pId) {
		return this.getHibernateTemplate().get(Product.class, pId);
	}

	@Override
	public List<Product> findAllForList() {
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Product");
				List<Product> list = query.list();
				return list;
			}
		});
		return list;
	}

}
