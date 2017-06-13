package com.rcm.ssh.storemanager.dao.store.impl;

import org.springframework.stereotype.Repository;

import com.rcm.ssh.storemanager.dao.base.impl.BaseDaoImpl;
import com.rcm.ssh.storemanager.dao.store.StoreDao;
import com.rcm.ssh.storemanager.domain.Store;
@Repository("storeDao")
public class StoreDaoImpl  extends BaseDaoImpl<Store, String> implements StoreDao{
	//扩展业务的方法
}
