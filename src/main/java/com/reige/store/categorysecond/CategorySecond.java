package com.reige.store.categorysecond;

import com.reige.store.category.Category;
import com.reige.store.product.Product;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by REIGE on 2017/7/10.
 */
public class CategorySecond {
    private Integer csid;
    private String csname;

    // 二级分类所属的一级分类:
    private Category category;
    // 关联的商品的集合
    private Set<Product> products = new HashSet<Product>();

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
