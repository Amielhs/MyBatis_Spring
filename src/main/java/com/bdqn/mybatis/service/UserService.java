package com.bdqn.mybatis.service;

import com.bdqn.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserService
 * @Description:用户业务接口
 * @Author: amielhs
 * @Date 2019-06-29
 */
public interface UserService {
    /**
     * @Description:查询用户列表(参数：对象入参)
     * @param: [user]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-07-02
     */
    public List<User> findUsersWithConditions(User user);

    /**
     * @Description:查询到所有用户
     * @param: []
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-29
     */
    public List<User> findAllUsers();

    /**
     * @Description:通过uId查询用户
     * @param: [uId]
     * @return: com.bdqn.mybatis.pojo.User
     * @Date: 2019-06-29
     */
    List<User> findUserById(Integer uId);

    /**
     * @Description:查询用户列表(参数：Map)
     * @param: [userMap]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-19
     */
    public List<User> getUserListByMap(Map<String,String> userMap);

    /**
     * @Description:增加用户
     * @param: [user]
     * @return: boolean
     * @Date: 2019-07-01
     */
    public boolean addNewUser(User user);

    /**
     * @Description:修改用户
     * @param: [user]
     * @return: void
     * @Date: 2019-07-02
     */
    public void update(User user);

    /**
     * @Description:删除用户
     * @param: [user]
     * @return: void
     * @Date: 2019-07-02
     */
    public void delete(User user);

    /**
     * @Description:修改密码
     * @param: [user]
     * @return: void
     * @Date: 2019-07-02
     */
    public void changePwd(User user);

    /**
     * @Description:加载用户
     * @param: [id]
     * @return: com.bdqn.mybatis.pojo.User
     * @Date: 2019-07-02
     */
    public User getUser(Integer id);

    /**
     * @Description:用户登录
     * @param: [userCode, userPassword]
     * @return: com.bdqn.mybatis.pojo.User
     * @Date: 2019-07-04
     */
    public User login(String userCode,String userPassword);
}
