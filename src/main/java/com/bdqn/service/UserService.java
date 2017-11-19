package com.bdqn.service;

import com.bdqn.dao.UserDao;
import com.bdqn.pojo.User;
import com.bdqn.util.PageUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by java on 2017/7/14.
 */
public interface UserService {

    public  List<User> getUser();//分页及列表


    public List<User> Mall(String userName);//模糊查询
    public int add(User  user);  //添加
    public User getAll(int id);//根据id获取所有值
    public int update(User id); //修改
    public  int del(int uid); //删除


    //2.获取总记录数
    public int getTotalCount();
    //3.获取单页数据
    public PageUtil getOnePageData(int pageIndex,int pageSize);

    //模糊查询
    public PageUtil getOnePageData(int pageIndex, int pageSize, User info);
    public int getTotalCountName(String userName); //获取总记录数


    public User isLogin(User info);  //登陆
    public int updauser(User id); //修改密码

    public  List<User> getfind();
}
