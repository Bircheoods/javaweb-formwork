package com.huaian.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description
 * @user summerHouAnNing
 * @creatTime 2021/7/8--13:44
 */


/*
创建servlet程序第一步：创建一个类，实现servlet接口（该接口在使用前需要先导入servlet-api依赖）
              第二步：在web.xml文件中配置servlet的访问路径
 */
public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
    *@description: service方法是专门用来处理请求和相应的
    *@author: summerHouAnNing
    *@creatTime: 2021/7/8--13:48
    *@Param:
    *@return:
    **/
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        /*
        getMethod方法可以获取到客户端发送的请求类型，可以以此来判断客户端发送的请求类型，做到请求分发的效果
         */
        String method = httpServletRequest.getMethod();
        System.out.println("method = " + method);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
