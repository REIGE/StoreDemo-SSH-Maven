package com.reige.store.interceptor;

import com.reige.store.adminuser.AdminUser;
import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		
		AdminUser existAdminUser = (AdminUser) ServletActionContext
				.getRequest().getSession().getAttribute("existAdminUser");
		if(existAdminUser != null){
			return actionInvocation.invoke();
		}else{
			//如果 existAdminUser为空
			ActionSupport action = (ActionSupport) actionInvocation.getAction();
			action.addActionError("您还没有登录!");
			return action.LOGIN;
		}
	}
}
