package com.bdqn.mybatis.service.impl;

import com.bdqn.mybatis.mapper.UserMapper;
import com.bdqn.mybatis.pojo.User;
import com.bdqn.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserServiceImpl
 * @Description:用户接口实现类
 * @Author: amielhs
 * @Date 2019-06-29
 */
@Service("userService")
@Transactional
/*@Scope(value = "prototype") *//*Bean的作用域*/
public class UserServiceImpl implements UserService {

    @Resource //默认按类型匹配或者使用@Autowired
    @Qualifier("userMapper") //按指定名称匹配
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * @Description:查询用户列表(参数：对象入参)
     * @param: [user]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public List<User> findUsersWithConditions(User user) {
        try {
            return userMapper.getUserList(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @Description:查询到所有用户
     * @param: []
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public List<User> findAllUsers() {
        return userMapper.selectUsers();
    }

    /**
     * @Description:通过uId查询用户
     * @param: [uId]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findUserById(Integer uId) {
        return userMapper.selectUserById(uId);
    }

    /**
     * @Description:查询用户列表(参数：Map)
     * @param: [userMap]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> getUserListByMap(Map<String, String> userMap) {
        return userMapper.getUserListByMap(userMap);
    }

    /**
     * @Description:增加用户
     * @param: [user]
     * @return: boolean
     * @Date: 2019-07-01
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addNewUser(User user) {
        boolean result = false;
        try {
            if (userMapper.add(user) == 1)
                result = true;
            //模拟异常
            //int i = 1 / 0;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    /**
     * @Description:修改用户
     * @param: [user]
     * @return: void
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(User user) {
        userMapper.update(user);
    }

    /**
     * @Description:删除用户
     * @param: [user]
     * @return: void
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(User user) {
        userMapper.delete(user);
    }

    /**
     * @Description:修改密码
     * @param: [user]
     * @return: void
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void changePwd(User user) {
        userMapper.update(user);
    }

    /**
     * @Description:加载用户
     * @param: [id]
     * @return: com.bdqn.mybatis.pojo.User
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }

    /**
     * @Description:用户登录
     * @param: [userCode, userPassword]
     * @return: com.bdqn.mybatis.pojo.User
     * @Date: 2019-07-04
     */
    @Override
    public User login(String userCode, String userPassword) {
        return userMapper.getLoginUser(userCode,userPassword);
    }
}
