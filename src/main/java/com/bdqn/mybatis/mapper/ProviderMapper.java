package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {
    /**
     * @Description:查询供应商表记录数
     * @param: []
     * @return: int
     * @Date: 2019-07-01
     */
    public int count();

    /**
     * @Description:查询供应商列表
     * @param: []
     * @return: List<Provider>
     * @Date: 2019-07-01
     */
    public List<Provider> getProviderList();

    /**
     * @Description:根据供应商名称查询供应商列表
     * @param: [proName]
     * @return: java.util.List<com.bdqn.mybatis.pojo.Provider>
     * @Date: 2019-07-01
     */
    public List<Provider> getProviderListByName(String proName);

    /**
     * @Description:增加供应商
     * @param: [provider]
     * @return: int
     * @Date: 2019-07-02
     */
    public int add(Provider provider);

    /**
     * @Description:修改供应商信息
     * @param: [provider]
     * @return: int
     * @Date: 2019-07-02
     */
    public int modify(Provider provider);

    /**
     * @Description:根据供应商ID删除供应商信息
     * @param: [delId]
     * @return: int
     * @Date: 2019-07-02
     */
    public int deleteProviderById(@Param("id")Integer delId);
}
