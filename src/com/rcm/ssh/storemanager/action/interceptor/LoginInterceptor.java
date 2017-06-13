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
		// 登录认证 如果用户没有登录 不允许访问目标action业务方法的 如果用户登录 放行...
		Userinfo existUser = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if (existUser == null) {
			return "no_login";// 定义结果集 ...
		}
		return invocation.invoke();
	}

}
