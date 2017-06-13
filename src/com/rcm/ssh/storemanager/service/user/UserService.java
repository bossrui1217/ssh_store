package com.rcm.ssh.storemanager.service.user;

import com.rcm.ssh.storemanager.domain.Userinfo;

public interface UserService {
	Userinfo findUserByNameAndPassword(String name,String password);
}
