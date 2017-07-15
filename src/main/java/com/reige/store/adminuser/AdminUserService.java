package com.reige.store.adminuser;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by REIGE on 2017/7/15.
 */
@Transactional
public class AdminUserService {

    private AdminUserDao adminUserDao;

    public void setAdminUserDao(AdminUserDao adminUserDao) {
        this.adminUserDao = adminUserDao;
    }

    public AdminUser login(AdminUser adminUser) {
        return adminUserDao.login(adminUser);
    }
}
