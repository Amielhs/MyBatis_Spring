/*package com.bdqn.mybatis.mapper.impl;

import com.bdqn.mybatis.mapper.BillMapper;
import com.bdqn.mybatis.pojo.Bill;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
//仅在使用SqlSessionTemplate时使用映射器的实现类。
public class BillMapperImpl implements BillMapper {
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Bill> getBillList(Bill bill) {
        return null;
    }

    @Override
    public Integer add(Bill bill) {
        return sqlSessionTemplate.getMapper(BillMapper.class).add(bill);
    }

    @Override
    public void update(Bill bill) {
        sqlSessionTemplate.getMapper(BillMapper.class).update(bill);
    }

    @Override
    public void delete(Integer id) {
        sqlSessionTemplate.getMapper(BillMapper.class).delete(id);
    }

    @Override
    public Bill getBill(Integer id) {
        return sqlSessionTemplate.getMapper(BillMapper.class).getBill(id);
    }
}*/
