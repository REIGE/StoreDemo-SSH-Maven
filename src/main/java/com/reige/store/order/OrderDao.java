package com.reige.store.order;

import com.reige.store.utils.PageBean;
import com.reige.store.utils.PageHibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by REIGE on 2017/7/14.
 */
public class OrderDao extends HibernateDaoSupport{


    public Integer save(Order order) {
        Integer oid = (Integer)getHibernateTemplate().save(order);
        return oid;
    }

    // 查询订单的数量
    public Integer findCount() {
        List<Long> list = this.getHibernateTemplate().find("select count(*) from Order");
        return list.get(0).intValue();
    }

    // 查询每页显示的订单数据
    public List<Order> findByPage(Integer begin, Integer limit) {
        String hql = "from Order order by ordertime desc";
        List<Order> list = this.getHibernateTemplate().executeFind(new PageHibernateCallback<Order>(hql, null, begin, limit));
        return list;
    }

    public Integer findCount(Integer state) {
        List<Long> list = this.getHibernateTemplate().find("select count(*) from Order where state = ?",state);
        return list.get(0).intValue();
    }

    public List<Order> findByPage(Integer state, Integer begin, Integer limit) {
        String hql = "from Order where state = ? order by ordertime desc";
        List<Order> list = this.getHibernateTemplate().executeFind(new PageHibernateCallback<Order>(hql, new Object[]{state}, begin, limit));
        return list;
    }
}
