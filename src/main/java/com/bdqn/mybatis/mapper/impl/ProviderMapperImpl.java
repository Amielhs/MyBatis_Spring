/*package com.bdqn.mybatis.mapper.impl;

import com.bdqn.mybatis.mapper.ProviderMapper;
import com.bdqn.mybatis.pojo.Provider;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class ProviderMapperImpl implements ProviderMapper {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int count() {
        return sqlSession.selectOne("com.bdqn.mybatis.mapper.ProviderMapper.count");
    }

    @Override
    public List<Provider> getProviderList() {
        return sqlSession.selectList("com.bdqn.mybatis.mapper.ProviderMapper.getProviderList");
    }

    @Override
    public List<Provider> getProviderListByName(@Param("proName") String proName) {
        return sqlSession.selectList(
                "com.bdqn.mybatis.mapper.ProviderMapper.getProviderListByName", proName);
    }
}*/
