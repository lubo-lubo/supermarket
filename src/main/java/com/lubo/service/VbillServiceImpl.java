package com.lubo.service;

import com.lubo.dao.VbillMapper;
import com.lubo.util.PageUtil;
import com.lubo.vo.Vbill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VbillServiceImpl implements VbillService {
    @Autowired
    private VbillMapper vbillMapper;
    @Override
    public List<Vbill> findAll() {
        List<Vbill> list=vbillMapper.findAll();
        return list;
    }

    @Override
    public PageUtil findAllByPage(int pageNo) {
        PageUtil pu=new PageUtil();
        List<Vbill> list=vbillMapper.findAll();
        int totalCount=list.size();
        pu.setPageNo(pageNo);
        pu.setPageSize(6);
        pu.setTotalCount(totalCount);
        List<Vbill> list2=vbillMapper.findAllByPage(pu.getItem());//pu讲页码转为条目
        pu.setLists(list2);
        return pu;
    }

    @Override
    public List<Vbill> findBySome(String productName, Long providerId, Long isPayment) {
        return vbillMapper.findBySome(productName,providerId,isPayment);
    }

    @Override
    public PageUtil findByPage(String productName, Long providerId, Long isPayment, Integer pageNo) {
        PageUtil pu=new PageUtil();
        List<Vbill> list= vbillMapper.findBySome(productName,providerId,isPayment);
        pu.setPageSize(6);
        pu.setTotalCount(list.size());
        pu.setPageNo(pageNo);
        List<Vbill> list2=vbillMapper.findByPage(productName,providerId,isPayment,pu.getItem());
        pu.setLists(list2);
        return pu;
    }

    @Override
    public Vbill findById(Long bid) {
        return vbillMapper.findById(bid);
    }


}
