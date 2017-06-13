package com.rcm.ssh.storemanager.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.rcm.ssh.storemanager.dao.base.impl.BaseDaoImpl;
import com.rcm.ssh.storemanager.dao.user.UserDao;
import com.rcm.ssh.storemanager.domain.Userinfo;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Userinfo, String> implements UserDao {
	// 扩展的业务方法..
 
}
