package com.lubo.dao;

import com.lubo.util.PageUtil;
import com.lubo.vo.Vbill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VbillMapper {
    public List<Vbill> findAll();
    public List<Vbill> findAllByPage(int pageNo);
    public List<Vbill> findBySome(@Param("productName") String productName,@Param("providerId") Long providerId,@Param("isPayment") Long isPayment);
    public List<Vbill> findByPage(@Param("productName") String productName,@Param("providerId") Long providerId,@Param("isPayment") Long isPayment,@Param("item") int item );
    public Vbill findById(Long bid);
}
