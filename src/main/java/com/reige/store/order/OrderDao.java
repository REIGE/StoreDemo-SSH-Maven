package com.reige.store.order;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;

/**
 * Created by REIGE on 2017/7/14.
 */
public class OrderDao extends HibernateDaoSupport{


    public Integer save(Order order) {
        Integer oid = (Integer)getHibernateTemplate().save(order);
        return oid;
    }
}
