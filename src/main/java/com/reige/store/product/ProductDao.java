package com.reige.store.product;

import com.reige.store.utils.PageHibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by REIGE on 2017/7/10.
 */
@SuppressWarnings("unchecked")
public class ProductDao extends HibernateDaoSupport {


    public List<Product> findHot() {
//        DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
//        criteria.add(Restrictions.eq("is_hot",1));
//        List<Product> list = getHibernateTemplate().findByCriteria(criteria);
        List<Product> list = getHibernateTemplate().executeFind(new PageHibernateCallback<Product>
                ("from Product where is_hot = ?", new Object[]{1}, 0, 10));
        return list;
    }

    public List<Product> findNew() {
        String hql = "from Product order by pdate desc";
        List<Product> list = getHibernateTemplate().executeFind(new PageHibernateCallback<Product>
                (hql, null, 0, 10));
        return list;
    }

    public List<Product> findByCid() {
        String hql = "from Product p,Category c where p. order by pdate desc";
        List<Product> list = getHibernateTemplate().executeFind(new PageHibernateCallback<Product>
                (hql, null, 0, 10));
        return list;
    }

    //select count(*) from product p ,categorysecond cs where p.csid=cs.csid and cs.cid = 1
//
    @SuppressWarnings("all")
    public Integer findCountByCid(Integer cid) {
        String hql = "select count(*) from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
        List<Long> list = getHibernateTemplate().find(hql, cid);
        return list.get(0).intValue();
    }

    public List<Product> findByPage(Integer cid, int begin, int limit) {
        String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
        List<Product> list = getHibernateTemplate().executeFind(
                new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
        return list;
    }

    public Integer findCountByCsid(Integer csid) {
        String hql = "select count(*) from Product p join p.categorySecond cs where cs.csid = ?";
        List<Long> list = getHibernateTemplate().find(hql, csid);
        return list.get(0).intValue();
    }

    public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
        String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
        List<Product> list = getHibernateTemplate().executeFind(
                new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit));
        return list;
    }

    public Product finByPid(Integer pid) {
        List list = getHibernateTemplate().find("from Product where pid = ?", pid);
        return (Product) list.get(0);
    }
}
