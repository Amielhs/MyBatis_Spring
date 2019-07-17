package com.bdqn.mybatis.controller;

import com.bdqn.mybatis.pojo.User;
import com.bdqn.mybatis.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName: IndexController
 * @Description:页面控制器
 * @Author: amielhs
 * @Date 2019-07-02
 */
//控制器:IndexController
@Controller
public class UserController extends AbstractController {
	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Override
	@RequestMapping("/user1") //表示方法与请求URL来对应(此处："/user1)
	protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		logger.info("hello,Spring MVC，我的第一个用户!");
		return new ModelAndView("user");
	}

	/**
	 * @Description:参数传参
	 * @param:
	 * @return:
	 * @Date: 2019-07-02
	 */
	/*@RequestMapping({"/welcome","/"})
	public String welcome(@RequestParam String username){
		logger.info("welcome, username:" + username);
		return "user";
	}*/

	/**
	 * @Description:模拟用户添加
	 * @param: [username, userPassword]
	 * @return: java.lang.String
	 * @Date: 2019-07-03
	 */
	@RequestMapping("/addUser")
	public String addUser(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword, Model model){
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		/*向视图层传递数据*/
		model.addAttribute("user",user);
		model.addAttribute("pwd",userPassword);
		return "user";
	}

	@RequestMapping(value = "/findUser",method = RequestMethod.GET)
	public String findUser(@RequestParam(value = "uId",required = false) Integer id,Model model){
		List<User> userList = userService.findUserById(id);
		for (User user:userList){
			model.addAttribute("user",user);
		}
		return "user";
	}
}
