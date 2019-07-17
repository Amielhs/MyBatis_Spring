package com.bdqn.mybatis.service;

import com.bdqn.mybatis.pojo.Bill;

import java.util.List;

public interface BillService {
    /**
     * @Description:订单表的查询
     * @param: [bill]
     * @return: List<Bill>
     * @Date: 2019-07-01
     */
    List<Bill> findBillByConditions(Bill bill);

    /**
     * @Description:添加订单
     * @param: [bill]
     * @return: java.lang.Integer
     * @Date: 2019-07-02
     */
    public Integer add(Bill bill);

    /**
     * @Description:修改订单
     * @param: [bill]
     * @return: void
     * @Date: 2019-07-02
     */
    public void update(Bill bill);

    /**
     * @Description:删除订单
     * @param: [id]
     * @return: void
     * @Date: 2019-07-02
     */
    public void delete(Integer id);

    /**
     * @Description:查询订单
     * @param: [id]
     * @return: com.bdqn.mybatis.pojo.Bill
     * @Date: 2019-07-02
     */
    public Bill getBill(Integer id);
}
