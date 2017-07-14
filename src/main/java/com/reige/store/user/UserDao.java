package com.reige.store.user;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by REIGE on 2017/7/9.
 */
@SuppressWarnings({"unchecked", "JpaQlInspection"})
public class UserDao extends HibernateDaoSupport {

    public UserDao() {

    }

    /**
     * 保存用户
     *
     * @param user
     */
    public void save(User user) {
        getHibernateTemplate().save(user);
    }


    /**
     *
     * @param code
     * @return
     */
    public User findByCode(String code) {
        String hql = "from User where code = ?";
        List<User> list = getHibernateTemplate().find(hql, code);
        if (list.size() != 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 通过用户名查找user
     *
     * @param name
     * @return
     */
    public User findByUserName(String name) {
        List<User> list = getHibernateTemplate().find("from User where username = ?", name);
        return list.size() == 0 ? null : list.get(0);
    }

    /**
     * dao层登陆
     *
     * @param user
     * @return
     */
    public User login(User user) {
        List<User> list = getHibernateTemplate().find("from User where username = ? and password = ? and state = ?"
                , user.getUsername(), user.getPassword(), 1);
        return list.size() == 0 ? null : list.get(0);
    }

    /**
     * DAO层修改用户的方法
     *
     * @param existUser
     */
    public void update(User existUser) {
        this.getHibernateTemplate().update(existUser);
    }

}
