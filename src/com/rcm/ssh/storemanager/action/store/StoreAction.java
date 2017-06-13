package com.rcm.ssh.storemanager.action.store;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.rcm.ssh.storemanager.domain.Store;
import com.rcm.ssh.storemanager.service.store.StoreService;

@Controller("storeAction") // spring ����action����
@Scope("prototype") // action ����
@Namespace("/") // ���ƿռ�
@ParentPackage("ssh_store") // ��ǰaction�̳���һ����
public class StoreAction extends ActionSupport implements ModelDriven<Store> {
	private Store model = new Store();

	@Override
	public Store getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	// ע��ҵ������
	@Autowired
	private StoreService storeService;

	// value ��������·�� @Result ���ý���� name �������ͼ���� location �������ת·�� type ��������� ת��
	// �ض���
	@Action(value = "storeAction_delete", results = {
			@Result(name = "delete", type = "redirectAction", location = "storeAction_list") })
	public String delete() {
		storeService.delete(model);// model �й�̬Store
		return "delete";
	}

	@Action(value = "storeAction_save", results = {
			@Result(name = "save", type = "redirectAction", location = "storeAction_list") })
	public String save() {
		storeService.save(model);
		return "save";
	}
	
	
	@Action(value = "storeAction_findStore", results = {
			@Result(name = "findStore",  location = "/jsps/store/edit.jsp") })
	public String findStore() {
		
		 Store store = storeService.findStore(model);
		 ActionContext.getContext().getValueStack().set("store", store);
		return "findStore";
	}
	
	@Action(value = "storeAction_update", results = {
			@Result(name = "update", type = "redirectAction", location = "storeAction_list") })
	public String update() {
		
		storeService.update(model);
		return "update";
	}
	

	
	@Action(value = "storeAction_list", results = { @Result(name = "list", location = "/jsps/store/store.jsp") })
	public String list() {
		List<Store> stores = storeService.findAll();
		ActionContext.getContext().getValueStack().set("stores", stores);
		return "list";
	}
	

	@Action(value = "storeAction_ajaxList", results = { @Result(name = "ajaxList", type = "json") })
	public String ajaxList() {
		List<Store> stores = storeService.findAll();
		// ������ �� ���� ת�� json�ַ���
		ActionContext.getContext().getValueStack().push(stores);// ��ѯĿ����Ҫ���л�����
																// ��Ҫ��ŵ�ֵջ��
		return "ajaxList";
	}


}
