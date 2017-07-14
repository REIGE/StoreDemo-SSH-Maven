package com.reige.store.category;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by REIGE on 2017/7/10.
 */
public class CategoryDao extends HibernateDaoSupport{

    public List<Category> findAll() {
        List<Category> list = getHibernateTemplate().find("from Category");
        return list;
    }
}
