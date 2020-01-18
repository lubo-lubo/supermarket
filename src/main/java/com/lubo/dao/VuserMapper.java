package com.lubo.dao;

import com.lubo.vo.Vuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VuserMapper {
    public Vuser selectOne(Long uid);
    public List<Vuser> findAll();
    public List<Vuser> findAllByPage(int item);
    public List<Vuser> findBySome(@Param("userName")String userName,@Param("userRole")Long userRole);
    public List<Vuser> findBy(@Param("userName")String userName,@Param("userRole")Long userRole,@Param("item")Integer item);
}
