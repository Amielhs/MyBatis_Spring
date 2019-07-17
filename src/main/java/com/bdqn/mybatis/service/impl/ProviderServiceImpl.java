package com.bdqn.mybatis.service.impl;

import com.bdqn.mybatis.mapper.ProviderMapper;
import com.bdqn.mybatis.pojo.Provider;
import com.bdqn.mybatis.service.ProviderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("providerService")
@Transactional
/*@Scope(value = "prototype") *//*Bean的作用域*/
public class ProviderServiceImpl implements ProviderService {
    @Resource //默认按类型匹配或者使用@Autowired
    @Qualifier("providerMapper") //按指定名称匹配
    private ProviderMapper providerMapper;

    public ProviderMapper getProviderMapper() {
        return providerMapper;
    }

    public void setProviderMapper(ProviderMapper providerMapper) {
        this.providerMapper = providerMapper;
    }

    /**
     * @Description:查询供应商表记录数
     * @param: []
     * @return: int
     * @Date: 2019-07-01
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public int getCountOfProviders() {
        try {
            return providerMapper.count();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @Description:查询供应商列表
     * @param: []
     * @return: java.util.List<com.bdqn.mybatis.pojo.Provider>
     * @Date: 2019-07-01
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public List<Provider> findAllProviders() {
        try {
            return providerMapper.getProviderList();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @Description:根据供应商名称查询供应商列表
     * @param: [proName]
     * @return: java.util.List<com.bdqn.mybatis.pojo.Provider>
     * @Date: 2019-07-01
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public List<Provider> findProvidersByName(String proName) {
        try {
            return providerMapper.getProviderListByName(proName);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @Description:增加供应商
     * @param: [provider]
     * @return: int
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public int addNewProvider(Provider provider) {
        int count = -1;
        try {
            count = providerMapper.add(provider);
            // 模拟异常，进行回滚
            // int i = 2/0;
            return count;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @Description:修改供应商信息
     * @param: [provider]
     * @return: int
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public int modifyProvider(Provider provider) {
        int count = -1;
        try {
            count = providerMapper.modify(provider);
            // 模拟异常，进行回滚
            // int i = 2/0;
            return count;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @Description:根据供应商ID删除供应商信息
     * @param: [delId]
     * @return: int
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public int deleteProvider(Integer delId) {
        int count = -1;
        try {
            count = providerMapper.deleteProviderById(delId);
            // 模拟异常，进行回滚
            // int i = 2/0;
            return count;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
