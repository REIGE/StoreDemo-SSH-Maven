package com.reige.store.utils;

import java.util.List;

/**
 * Created by REIGE on 2017/7/12.
 */
public class PageBean<T> {
    private Integer page;//当前页数
    private Integer limit;//每页显示纪录数
    private Integer totalCount;//总纪录数
    private Integer totalPage;//总页数
    private List<T> list;//显示到浏览器的数据

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
