package com.huaian.test;

import com.huaian.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @description
 * @user summerHouAnNing
 * @creatTime 2021/7/8--16:27
 */
public class JDBCUtilsTest {

    @Test
    public void getJdbcTest(){
        Connection connection = JDBCUtils.getConnection();

        System.out.println("connection = " + connection);
    }
}
