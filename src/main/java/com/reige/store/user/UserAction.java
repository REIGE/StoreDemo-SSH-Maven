package com.reige.store.user;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by REIGE on 2017/7/8.
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

    //struts2中模型驱动使用的类
    private User user = new User();
    //注入userService
    private UserService userService;

    private String checkCode;

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    @Override
    public User getModel() {
        return user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    //登陆功能
    @InputConfig(resultName = "loginInput")
    public String login() {
//        System.out.println("login:"+user.getUsername()+user.getPassword());
        User existUser = userService.login(user);
        if (existUser == null) {
            this.addActionError("用户名或密码错误");
            return "loginInput";
        } else {
            ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
            return "loginSuccess";
        }
    }

    @InputConfig(resultName = "registInput")
    public String regist() {
        //从session中获取缓存的验证码
        String realCheckcode = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
        ServletActionContext.getRequest().getSession().removeAttribute("checkcode");
        if (checkCode == null || !checkCode.equalsIgnoreCase(realCheckcode)) {
            addActionMessage("验证码错误");
            System.out.println("realCheckcode：" + realCheckcode);
            System.out.println("realCheckcode：" + realCheckcode);
            System.out.println("验证码错误");
            return "registInput";
        }
        userService.regist(user);
        addActionMessage("注册成功! 请去邮箱激活");
        System.out.println("注册成功");
        return "registSuccess";
    }

    /**
     * 跳转到登录页面的方法
     */
    public String loginPage() {
        return "loginPageSuccess";
    }

    /**
     * 挑转到注册页面的方法
     *
     * @return
     */
    public String registPage() {
        return "registPageSuccess";
    }

    public String checkUserName() throws IOException {
        User existUser = userService.findByUserName(user.getUsername());
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        if (existUser == null) {
            response.getWriter().print("<font color='green'>用户名可以使用</font>");
        } else {
            response.getWriter().print("<font color='red'>用户名已经存在</font>");
        }
        return NONE;
    }

    /**
     * 退出登陆
     */
    public String quit() {
        ServletActionContext.getRequest().getSession().invalidate();
        return "quitSuccess";
    }
}
