package com.bdqn.text;

import com.bdqn.pojo.User;
import com.bdqn.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by java on 2017/8/22.
 */
public class UserTest {

    @Test
    public  void test01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("Springsmbms.xml");
        UserService service=(UserService)context.getBean("userService");

    }
}
