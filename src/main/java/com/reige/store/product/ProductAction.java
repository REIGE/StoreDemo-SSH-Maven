package com.reige.store.product;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.reige.store.category.Category;
import com.reige.store.category.CategoryService;
import com.reige.store.utils.PageBean;

import java.util.List;

/**
 * Created by REIGE on 2017/7/10.
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product> {

    private Integer cid;//一级分类编号
    private Integer csid;//二级分类号


    private Integer page;

    private Product product = new Product();

    ProductService productService;
    CategoryService categoryService;

    private PageBean<Product> pageBean;


    public PageBean<Product> getPageBean() {
        return pageBean;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }


    @Override
    public Product getModel() {
        return product;
    }

    public String findByCid() {
        // 查询分类:
        // 查询所有一级分类:
        List<Category> categoryList = categoryService.findAll();
        // 获得值栈:
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);
        pageBean = productService.findByPage(cid, page);
        return "findByCidSuccess";
    }

    public String findByCsid() {
        // 查询分类:
        // 查询所有一级分类:
        List<Category> categoryList = categoryService.findAll();
        // 获得值栈:
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);

        pageBean = productService.findByCsid(csid, page);
        return "findByCsidSuccess";
    }

    public String findByPid(){

        // 查询所有一级分类:
        List<Category> categoryList = categoryService.findAll();
        // 获得值栈:
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);

        product = productService.findByPid(product.getPid());

        return "findByPidSuccess";
    }

}
