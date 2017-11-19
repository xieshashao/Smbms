package com.bdqn.dao;

import com.bdqn.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by java on 2017/7/14.
 */
public interface UserDao {
    public  List<User> getUser();//分页及列表

    public  User isLogin(User info);   //登陆
    public int updauser(User id); //修改密码

    public  int del(int uid); //删除

    public int add(User  user);  //添加
    public List<User> Mall(String userName);//模糊查询

    public User getAll(int id);//根据id查询所有
    public int update(User id); //修改用户

    public int getTotalCount(); //获取总记录数
    public List<User> getOnePageData(Map<String,Object> map);//获取单页数据

   //模糊查询的
    public int getTotalCountName(String userName); //获取总记录数
    public List<User> getOnePageDatastion(Map<String,Object> map);//获取单页数据


    public  List<User> getfind();

}
