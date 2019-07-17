package com.bdqn.mybatis.controller;

import com.bdqn.mybatis.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName: IndexController
 * @Description:页面控制器
 * @Author: amielhs
 * @Date 2019-07-02
 */
//控制器:IndexController
@Controller
public class IndexController extends AbstractController {
	private Logger logger = Logger.getLogger(IndexController.class);

	@Override
	@RequestMapping("/index") //表示方法与请求URL来对应(此处："/index")
	protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		logger.info("hello,Spring MVC!");
		return new ModelAndView("index");
	}

	/**
	 * @Description:参数传参 view to controller
	 * @param:
	 * @return:
	 * @Date: 2019-07-02
	 */
	/*@RequestMapping("/welcome")
	public String welcome(@RequestParam String username){
		logger.info("welcome, " + username);
		return "index";
	}*/

	/*@RequestMapping("/welcome")
	public String welcome(@RequestParam(value="username",required=false) String username){
		logger.info("welcome," + username);
		return "index";
	}*/

	/*@RequestMapping(value="/welcome",method= RequestMethod.GET,params="username")
	public String welcome(String username){
		logger.info("welcome, " + username);
		return "index";
	}*/

	/**
	 * @Description:参数传递 controller to view -(ModelAndView)
	 * @param: [username]
	 * @return: org.springframework.web.servlet.ModelAndView
	 * @Date: 2019-07-02
	 */
	@RequestMapping("/index1")
	public ModelAndView index(String username){
		logger.info("welcome! username: " + username);
		ModelAndView mView = new ModelAndView();
		mView.addObject("username", username);
		mView.setViewName("index");
		return mView;
	}

	/**
	 * @Description:参数传递：controller to view -(Model)
	 * @param: [username, model]
	 * @return: java.lang.String
	 * @Date: 2019-07-02
	 */
	@RequestMapping("/index2")
	public String index(String username, Model model){
		logger.info("hello,Spring MVC! username: " + username);
		model.addAttribute("username", username);
		/**
		 * 默认使用对象的类型作为key：
		 * model.addAttribute("string", username)
		 * model.addAttribute("user", new User())
		 */
		model.addAttribute(username);
		User user = new User();
		user.setUserName(username);
		model.addAttribute("currentUser", user);
		model.addAttribute(user);
		return "index";
	}

	/**
	 * @Description:参数传递：controller to view -(Map<String,Object>)
	 * @param: [username, model]
	 * @return: java.lang.String
	 * @Date: 2019-07-02
	 */
	@RequestMapping("/index3")
	public String index(String username, Map<String, Object> model){
		logger.info("hello,Spring MVC! username: " + username);
		model.put("username", username);
		return "index";
	}

	/**
	 * @Description:完成View与Controller之间的参数传递
	 * @param: [userCode, model]
	 * @return: java.lang.String
	 * @Date: 2019-07-02
	 */
	@RequestMapping("/test.cs")
	public String save(String userCode,Model model){
		logger.info("hello,Spring MVC! userCode: " + userCode);
		model.addAttribute("userCode", userCode);
		return "success";
	}

	/**
	 * @Description:可以传参也可以不传参
	 * @param: [username]
	 * @return: java.lang.String
	 * @Date: 2019-07-03
	 */
	@RequestMapping("/index4")
	public String index4(@RequestParam(value = "uName",required = false)String username){
		logger.info("hello,Spring MVC! username: " + username);
		return "index";
	}

	/**
	 * @Description:直接传参方法
	 * @param: [username]
	 * @return: org.springframework.web.servlet.ModelAndView
	 * @Date: 2019-07-03
	 */
	@RequestMapping(value = "/index5/{username}",method = RequestMethod.GET)
	public ModelAndView index5(@PathVariable String username){
		logger.info("hello,Spring MVC! username: " + username);
		ModelAndView mView = new ModelAndView();
		mView.addObject("username", username);
		mView.setViewName("index");
		return mView;
	}

}
