package com.bdqn.service.Impl;

import com.bdqn.dao.UserDao;
import com.bdqn.pojo.User;
import com.bdqn.service.UserService;
import com.bdqn.util.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by java on 2017/8/20.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
       //植入dao对象
    @Resource
    private   UserDao  userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public UserDao getUserService() {

        return userDao;
    }

    public void setUserService(UserDao userService) {
        this.userDao = userService;
    }


    public List<User> getUser() {   //列表及分页
        return userDao.getUser();
    }

    public List<User> Mall(String userName) {   //模糊查询
        return userDao.Mall(userName);
    }


    public int add(User user) {     //添加用户
        return userDao.add(user);
    }

    public User getAll(int id) {   //根据id查询所有
        return userDao.getAll(id);
    }

    public int update(User id) {    //修改
        return userDao.update(id);
    }

    public int del(int uid) {  //删除
        return userDao.del(uid);
    }

    //2.获取总记录数
    public int getTotalCount() {
        return userDao.getTotalCount();
    }
    //3.获取一页用户数据
    public PageUtil getOnePageData(int pageIndex,int pageSize) {

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",pageIndex*pageSize);
        map.put("pageSize",pageSize);

        PageUtil page=new PageUtil(); //实例化一个PageUtil对象
        page.setPageSize(pageSize); //给PageUtil属性赋值
        page.setPageIndex(pageIndex);//给PageUtil的pageIndex赋值
        //
        int totalCount = userDao.getTotalCount();
        page.setTotalRecords(totalCount);

        int totalPages=page.getTotalRecords()%page.getPageSize()==0?page.getTotalRecords()/page.getPageSize():page.getTotalRecords()/page.getPageSize()+1;
        page.setTotalPages(totalPages);
        //为什么dao层方法的入参我写成map？？？
        List<User> list = userDao.getOnePageData(map);
        page.setList(list);
        return page;
    }

    //获取每一页用户数据   模糊查询
    public PageUtil getOnePageData(int pageIndex, int pageSize, User info) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("userName",info.getUserName());

        PageUtil page=new PageUtil(); //实例化一个PageUtil对象
        page.setPageSize(pageSize); //给PageUtil属性赋值
        page.setPageIndex(pageIndex);//给PageUtil的pageIndex赋值
        //
        int totalCount = userDao.getTotalCountName(info.getUserName());
        page.setTotalRecords(totalCount);

        int totalPages=page.getTotalRecords()%page.getPageSize()==0?page.getTotalRecords()/page.getPageSize():page.getTotalRecords()/page.getPageSize()+1;
        page.setTotalPages(totalPages);
        //为什么dao层方法的入参我写成map？？？
        List<User> list = userDao.getOnePageDatastion(map);
        page.setList(list);
        return page;
    }

    public int getTotalCountName(String userName) {
        return userDao.getTotalCountName(userName);
    }


    public User isLogin(User info) {     //登陆
        return userDao.isLogin(info);
    }

    public int updauser(User id) {  //修改密码
        return userDao.updauser(id);
    }

    public List<User> getfind() {
        return userDao.getfind();
    }


}
