package com.lubo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lubo.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper extends BaseMapper<Provider> {
    public List<Provider> findAllByPage(int item);
    public List<Provider> findBySome(@Param("proCode") String proCode, @Param("proName") String proName,@Param("item") int item);
    public List<Provider> findBy(@Param("proCode")String proCode,@Param("proName")String proName);
}
