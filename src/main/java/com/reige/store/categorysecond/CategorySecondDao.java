package com.reige.store.categorysecond;

import com.reige.store.utils.PageHibernateCallback;
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

    // 查询二级分类的总记录数
    public Integer findCount() {
        List<Long> list = this.getHibernateTemplate().find("select count(*) from CategorySecond");
        if(list.size() > 0){
            return list.get(0).intValue();
        }
        return null;
    }

    // 分页查询
    public List<CategorySecond> findByPage(Integer begin, Integer limit) {
        String hql = "from CategorySecond";
        List<CategorySecond> list = this.getHibernateTemplate().executeFind(new PageHibernateCallback<CategorySecond>(hql, null , begin, limit));
        if(list.size() > 0){
            return list;
        }
        return null;
    }

    // 保存二级分类
    public void save(CategorySecond categorySecond) {
        this.getHibernateTemplate().save(categorySecond);
    }
}
