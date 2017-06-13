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

@Controller("storeAction") // spring 创建action对象
@Scope("prototype") // action 多例
@Namespace("/") // 名称空间
@ParentPackage("ssh_store") // 当前action继承哪一个包
public class StoreAction extends ActionSupport implements ModelDriven<Store> {
	private Store model = new Store();

	@Override
	public Store getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	// 注入业务层对象
	@Autowired
	private StoreService storeService;

	// value 请求虚拟路径 @Result 配置结果集 name 结果集视图名称 location 结果集跳转路径 type 结果集类型 转发
	// 重定向
	@Action(value = "storeAction_delete", results = {
			@Result(name = "delete", type = "redirectAction", location = "storeAction_list") })
	public String delete() {
		storeService.delete(model);// model 托管态Store
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
		// 工具类 将 对象 转换 json字符串
		ActionContext.getContext().getValueStack().push(stores);// 查询目标需要序列化对象
																// 需要存放到值栈中
		return "ajaxList";
	}


}
