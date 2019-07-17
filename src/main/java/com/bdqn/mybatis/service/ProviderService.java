package com.bdqn.mybatis.service;

import com.bdqn.mybatis.pojo.Provider;

import java.util.List;


public interface ProviderService {
    /**
     * @Description:查询供应商表记录数
     * @param: []
     * @return: int
     * @Date: 2019-07-01
     */
    public int getCountOfProviders();

    /**
     * @Description:查询供应商列表
     * @param: []
     * @return: List<Provider>
     * @Date: 2019-07-01
     */
    public List<Provider> findAllProviders();

    /**
     * @Description:根据供应商名称查询供应商列表
     * @param: [proName]
     * @return: java.util.List<com.bdqn.mybatis.pojo.Provider>
     * @Date: 2019-07-01
     */
    public List<Provider> findProvidersByName(String proName);

    /**
     * @Description:增加供应商
     * @param: [provider]
     * @return: int
     * @Date: 2019-07-02
     */
    public int addNewProvider(Provider provider);

    /**
     * @Description:修改供应商信息
     * @param: [provider]
     * @return: int
     * @Date: 2019-07-02
     */
    int modifyProvider(Provider provider);

    /**
     * @Description:根据供应商ID删除供应商信息
     * @param: [delId]
     * @return: int
     * @Date: 2019-07-02
     */
    int deleteProvider(Integer delId);
}
