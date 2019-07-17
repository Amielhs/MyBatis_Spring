package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserMapper
 * @Description:基于mapper接口方式操作用户数据
 * @Author: amielhs
 * @Date 2019-06-19
 */
public interface UserMapper {
    /**
     * @Description:查询用户列表(参数：对象入参)
     * @param: [user]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-07-02
     */
    public List<User> getUserList(User user);

    /**
     * @Description:查询用户列表
     * @param: []
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-29
     */
    public List<User> selectUsers();

    /**
     * @Description:通过id查询用户信息
     * @param: [uId]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-29
     */
    public List<User> selectUserById(Integer uId);

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
     * @return: int
     * @Date: 2019-07-01
     */
    public int add(User user);

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
     * @Description:加载用户信息
     * @param: [id]
     * @return: com.bdqn.mybatis.pojo.User
     * @Date: 2019-07-02
     */
    public User getUser(Integer id);

    /**
     * @Description:通过userCode和userPassword获取User
     * @param: [userCode]
     * @return: com.bdqn.mybatis.pojo.User
     * @Date: 2019-07-04
     */
    public User getLoginUser(@Param("uCode") String userCode,@Param("pwd")String userPassword);
}
