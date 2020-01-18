package com.lubo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lubo.dao.UserMapper;
import com.lubo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String name) {
        User user=new User();
        user.setUserCode(name);
        User u=userMapper.selectOne(user);
        return u;
    }

    @Override
    public boolean findUser(String name) {
        User user=new User();
        user.setUserCode(name);
        User u=userMapper.selectOne(user);
        if(u==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public User selectOne(String userCode) {
        User user=new User();
        user.setUserCode(userCode);
        return userMapper.selectOne(user);
    }

    @Override
    public User getOne(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int updateOne(User user) {
        return  userMapper.update(user,new EntityWrapper<User>().eq("id",user.getId()));
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int saveOne(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteOne(Long uid) {
        return userMapper.deleteById(uid);
    }


}
