package com.lubo.service;

import com.lubo.util.PageUtil;
import com.lubo.vo.Vuser;

import java.util.List;

public interface VuserService {
    public List<Vuser> findAll();
    public PageUtil<Vuser> findAllByPage(int pageNo);
    public List<Vuser> findBySome(String userName,Long userRole);
    public PageUtil<Vuser> findBy(String userName,Long userRole,Integer pageNo);
    public Vuser selectOne(Long uid);
}
