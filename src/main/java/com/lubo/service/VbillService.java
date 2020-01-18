package com.lubo.service;

import com.lubo.util.PageUtil;
import com.lubo.vo.Vbill;

import java.util.List;

public interface VbillService {
    public List<Vbill> findAll();
    public PageUtil findAllByPage(int pageNo);
    public List<Vbill> findBySome(String productName,Long providerId,Long isPayment);
    public PageUtil findByPage(String productName,Long providerId,Long isPayment,Integer pageNo);
    public Vbill findById(Long bid);
}
