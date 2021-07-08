package com.huaian.dao;

import com.huaian.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @description 操作数据库的相关工具类
 * @user summerHouAnNing
 * @creatTime 2021/7/8--16:32
 */
public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    /**
    *@description: 适用于增删改等方法
    *@author: summerHouAnNing
    *@creatTime: 2021/7/8--16:45
    *@Param:
    *@return:
    **/
    public int update(String sql,Object ...args){
        Connection connection = JDBCUtils.getConnection();

        try {
            return queryRunner.update(sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(connection);
        }

        return -1;
    }

    /**
    *@description: 返回单个查询对象
    *@author: summerHouAnNing
    *@creatTime: 2021/7/8--16:45
    *@Param:
    *@return:
    **/
    public <T> T selectOne(Class<T> type,String sql,Object ...args){
        Connection connection = JDBCUtils.getConnection();

        try {
           return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(connection);
        }
        return null;
    }

    /**
    *@description: 返回多个查询对象
    *@author: summerHouAnNing
    *@creatTime: 2021/7/8--16:44
    *@Param:
    *@return:
    **/
    public <T> List<T>  selectList(Class<T> type, String sql, Object ...args){
        Connection connection = JDBCUtils.getConnection();

        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(connection);
        }
        return null;
    }

    /**
    *@description: 返回一行一列的单一参数值
    *@author: summerHouAnNing
    *@creatTime: 2021/7/8--16:44
    *@Param:
    *@return:
    **/
    public Object querySingle(String sql,Object ...args){
        Connection connection = JDBCUtils.getConnection();

        try {
           return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection);
        }
        return null;
    }
}
