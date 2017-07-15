package com.reige.store.product;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.reige.store.category.Category;
import com.reige.store.category.CategoryService;
import com.reige.store.categorysecond.CategorySecond;
import com.reige.store.categorysecond.CategorySecondService;
import com.reige.store.utils.PageBean;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.io.IOException;

import java.util.Date;
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
    CategorySecondService categorySecondService ;

    private PageBean<Product> pageBean;
    private String uploadFileName;
    private File upload;


    public PageBean<Product> getPageBean() {
        return pageBean;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setCategorySecondService(CategorySecondService categorySecondService) {
        this.categorySecondService = categorySecondService;
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

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUpload(File upload) {
        this.upload = upload;
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

    /**
     * 后台:查询所有商品的方法
     */
    public String adminFindAll(){
        pageBean = productService.findByPage(page);
        return "adminFindAllSuccess";
    }

    /**
     * 跳转到添加页面
     */
    public String addPage(){
        // 查询所有的二级分类 :
        List<CategorySecond> csList = categorySecondService.findAll();
        ActionContext.getContext().getValueStack().set("csList", csList);
        return "addPageSuccess";
    }

    /**
     * 保存商品 同时上传图片
     * @return
     */
    public String save() throws IOException {
        String path = ServletActionContext.getServletContext().getRealPath("/products");
        String realPath = path+ "/" +csid + "/" +uploadFileName;
        File diskFile = new File(realPath);
        //文件上传
        FileUtils.copyFile(upload,diskFile);
        CategorySecond categorySecond = new CategorySecond();
        categorySecond.setCsid(csid);
        //设置时间
        product.setPdate(new Date());

        product.setImage("products/"+csid+"/"+uploadFileName);
        productService.save(product);
        return "saveSuccess";
    }


}
