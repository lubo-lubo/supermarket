package com.lubo.service;

import com.lubo.dao.VuserMapper;
import com.lubo.util.PageUtil;
import com.lubo.vo.Vuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VuserServiceImpl implements VuserService{
    @Autowired
    private VuserMapper vuserMapper;
    @Override
    public List<Vuser> findAll() {
        return vuserMapper.findAll();
    }

    @Override
    public PageUtil<Vuser> findAllByPage(int pageNo) {
        PageUtil<Vuser> pageUtil=new PageUtil<>();
        pageUtil.setPageNo(pageNo);
        pageUtil.setTotalCount(vuserMapper.findAll().size());
        pageUtil.setPageSize(6);
        List<Vuser> lists=vuserMapper.findAllByPage(pageUtil.getItem());
        pageUtil.setLists(lists);
        return pageUtil;
    }

    @Override
    public List<Vuser> findBySome(String userName, Long userRole) {
        return vuserMapper.findBySome(userName,userRole);
    }

    @Override
    public PageUtil<Vuser> findBy(String userName, Long userRole, Integer pageNo) {
        PageUtil<Vuser> pageUtil=new PageUtil<>();
        pageUtil.setTotalCount(vuserMapper.findBySome(userName,userRole).size());
        pageUtil.setPageSize(6);
        pageUtil.setPageNo(pageNo);
        List<Vuser> lists=vuserMapper.findBy(userName,userRole,pageUtil.getItem());
        pageUtil.setLists(lists);
        return pageUtil;
    }

    @Override
    public Vuser selectOne(Long uid) {
        return vuserMapper.selectOne(uid);
    }
}
