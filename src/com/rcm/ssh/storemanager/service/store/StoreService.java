package com.rcm.ssh.storemanager.service.store;

import java.util.List;

import com.rcm.ssh.storemanager.domain.Store;

public interface StoreService {
	void save(Store model);
	void update(Store model);

	List<Store> findAll();

	void delete(Store model);
	Store findStore(Store model);

}
