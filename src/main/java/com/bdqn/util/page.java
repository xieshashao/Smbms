package com.bdqn.util;

import com.bdqn.pojo.User;

import java.util.List;

/**
 * Created by java on 2017/7/16.
 */
public class page {
    //当前页数
    private  int  pageIndex;
    //页面记录数
    private  int  pageSize;
    //本页显示真实数据
    private List<User> userlist;
    //总页数
    private int  totalpages;
    //总记录数
    private  int  totalRecords;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    public int getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(int totalpages) {
        this.totalpages = totalpages;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
}
