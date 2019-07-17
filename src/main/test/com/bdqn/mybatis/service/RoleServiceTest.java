package com.bdqn.mybatis.service;

import com.bdqn.mybatis.pojo.Role;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class RoleServiceTest {
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
     * @Description:查询角色信息
     * @param: []
     * @return: void
     * @Date: 2019-07-04
     */
    @Test
    public void getRoleList() {
        RoleService roleService = (RoleService) context.getBean("roleService");
        List<Role> roleList = roleService.findRoleList();
        for (Role role: roleList) {
            logger.info(role.toString());
        }
    }
}