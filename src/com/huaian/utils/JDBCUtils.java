package com.huaian.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @description
 * @user summerHouAnNing
 * @creatTime 2021/7/8--16:12
 */
public class JDBCUtils {

    private static DruidDataSource dataSource;

    static {
        //读取数据库相关的配置文件
        InputStream resource = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();

        try{
            //加载配置文件
            properties.load(resource);
            //创建数据库连接池
           dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();

        }

    }


    /**
    *@description: 获取数据库连接池中的数据
    *@author: summerHouAnNing
    *@creatTime: 2021/7/8--16:12
    *@Param:
    *@return:
    **/
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
