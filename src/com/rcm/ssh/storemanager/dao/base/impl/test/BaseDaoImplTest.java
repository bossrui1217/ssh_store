package com.rcm.ssh.storemanager.dao.base.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rcm.ssh.storemanager.dao.base.BaseDao;
import com.rcm.ssh.storemanager.domain.Userinfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class BaseDaoImplTest {
	@Autowired
	private BaseDao<Userinfo,String> userDao;
	
	@Test
	public void testSave(){
		Userinfo u = new Userinfo();
		u.setName("»Ê×Ó");
		u.setPassword("123");
		userDao.save(u);
	}
	
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindObjectById() {
		System.out.println(userDao.findObjectById(Userinfo.class, "4028a9d55a5babda015a5babdc160000"));
	}

	@Test
	public void testFindAll() {
		 System.out.println(userDao.findAll("from Userinfo"));
		//System.out.println(userDao.findAll("from Userinfo where name = ? and password = ?", "liu", "123"));
	}

	@Test
	public void testFindByCriteria() {
		DetachedCriteria c = DetachedCriteria.forClass(Userinfo.class);// from
																		// Userinfo
		c.add(Restrictions.eq("name", "ÕÅÑ§ÓÑ"));
		List<Userinfo> list = userDao.findByCriteria(c);
		System.out.println(list);
	}

}
