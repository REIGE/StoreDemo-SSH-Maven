package com.reige.store.user;

import com.reige.store.utils.UUIDUtils;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by REIGE on 2017/7/8.
 */
@Transactional
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService() {

    }

    /**
     * 业务层注册用户的带码
     *
     * @param user
     */
    public void regist(User user) {
        // 0 未激活 1 激活
        user.setState(0);
        String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
        user.setCode(code);
        userDao.save(user);
        // TODO: 2017/7/9 发送注册邮件
    }

    /**
     * 业务层根据激活码查询用户
     *
     * @param code
     * @return
     */
    public User findByCode(String code) {
        return userDao.findByCode(code);
    }

    /**
     * 修改用户
     *
     * @param existUser
     */
    public void update(User existUser) {
        userDao.update(existUser);
    }

    /**
     * 登陆
     *
     * @param user
     * @return
     */
    public User login(User user) {
        return userDao.login(user);
    }

    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return
     */
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

}
