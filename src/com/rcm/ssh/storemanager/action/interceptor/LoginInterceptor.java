package com.rcm.ssh.storemanager.action.interceptor;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.rcm.ssh.storemanager.domain.Userinfo;
@Component("loginInterceptor")
public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// ��¼��֤ ����û�û�е�¼ ���������Ŀ��actionҵ�񷽷��� ����û���¼ ����...
		Userinfo existUser = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if (existUser == null) {
			return "no_login";// �������� ...
		}
		return invocation.invoke();
	}

}
