package com.bdqn.mybatis.servlet;

import com.alibaba.fastjson.JSON;
import com.bdqn.mybatis.pojo.User;
import com.bdqn.mybatis.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(urlPatterns = "/users")
public class UserServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 5906669469723420389L;
    private Logger logger = Logger.getLogger(this.getClass());

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ApplicationContext context = null;
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        List<User> userList = userService.findAllUsers();
        for (User user: userList) {
            logger.info(user.toString());
        }

        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/html;charset=utf-8");

        String responseStr = JSON.toJSONString(userList);
        Writer writer = response.getWriter();
        writer.write(responseStr);
        writer.flush();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
