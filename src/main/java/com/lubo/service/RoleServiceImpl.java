package com.lubo.service;

import com.lubo.dao.RoleMapper;
import com.lubo.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAll() {
        return roleMapper.selectList(null);
    }
}
