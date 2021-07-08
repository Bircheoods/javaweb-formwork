package com.huaian.dao.impl;

import com.huaian.bean.User;
import com.huaian.dao.BaseDao;
import com.huaian.dao.UserDao;
import com.huaian.utils.JDBCUtils;

import java.util.List;

/**
 * @description
 * @user summerHouAnNing
 * @creatTime 2021/7/8--16:49
 */
public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User queryUserByUserName(String userName) {
        String sql = "select id,username,password,email from t_user where username = ?";
        User user = selectOne(User.class, sql, userName);
        return user;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(id,username,password,email) values(?,?,?,?)";
        return update(sql,null,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByNameAndPassword(String userName, String password) {
        String sql = "select id,username,password,email from t_user where username = ?";
        User user = selectOne(User.class, sql, userName);
        return user;
    }
}
