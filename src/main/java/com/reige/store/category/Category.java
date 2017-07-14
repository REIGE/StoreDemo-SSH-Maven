package com.reige.store.category;

import com.reige.store.categorysecond.CategorySecond;

import java.util.Set;

/**
 * Created by REIGE on 2017/7/10.
 */
public class Category {
    private Integer cid;
    private String cname;
    private Set<CategorySecond> categorySecond;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<CategorySecond> getCategorySecond() {
        return categorySecond;
    }

    public void setCategorySecond(Set<CategorySecond> categorySecond) {
        this.categorySecond = categorySecond;
    }
}
