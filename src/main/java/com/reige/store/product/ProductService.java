package com.reige.store.product;

import com.reige.store.utils.PageBean;

import java.util.List;

/**
 * Created by REIGE on 2017/7/10.
 */
public class ProductService {

    ProductDao productDao;


    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List findHot() {
        return productDao.findHot();
    }

    public List<Product> findNew() {
        return productDao.findNew();
    }

    public List<Product> findByCid() {
        return productDao.findByCid();
    }

    public PageBean<Product> findByPage(Integer cid, Integer page) {
        int limit = 12;
        int totalPage = 0;
        PageBean<Product> pageBean = new PageBean<Product>();
        pageBean.setPage(page);
        pageBean.setLimit(limit);
        Integer totalCount = productDao.findCountByCid(cid);
        pageBean.setTotalCount(totalCount);
        if (totalCount%limit==0){
            totalPage = totalCount/limit;
        }else {
            totalPage = totalCount/limit +1;
        }
        pageBean.setTotalPage(totalPage);
        //商品数据集合
        int begin = (page - 1 )*limit;//计算开始的位置
        pageBean.setList(productDao.findByPage(cid,begin,limit));
        return pageBean;
    }

    public PageBean<Product> findByCsid(Integer csid, Integer page) {
        int limit = 12;
        int totalPage = 0;
        PageBean<Product> pageBean = new PageBean<Product>();
        pageBean.setPage(page);
        pageBean.setLimit(limit);
        Integer totalCount = productDao.findCountByCsid(csid);
        pageBean.setTotalCount(totalCount);
        if (totalCount%limit==0){
            totalPage = totalCount/limit;
        }else {
            totalPage = totalCount/limit +1;
        }
        pageBean.setTotalPage(totalPage);
        //商品数据集合
        int begin = (page - 1 )*limit;//计算开始的位置
        pageBean.setList(productDao.findByPageCsid(csid,begin,limit));
        return pageBean;
    }

    public Product findByPid(Integer pid) {
        return productDao.finByPid(pid);
    }
}
