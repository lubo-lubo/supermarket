package com.lubo.service;

import com.lubo.pojo.Provider;
import com.lubo.util.PageUtil;

import java.util.List;

public interface ProviderService {
    public List<Provider> findAll();
    public PageUtil<Provider> findAllByPage(int pageNo);
    public PageUtil<Provider> findBySome(Provider provider,int pageNo);
    public List<Provider> findBy(String proCode,String proName);
    public int addOne(Provider provider);
    public Provider selectOne(Long id);
    public int updateOne(Provider provider);
    public int deleteOne(Provider provider);
}
