package com.bdqn.mybatis.service.impl;

import com.bdqn.mybatis.mapper.RoleMapper;
import com.bdqn.mybatis.pojo.Role;
import com.bdqn.mybatis.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public List<Role> findRoleList() {
        try {
            return roleMapper.getRoleList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
