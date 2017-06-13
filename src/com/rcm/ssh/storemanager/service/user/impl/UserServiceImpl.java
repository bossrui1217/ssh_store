package com.rcm.ssh.storemanager.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcm.ssh.storemanager.dao.user.UserDao;
import com.rcm.ssh.storemanager.domain.Userinfo;
import com.rcm.ssh.storemanager.service.user.UserService;
//业务层实现类
@Service
@Transactional
public class UserServiceImpl  implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public Userinfo findUserByNameAndPassword(String name, String password) {
		List<Userinfo> list = userDao.findAll("from Userinfo where name =? and password =?", name,password); 
		if(list==null||list.size()==0){
			return null;
		}else{
			
			return list.get(0);
		}
		
	}

}
