package com.huaian.dao;

import com.huaian.bean.User;

import java.util.List;

public interface UserDao {

    /**
    *@description: 根据姓名查询人员
    *@author: summerHouAnNing
    *@creatTime: 2021/7/8--16:48
    *@Param:
    *@return:
    **/
    public User queryUserByUserName(String userName);
    /**
    *@description: 保存一个人员
    *@author: summerHouAnNing
    *@creatTime: 2021/7/8--16:49
    *@Param:
    *@return:
    **/
    public int saveUser(User user);
    /**
    *@description: 根据用户名和密码查询人员
    *@author: summerHouAnNing
    *@creatTime: 2021/7/8--16:49
    *@Param:
    *@return:
    **/
    public User queryUserByNameAndPassword(String userName, String password);
}
