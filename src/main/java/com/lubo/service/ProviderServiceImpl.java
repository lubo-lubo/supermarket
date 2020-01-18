package com.lubo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.lubo.dao.ProviderMapper;
import com.lubo.pojo.Provider;
import com.lubo.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderMapper providerMapper;
    @Override
    public List<Provider> findAll() {
        return providerMapper.selectList(null);
    }

    @Override
    public PageUtil<Provider> findAllByPage(int pageNo) {
        PageUtil<Provider> pageUtil=new PageUtil<>();
        pageUtil.setTotalCount(providerMapper.selectList(null).size());
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(6);
        List<Provider> lists=providerMapper.findAllByPage(pageUtil.getItem());
        pageUtil.setLists(lists);
        return pageUtil;
    }

    @Override
    public PageUtil<Provider> findBySome(Provider provider, int pageNo) {
        PageUtil<Provider> pageUtil=new PageUtil<>();
        pageUtil.setTotalCount(providerMapper.findBy(provider.getProCode(),provider.getProName()).size());
        pageUtil.setPageSize(6);
        pageUtil.setPageNo(pageNo);
        List<Provider> lists=providerMapper.findBySome(provider.getProCode(),provider.getProName(),pageUtil.getItem());
        pageUtil.setLists(lists);
        return pageUtil;
    }

    @Override
    public List<Provider> findBy(String proCode,String proName) {
        return providerMapper.findBy(proCode,proName);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int addOne(Provider provider) {
        return providerMapper.insert(provider);
    }

    @Override
    public Provider selectOne(Long id) {
        Provider provider=new Provider();
        provider.setId(id);
        return providerMapper.selectOne(provider);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
    public int updateOne(Provider provider) {
        return providerMapper.update(provider, new EntityWrapper<Provider>().eq("id",provider.getId()));
    }

    @Override
    public int deleteOne(Provider provider) {
        return providerMapper.delete(new EntityWrapper<Provider>().eq("id",provider.getId()));
    }
}
