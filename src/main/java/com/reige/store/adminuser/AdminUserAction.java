package com.reige.store.adminuser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

/**
 * Created by REIGE on 2017/7/15.
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{

    private AdminUser adminUser = new AdminUser();

    private AdminUserService adminUserService;
    @Override
    public AdminUser getModel() {
        return adminUser;
    }

    public void setAdminUserService(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    /**
     * 后台登陆方法
     * @return
     */
    public String login(){
        AdminUser existAdminUser = adminUserService.login(adminUser);

        if (existAdminUser==null){
            addActionError("用户名或密码错误");
            return LOGIN;
        }else {
            ServletActionContext.getRequest().getSession().setAttribute("existAdminUser",existAdminUser);
            return "loginSuccess";
        }
    }


}
