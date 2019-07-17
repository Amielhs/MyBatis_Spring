package com.bdqn.mybatis.service.impl;

import com.bdqn.mybatis.mapper.BillMapper;
import com.bdqn.mybatis.pojo.Bill;
import com.bdqn.mybatis.service.BillService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("billService")
@Transactional
/*@Scope(value = "prototype") *//*Bean的作用域*/
public class BillServiceImpl implements BillService {
    @Resource //默认按类型匹配或者使用@Autowired
    @Qualifier("billMapper") //按指定名称匹配
    private BillMapper billMapper;

    public BillMapper getBillMapper() {
        return billMapper;
    }

    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    /**
     * @Description:订单表的查询
     * @param: [bill]
     * @return: java.util.List<com.bdqn.mybatis.pojo.Bill>
     * @Date: 2019-07-01
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public List<Bill> findBillByConditions(Bill bill) {
        try {
            return billMapper.getBillList(bill);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @Description:添加订单
     * @param: [bill]
     * @return: java.lang.Integer
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public Integer add(Bill bill) {
        return billMapper.add(bill);
    }

    /**
     * @Description:修改订单
     * @param: [bill]
     * @return: void
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public void update(Bill bill) {
        billMapper.update(bill);
    }

    /**
     * @Description:删除订单
     * @param: [id]
     * @return: void
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public void delete(Integer id) {
        billMapper.delete(id);
    }

    /**
     * @Description:查询订单
     * @param: [id]
     * @return: com.bdqn.mybatis.pojo.Bill
     * @Date: 2019-07-02
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public Bill getBill(Integer id) {
        return billMapper.getBill(id);
    }
}
