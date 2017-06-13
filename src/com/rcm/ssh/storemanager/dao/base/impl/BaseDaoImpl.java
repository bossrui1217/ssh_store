package com.rcm.ssh.storemanager.dao.base.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.rcm.ssh.storemanager.dao.base.BaseDao;


@Repository("baseDao")
@SuppressWarnings("all")
public  class BaseDaoImpl<T,ID extends Serializable> extends HibernateDaoSupport implements BaseDao<T, ID>{
	//crud HibernateTemplate 

	@Autowired
	public void setXXX(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T findObjectById(Class<T> c, ID id) {
		return getHibernateTemplate().get(c, id);
	}

	@Override
	public List<T> findAll(String hql, Object... args) {
		List <T> list = getHibernateTemplate().find(hql,args);
		return list.isEmpty() ? null : list;
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		List <T> list = getHibernateTemplate().findByCriteria(detachedCriteria);
		return list.isEmpty() ? null: list;
	}
		
	
	
	
	
}
