package com.rcm.ssh.storemanager.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

//ID指的查询的对象主键类型
public interface BaseDao<T,ID extends Serializable> {
	public void save(T t);

	public void delete(T t);

	public void update(T t);

	// session.get(Class ,id int String)
	// goods session.get(Goods.class, "1111")
	// user session.get(User.class,100)
	public T findObjectById(Class<T> c, ID id);

	public List<T> findAll(String hql, Object... args);

	// 实现类 from Goods where xxx = ? from Userinfo
	// hibernate qbc 查询 DetachedCriteria 将条件web封装
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);

}
