package com.reige.store.categorysecond;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by REIGE on 2017/7/11.
 */
public class CategorySecondDao extends HibernateDaoSupport{
    public List<CategorySecond> findAll() {
        List list = getHibernateTemplate().find("from CategorySecond");
        return list;
    }
}
