package com.lubo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lubo.dao.BillMapper;
import com.lubo.pojo.Bill;
import com.lubo.pojo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BillServiceImpl implements BillService{
    @Autowired
    private BillMapper billMapper;
    @Override
    public List<Bill> findAll() {
        List<Bill> list=billMapper.selectList(null);
        return list;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.SUPPORTS)
    public int addOne(Bill bill) {
        return billMapper.insert(bill);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.SUPPORTS)
    public int updateOne(Bill bill) {
        return billMapper.updateById(bill);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.SUPPORTS)
    public Data deleteOne(Long id) {
        Data data=new Data();
        Bill b=new Bill();
        b.setId(id);
        Bill bill=billMapper.selectOne(b);
        if(bill==null){
            data.setDelResult("notexist");
        }else{
            billMapper.deleteById(b);
            data.setDelResult("true");
        }
        return data;
    }

    @Override
    public List<Bill> selectList(Bill bill) {
        return billMapper.selectList(new EntityWrapper<Bill>().eq("providerId",bill.getProviderId()));
    }


}
