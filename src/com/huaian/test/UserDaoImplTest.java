package com.huaian.test;

import com.huaian.bean.User;
import com.huaian.dao.UserDao;
import com.huaian.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;
/**
*@description: 测试类
*@author: summerHouAnNing
*@creatTime: 2021/7/8--17:07
*@Param:
*@return:
**/
public class UserDaoImplTest {

    @Test
    public void queryUserByUserName() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryUserByUserName("张三");
        System.out.println("user = " + user);
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        User user = new User(null,"Javaweb","123456","H@qq.com");
        int i = userDao.saveUser(user);
        System.out.println("i = " + i);
    }

    @Test
    public void queryUserByNameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryUserByNameAndPassword("张三","123456");
        System.out.println("user = " + user);
    }
}