package com.bdqn.mybatis.service;

import com.bdqn.mybatis.pojo.Provider;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class ProviderServiceTest {
    private Logger logger = Logger.getLogger(this.getClass());
    ApplicationContext context = null;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCountOfProviders() {
        /**
         * @Description:查询供应商表记录数
         * @param: []
         * @return: void
         * @Date: 2019-07-01
         */
        int result = 0;
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        result = providerService.getCountOfProviders();
        logger.info("供货商的数量："+result);
    }

    @Test
    public void findAllProviders() {
        /**
         * @Description:查询供应商列表
         * @param: []
         * @return: void
         * @Date: 2019-07-01
         */
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        List<Provider> providerList = new ArrayList<>();
        providerList = providerService.findAllProviders();

        for (Provider provider : providerList) {
            logger.debug("testGetProviderList proCode: "
                    + provider.getProCode() + " and proName: "
                    + provider.getProName());
        }
    }

    /**
     * @Description:根据供应商名称查询供应商列表
     * @param: []
     * @return: void
     * @Date: 2019-07-01
     */
    @Test
    public void findProvidersByName() {
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        List<Provider> providerList = new ArrayList<>();
        providerList = providerService.findProvidersByName("厂");
        for (Provider provider: providerList) {
            logger.info("testGetProviderList proCode: "
                    + provider.getProCode() + " and proName: "
                    + provider.getProName());
        }
    }

    /**
     * @Description:增加供应商
     * @param: []
     * @return: void
     * @Date: 2019-07-02
     */
    @Test
    public void addNewProvider() {
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        Provider provider = new Provider();
        provider.setProCode("BJ_GYS111");
        provider.setProName("供应商测试");
        provider.setProContact("张三");
        provider.setProAddress("供应商测试地址");
        provider.setProPhone("13566667777");
        provider.setCreatedBy(1);
        provider.setCreationDate(new Date());
        provider.setProFax("010-588876565");
        provider.setProDesc("供应商测试描述");
        int count = providerService.addNewProvider(provider);

        logger.debug("testAdd count: " + count);
    }

    /**
     * @Description:修改供应商信息
     * @param: []
     * @return: void
     * @Date: 2019-07-02
     */
    @Test
    public void modifyProvider() {
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        Provider provider = new Provider();
        provider.setId(16);
        provider.setProCode("BJ_GYS123");
        provider.setProName("供应商测试修改");
        provider.setProContact("李四");
        provider.setProAddress("供应商测试地址修改");
        provider.setProPhone("13500002222");
        provider.setModifyBy(1);
        provider.setModifyDate(new Date());
        provider.setProFax("010-588876565");
        provider.setProDesc("供应商测试描述修改");
        int count = providerService.modifyProvider(provider);

        logger.debug("testModify count: " + count);
    }

    /**
     * @Description:根据供应商ID删除供应商信息
     * @param: []
     * @return: void
     * @Date: 2019-07-02
     */
    @Test
    public void deleteProvider() {
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        Integer delId = 16;
        int count = providerService.deleteProvider(delId);
        logger.debug("testDeleteProviderById count =================== " + count);
    }
}