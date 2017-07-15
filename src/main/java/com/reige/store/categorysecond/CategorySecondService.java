package com.reige.store.categorysecond;

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
}
