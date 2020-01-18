package com.lubo.service;

import com.lubo.pojo.Bill;
import com.lubo.pojo.Data;

import java.util.List;

public interface BillService {
    public List<Bill> findAll();
    public int addOne(Bill bill);
    public int updateOne(Bill bill);
    public Data deleteOne(Long id);
    public List<Bill> selectList(Bill bill);
}
