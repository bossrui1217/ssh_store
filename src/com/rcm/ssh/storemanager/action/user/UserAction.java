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

@Controller("userAction")//spring����action����
@Scope("prototype") //action����
@Namespace("/") //���ƿռ�
@ParentPackage("ssh_store") //��ǰaction�̳��ĸ���
public class UserAction  extends ActionSupport implements ModelDriven<Userinfo>{
	private Userinfo model=new Userinfo();
	
	@Override
	public Userinfo getModel() {
		return model;
	}
	
	// ע��ҵ������
		@Autowired
		private UserService userService;

		// value ��������·�� @Result ���ý���� name �������ͼ���� location �������ת·�� type ��������� ת��
		// �ض���
		@Action(value = "userAction_login", results = { @Result(name = "login_error", location = "/login.jsp"),
				@Result(name = "login_ok", type = "redirect", location = "/jsps/main.jsp") })
		public String login() {
			Userinfo existUser = userService.findUserByNameAndPassword(model.getName(), model.getPassword());
			if (existUser == null) {
				// ���ݿ�û�в�ѯ�� ��¼ʧ��
				this.addActionError(this.getText("login.nameOrpassword.error"));
				return "login_error";
			} else {
				// �û�����
				ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
				return "login_ok";
			}
		}

}
