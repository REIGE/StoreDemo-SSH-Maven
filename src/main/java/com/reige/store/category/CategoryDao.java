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
    // DAO层添加一级分类的代码
    public void save(Category category) {
        this.getHibernateTemplate().save(category);
    }

    // DAO层的删除一级分类
    public void delete(Category category) {
        category = this.getHibernateTemplate().get(Category.class, category.getCid());
        this.getHibernateTemplate().delete(category);
    }

    // DAO层查询一级分类
    public Category findByCid(Integer cid) {
        return this.getHibernateTemplate().get(Category.class, cid);
    }

    // DAO层的修改一级分类
    public void update(Category category) {
        this.getHibernateTemplate().update(category);
    }
}
