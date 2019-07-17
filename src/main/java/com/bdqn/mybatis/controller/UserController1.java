package com.bdqn.mybatis.controller;

import com.bdqn.mybatis.pojo.User;
import com.bdqn.mybatis.service.UserService;
import com.bdqn.mybatis.utils.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: IndexController
 * @Description:页面控制器
 * @Author: amielhs
 * @Date 2019-07-02
 */
//控制器:IndexController
@Controller
@RequestMapping("/user")
public class UserController1 {
    private Logger logger = Logger.getLogger(UserController1.class);

    @Resource
    private UserService userService;

    /**
     * @Description:实现跳转到登录页
     * @param: []
     * @return: java.lang.String
     * @Date: 2019-07-04
     */
    @RequestMapping(value = "/login")
    public String login() {
        logger.info("UserController1 welcome ========>");
        return "login";
    }

    /**
     * @Description:实现登录
     * @param: []
     * @return: java.lang.String
     * @Date: 2019-07-04
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String doLogin(String userCode,String userPassword, HttpSession session, HttpServletRequest request) {
        logger.info("doLogin ========>");
        /*调用service方法，进行用户匹配*/
        User user = userService.login(userCode, userPassword);
        //匹配密码
        if (null!=user) {//登录成功
            //放入session
            session.setAttribute(Constants.USER_SESSION , user);
            //页面跳转(frame.jsp)
            return "redirect:/user/main";
            //Response.sendRedirect("jsp/frame.jsp")
        } else {
            //页面跳转(login.jsp)
            request.setAttribute("error", "用户名或密码不正确");
            return "login";
        }
    }

    /**
     * @Description:进入系统管理
     * @param: [session]
     * @return: java.lang.String
     * @Date: 2019-07-04
     */
    @RequestMapping(value = "/main")
    public String main(HttpSession session) {
        if (session.getAttribute(Constants.USER_SESSION) == null) {
            return "redirect:/user/login";
        }
        return "frame";
    }


    /**
     * @Description:错误登录，异常处理
     * @param: [userCode, userPassword]
     * @return: java.lang.String
     * @Date: 2019-07-04
     */
    @RequestMapping(value = "/exlogin",method = RequestMethod.GET)
    public String exLogin(String userCode,String userPassword) {
        logger.debug("exLogin====================================");
        //调用service方法，进行用户匹配
        User user = userService.login(userCode, userPassword);
        if (null == user) {//登录失败
            throw new RuntimeException("用户名或者密码不正确！");
        }
        return "redirect:/user/main";
    }

    /**
     * @Description:错误信息存取，进入error页面(局部异常处理)
     * @param: [e, req]
     * @return: java.lang.String
     * @Date: 2019-07-04
     */
	/*@ExceptionHandler(value={RuntimeException.class})
	public String handlerException(RuntimeException e,HttpServletRequest req){
		req.setAttribute("e", e);
		return "error";
	}*/

    /**
     * @Description:查询角色信息
     * @param: [model, queryUserName, queryUserRole, pageIndex]
     * @return: java.lang.String
     * @Date: 2019-07-04
     */
    /*@RequestMapping(value = "/userlist")
    public String getUserList(Model model,
                              @RequestParam(value = "queryname", required = false) String queryUserName,
                              @RequestParam(value = "queryUserRole", required = false) String queryUserRole,
                              @RequestParam(value = "pageIndex", required = false) String pageIndex) {
        logger.info("getUserList ---- > queryUserName: " + queryUserName);
        logger.info("getUserList ---- > queryUserRole: " + queryUserRole);
        logger.info("getUserList ---- > pageIndex: " + pageIndex);

        return "userlist";
    }*/

}
