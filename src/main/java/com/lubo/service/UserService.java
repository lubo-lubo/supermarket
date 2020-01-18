package com.lubo.service;

import com.lubo.pojo.User;

public interface UserService {
    public User login(String name);
    public boolean findUser(String name);
    public User selectOne(String userCode);
    public User getOne(Long id);
    public int updateOne(User user);
    public int saveOne(User user);
    public int deleteOne(Long uid);
}
