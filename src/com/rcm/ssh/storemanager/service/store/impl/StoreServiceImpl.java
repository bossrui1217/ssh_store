package com.rcm.ssh.storemanager.service.store.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcm.ssh.storemanager.dao.store.StoreDao;
import com.rcm.ssh.storemanager.domain.Store;
import com.rcm.ssh.storemanager.service.store.StoreService;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDao storeDao;

	@Override
	public void save(Store model) {
		storeDao.save(model);
	}
	

	@Override
	public List<Store> findAll() {
		return storeDao.findAll("from Store");
	}

	@Override
	public void delete(Store model) {
		// TODO Auto-generated method stub
		storeDao.delete(model);
	}


	@Override
	public void update(Store model) {
		storeDao.update(model);
		
	}


	@Override
	public Store findStore(Store model) {
		// TODO Auto-generated method stub
		return storeDao.findAll("from Store where id = ?",model.getId()).get(0);
	}

}
