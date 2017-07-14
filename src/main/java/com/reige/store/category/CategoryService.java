package com.reige.store.category;

import java.util.List;

/**
 * Created by REIGE on 2017/7/10.
 */
public class CategoryService {



    private CategoryDao categoryDao;
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
