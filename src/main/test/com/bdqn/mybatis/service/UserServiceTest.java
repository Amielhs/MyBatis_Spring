package com.bdqn.mybatis.service;

import com.bdqn.mybatis.pojo.User;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class UserServiceTest {
    private Logger logger = Logger.getLogger(this.getClass());
    ApplicationContext context = null;

    @Before
    public void setUp() throws Exception {
        /*使用Spring框架进行测试*/
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * @Description:查询用户列表(参数：对象入参)
     * @param: []
     * @return: void
     * @Date: 2019-07-02
     */
    @Test
    public void findUsersWithConditions() {
        UserService userService = (UserService) context.getBean("userService");
        List<User> userList = new ArrayList<User>();
        User userCondition = new User();
        userCondition.setUserName("赵");
        userCondition.setUserRole(3);
        userList = userService.findUsersWithConditions(userCondition);

        for (User userResult : userList) {
            logger.debug("testGetUserList userCode: "
                    + userResult.getUserCode() + " and userName: "
                    + userResult.getUserName() + " and userRole: "
                    + userResult.getUserRole() + " and userRoleName: "
                    + userResult.getUserRoleName() + " and address: "
                    + userResult.getAddress());
        }
    }

    /**
     * @Description:查询所有用户
     * @param: []
     * @return: void
     * @Date: 2019-06-29
     */
    @Test
    public void findAllUsers() {
        UserService userService = (UserService) context.getBean("userService");
        List<User> userList = userService.findAllUsers();
        for (User user:
             userList) {
            logger.info(user.toString());
        }
    }

    /**
     * @Description:通过Id查询用户
     * @param: []
     * @return: void
     * @Date: 2019-06-29
     */
    @Test
    public void findUserById() {
        UserService userService = (UserService) context.getBean("userService");
        List<User> user = userService.findUserById(2);
            logger.info(user.toString());
    }

    @Test
    public void getUserListByMap() {
        /**
         * @Description:通过用户名称和用户角色查询用户
         * @param: []
         * @return: void
         * @Date: 2019-07-01
         */
        Map<String, String> userMap = new HashMap<String, String>();
        userMap.put("uName", "赵");
        userMap.put("uRole", "3");
        UserService userService = (UserService) context.getBean("userService");
        List<User> userList = userService.getUserListByMap(userMap);
        for(User user: userList){
            logger.debug("用户代号: " + user.getUserCode() + " \t用户名: " + user.getUserName());
        }
    }

    /**
     * @Description:添加用户
     * @param: []
     * @return: void
     * @Date: 2019-07-01
     */
    @Test
    public void addNewUser() throws ParseException {
        UserService userService = (UserService) context.getBean("userService");

        User user = new User();
        user.setUserCode("test001");
        user.setUserName("测试用户001");
        user.setUserPassword("1234567");
        Date birthday =new SimpleDateFormat("yyyy-MM-dd").parse("1984-12-12");
        user.setBirthday(birthday);
        user.setCreationDate(new Date());
        user.setAddress("地址测试");
        user.setGender(1);
        user.setPhone("13688783697");
        user.setUserRole(1);
        user.setCreatedBy(1);
        user.setCreationDate(new Date());

        boolean result = userService.addNewUser(user);
        logger.debug("testAdd result : " + result);
    }

    /**
     * @Description:修改用户
     * @param: []
     * @return: void
     * @Date: 2019-07-02
     */
    @Test
    public void update() {
        UserService userService=(UserService) context.getBean("userService");
        User user=userService.getUser(21);
        user.setPhone("13111111111");
        userService.update(user);
    }

    /**
     * @Description:删除用户
     * @param: []
     * @return: void
     * @Date: 2019-07-02
     */
    @Test
    public void delete() {
        UserService userService=(UserService) context.getBean("userService");
        User user=userService.getUser(21);
        userService.delete(user);
    }

    /**
     * @Description:修改密码
     * @param: []
     * @return: void
     * @Date: 2019-07-02
     */
    @Test
    public void changePwd() {
        UserService userService=(UserService) context.getBean("userService");
        User user=userService.getUser(21);
        user.setUserPassword("111111");
        userService.changePwd(user);
    }
}