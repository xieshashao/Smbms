package com.bdqn.util;

import com.bdqn.pojo.Bill;
import com.bdqn.pojo.User;

import java.util.List;

/**
 * Created by java on 2017-8-23.
 */
public class PageUtil {
    private Integer pageSize;  //每页显示记录数
    private Integer pageIndex;  //当前页码
    private Integer totalRecords; //总记录数
    private Integer totalPages; //总页数
    private List<User> list;  //数据
    private List<Bill> li;  //数据

    public List<Bill> getLi() {
        return li;
    }

    public void setLi(List<Bill> li) {
        this.li = li;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
