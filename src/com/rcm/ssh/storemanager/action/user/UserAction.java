package com.rcm.ssh.storemanager.action.user;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.rcm.ssh.storemanager.domain.Userinfo;
import com.rcm.ssh.storemanager.service.user.UserService;

@Controller("userAction")//spring创建action对象
@Scope("prototype") //action多例
@Namespace("/") //名称空间
@ParentPackage("ssh_store") //当前action继承哪个包
public class UserAction  extends ActionSupport implements ModelDriven<Userinfo>{
	private Userinfo model=new Userinfo();
	
	@Override
	public Userinfo getModel() {
		return model;
	}
	
	// 注入业务层对象
		@Autowired
		private UserService userService;

		// value 请求虚拟路径 @Result 配置结果集 name 结果集视图名称 location 结果集跳转路径 type 结果集类型 转发
		// 重定向
		@Action(value = "userAction_login", results = { @Result(name = "login_error", location = "/login.jsp"),
				@Result(name = "login_ok", type = "redirect", location = "/jsps/main.jsp") })
		public String login() {
			Userinfo existUser = userService.findUserByNameAndPassword(model.getName(), model.getPassword());
			if (existUser == null) {
				// 数据库没有查询到 登录失败
				this.addActionError(this.getText("login.nameOrpassword.error"));
				return "login_error";
			} else {
				// 用户存在
				ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
				return "login_ok";
			}
		}

}
