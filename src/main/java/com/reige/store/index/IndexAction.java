package com.reige.store.index;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.reige.store.category.Category;
import com.reige.store.category.CategoryService;
import com.reige.store.product.Product;
import com.reige.store.product.ProductService;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * Created by REIGE on 2017/7/8.
 */
public class IndexAction extends ActionSupport{
    // 热门商品的集合
    private List<Product> hotList;
    private List<Product> newList;
    private ProductService productService;
    private CategoryService categoryService;


    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getNewList() {
        return newList;
    }

    public List<Product> getHotList() {
        return hotList;
    }

    @Override
    public String execute() throws Exception {

//        ServletActionContext.getRequest().getSession();
        List<Category> categoryList = categoryService.findAll();
        //将分类信息 存储到session中
        ActionContext.getContext().getSession().put("categoryList",categoryList);
        //查询所有的一级分类
        hotList = (List<Product>) productService.findHot();

        newList = productService.findNew();

        return "indexSuccess";
    }
}
