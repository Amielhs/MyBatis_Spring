package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.Bill;

import java.util.List;

public interface BillMapper {
    /**
     * @Description:查询订单列表
     * @param: [bill]
     * @return: java.util.List<com.bdqn.mybatis.pojo.Bill>
     * @Date: 2019-07-01
     */
    public List<Bill> getBillList(Bill bill);

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
