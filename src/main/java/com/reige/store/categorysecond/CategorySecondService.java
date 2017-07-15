package com.reige.store.categorysecond;

import com.reige.store.utils.PageBean;

import java.util.List;

/**
 * Created by REIGE on 2017/7/15.
 */

public class CategorySecondService {

    CategorySecondDao categorySecondDao;

    public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
        this.categorySecondDao = categorySecondDao;
    }

    public List<CategorySecond> findAll() {
        return categorySecondDao.findAll();
    }

    public PageBean<CategorySecond> findByPage(Integer page) {
        // 封装PageBean
        PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
        // 封装页数
        pageBean.setPage(page);
        // 每页显示的记录数
        Integer limit = 10;
        pageBean.setLimit(limit);
        // 总记录数
        Integer totalCount = categorySecondDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 总页数
        Integer totalPage = 0;
        if(totalCount % limit == 0){
            totalPage = totalCount/limit;
        }else{
            totalPage = totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        // 每页显示的数据
        Integer begin = (page - 1 )* limit;
        List<CategorySecond> list = categorySecondDao.findByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }
    // 业务层保存二级分类
    public void save(CategorySecond categorySecond) {
        categorySecondDao.save(categorySecond);
    }

}
