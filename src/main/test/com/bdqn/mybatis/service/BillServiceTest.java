package com.bdqn.mybatis.service;

import com.bdqn.mybatis.pojo.Bill;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class BillServiceTest {
    private Logger logger = Logger.getLogger(this.getClass());
    ApplicationContext context = null;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * @Description:订单表的查询
     * @param: []
     * @return: void
     * @Date: 2019-07-01
     */
    @Test
    public void findBillByConditions() {
        BillService billService = (BillService) context.getBean("billService");
        List<Bill> billList = new ArrayList<Bill>();
        Bill bill = new Bill();
        bill.setIsPayment(2);
        bill.setProductName("油");
        bill.setProviderId(7);
        billList = billService.findBillByConditions(bill);

        for (Bill element : billList) {
            logger.debug("testGetBillList id: "
                    + element.getId()
                    + " and BillCode: "
                    + element.getBillCode()
                    + " and ProductName: "
                    + element.getProductName()
                    + " and ProviderName: "
                    + element.getProviderName()
                    + " and TotalPrice: "
                    + element.getTotalPrice()
                    + " and IsPayment: "
                    + element.getIsPayment()
                    + " and CreationDate:"
                    + new SimpleDateFormat("yyyy-MM-dd").format(element.getCreationDate()));
        }
    }

    /**
     * @Description:添加订单
     * @param: []
     * @return: void
     * @Date: 2019-07-02
     */
    @Test
    public void add() {
        BillService billService=(BillService) context.getBean("billService");

        Bill bill=new Bill();
        bill.setBillCode("BILL2016_019");
        bill.setProductName("哇哈哈");
        bill.setProductDesc("饮料");
        bill.setProductUnit("瓶");
        bill.setProductCount(new BigDecimal(2000));
        bill.setTotalPrice(new BigDecimal(4000));
        bill.setIsPayment(2);
        bill.setCreatedBy(1);
        bill.setCreationDate(new Date());
        bill.setProviderId(2);

        billService.add(bill);
        System.out.println("ID: "+bill.getId() +"已添加");
    }

    /**
     * @Description:修改订单
     * @param: []
     * @return: void
     * @Date: 2019-07-02
     */
    @Test
    public void update() {
        BillService billService=(BillService) context.getBean("billService");
        Bill bill = new Bill();
        System.out.println(bill.getTotalPrice());
        bill.setId(19);
        bill.setTotalPrice(new BigDecimal(10000));
        billService.update(bill);
        System.out.println("ID: "+bill.getId() +"已修改");
        System.out.println(bill.getTotalPrice());
    }

    /**
     * @Description:删除订单
     * @param: []
     * @return: void
     * @Date: 2019-07-02
     */
    @Test
    public void delete() {
        BillService billService=(BillService) context.getBean("billService");
        Bill bill = new Bill();
        bill.setId(19);
        billService.delete(bill.getId());
        System.out.println("ID: "+bill.getId() +"已删除");
    }

    /**
     * @Description:查询订单
     * @param: []
     * @return: void
     * @Date: 2019-07-02
     */
    @Test
    public void getBill() {
        BillService billService=(BillService) context.getBean("billService");
        Bill bill = new Bill();
        bill.setId(1);
        billService.getBill(bill.getId());
    }
}