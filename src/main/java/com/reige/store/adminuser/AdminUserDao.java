package com.reige.store.adminuser;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by REIGE on 2017/7/15.
 */
@SuppressWarnings("all")
public class AdminUserDao extends HibernateDaoSupport{
    public AdminUser login(AdminUser adminUser) {
        List<AdminUser> list = getHibernateTemplate().find(
                "from AdminUser where username = ? and password = ?",
                adminUser.getUsername(), adminUser.getPassword());
        return list.get(0);
    }
}
