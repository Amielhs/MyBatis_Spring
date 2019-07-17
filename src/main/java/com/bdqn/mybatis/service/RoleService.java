package com.bdqn.mybatis.service;

import com.bdqn.mybatis.pojo.Role;

import java.util.List;

public interface RoleService {

    /**
     * @Description:查询角色列表
     * @param: []
     * @return: List<Role>
     * @Date: 2019-07-04
     */
    List<Role> findRoleList();
}
