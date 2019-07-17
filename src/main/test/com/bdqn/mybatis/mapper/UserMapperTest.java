package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.User;
import com.bdqn.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {
    private Logger logger = Logger.getLogger(this.getClass());
    private SqlSession sqlSession = null;

    @Before
    public void setUp() throws Exception{
        sqlSession = MyBatisUtil.createSqlSession();
    }

    @After
    public void tearDown() throws Exception{
        MyBatisUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void selectUsers() {
        List<User> userList = new ArrayList<User>();
        //调用getMapper(UserMapper.class)执行Mapper接口方法
        userList = sqlSession.getMapper(UserMapper.class).selectUsers();
        for (User user: userList) {
            logger.debug(user.toString());
        }
    }
}