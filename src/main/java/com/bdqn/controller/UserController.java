package com.bdqn.controller;

import com.bdqn.pojo.User;
import com.bdqn.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by java on 2017/8/21.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    //植入service
    @Resource(name = "userService")
    UserService  userInfoService;

    //登陆方法
     @RequestMapping("/doLogin")
    public String doLogin(User info, HttpSession session){

         User user=userInfoService.isLogin(info);
         if(user!=null && user.getUserName()!=null){
             //登陆成功
             session.setAttribute("userCode",user.getUserCode());
             return  "welcome";
         }else {
             //登录失败
            return  "login";
         }
     }

     @RequestMapping("/Cloer")    //注销
      public  String  doCl(HttpSession session){
         session.invalidate();
        return "login";
     }

      @RequestMapping("/Upwds")
      public String dopwd(){
        return "password";
      }

     @RequestMapping("/updateuser/{userCode}")    //修改密码
     public String dapUpdate(User id,@PathVariable String userCode) {
         User up = new User();
         up.setUserPassword(id.getUserPassword());
         up.setUserCode(userCode);
         int count = userInfoService.updauser(up);
         if (count > 0) {
             return "login";
         } else {
             return "password";
         }
     }

     @RequestMapping("/userlist1")  //列表及分页
       public String  doList(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
         PageHelper.startPage(pn,4);
         List<User> sll=userInfoService.getUser();
         PageInfo  page=new PageInfo(sll,4);
        model.addAttribute("page",page);
         return "userList";
    }




///*模糊查询*/
////模糊查询用户列表
//@RequestMapping(value = "tAllUser")
//public String setAlls(HttpServletRequest request ,String userName){
//    List<User> list = userInfoService.Mall(userName);
//    request.setAttribute("list", list);
//    return "userList";
//}


@RequestMapping(value = "/deleteuser/{id}")    //删除
public String doDelete(@PathVariable int id){
               System.out.println(id);
                userInfoService.del(id);
                return "redirect:/user/showUserList";
}

/*添加*/
@RequestMapping(value = "/adduser",method = RequestMethod.POST)
public String doAdd(User user){
    User ue=new User();
    ue.setUserCode(user.getUserCode());
    ue.setUserName(user.getUserName());
    ue.setUserPassword(user.getUserPassword());
    ue.setGender(user.getGender());

    ue.setBirthday(new Date());
    ue.setPhone(user.getPhone());
    ue.setAddress(user.getAddress());
    ue.setUserRole(user.getUserRole());
     int  count=userInfoService.add(ue);
     if(count>0){
         return "redirect:/user/showUserList";
     }else {
          return "userAdd";
     }
}

@RequestMapping("/userAdd")
public String add(){
    return "userAdd";
}

/*查看*/
@RequestMapping("/All/{id}")
public  String  Sll(HttpServletRequest request,@PathVariable int id){
    User u=userInfoService.getAll(id);
    request.setAttribute("ul",u);
    return "userView";
}

/*根据id查询所有进行修改*/
@RequestMapping("/getall/{id}")
public String doAll(HttpServletRequest request,@PathVariable int id){
    User user=userInfoService.getAll(id);
    request.setAttribute("list",user);
    return "userUpdate";
}

@RequestMapping("/updatelist/{id}")  //修改
public String doUpdate(String userName, String userPassword, int gender, Date birthday,String phone,String  address,int userRole,@PathVariable int id){
    User u1=new User();
    u1.setUserName(userName);
    u1.setUserPassword(userPassword);
    u1.setGender(gender);
    u1.setBirthday(birthday);
    u1.setPhone(phone);
    u1.setAddress(address);
    u1.setUserRole(userRole);
    u1.setId(id);
    int count=userInfoService.update(u1);
    if(count>0){
        return  "redirect:/user/showUserList";
    }else {
        return "userUpdate";
    }

}




    /*让用户看到该视图*/
    @RequestMapping("/showUserList")
    public String showUserList(){
        return "userList";
    }

    //获取用户数据

    /**
     *defaultValue = "1" 默认取值为1
     * defaultValue = "2" 默认取值为2
     * @param pageIndex  当前页码
     * @param pageSize
     * @return  Object 整个PageUtil对象
     */
    //将返回值直接作为输出流中的内用，不用程序员手动构建输出流
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public Object getUserInfo(@RequestParam(defaultValue = "1") int pageIndex,@RequestParam(defaultValue = "3") int pageSize){
        return userInfoService.getOnePageData(pageIndex,pageSize);
    }
    @ResponseBody
    @RequestMapping("/GetUsert")
    public Object getUserInfos(@RequestParam(defaultValue = "1") int pageIndex,@RequestParam(defaultValue = "3") int pageSize,User info){
        return userInfoService.getOnePageData(pageIndex,pageSize,info);
    }


    @ResponseBody       //ajax添加
    @RequestMapping(value = "/adduserss",method = RequestMethod.POST)
    public Object doAdds(User user){

        int  count=userInfoService.add(user);
        if(count>0){
            return true;
        }else {
            return false;
        }
    }



//报表导出
    @RequestMapping(value = "exceoll")
    public  String exceoll(Model model){
        List<User>list=userInfoService.getfind();
        model.addAttribute("list",list);
        return "regell";
    }


}
