/*package com.bdqn.mybatis.mapper.impl;

import com.bdqn.mybatis.mapper.UserMapper;
import com.bdqn.mybatis.pojo.User;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;


*//**
 * @ClassName: UserMapperImpl
 * @Description:用户实体映射接口实现类
 * @Author: amielhs
 * @Date 2019-06-27
 *//*


@Repository("userMapper")

public class UserMapperImpl implements UserMapper {
    private static final Logger log = Logger.getLogger(UserMapperImpl.class);
    //通过SqlSessionTemplate类来实现数据持久化操作
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<User> selectUsers() {
        //log.info("通过mysql查询到所有用户");
        //使用sqlSession的第一种方式进行查询（命名空间）
        return sqlSessionTemplate.selectList("com.bdqn.mybatis.mapper.UserMapper.selectUsers");
    }

    @Override
    public void update(User user) {
        this.sqlSessionTemplate.getMapper(UserMapper.class).update(user);
    }

    @Override
    public void delete(User user) {
        this.sqlSessionTemplate.getMapper(UserMapper.class).delete(user);
    }

    @Override
	public User getUser(Integer id) {
		return this.sqlSessionTemplate.getMapper(UserMapper.class).getUser(id);
	}
}*/

