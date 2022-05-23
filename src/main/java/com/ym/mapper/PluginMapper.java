package com.ym.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ym.pojo.Plugins;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PluginMapper extends BaseMapper<Plugins> {

   List<Plugins> findAllByUserId(int uid);

   int deleteByUserId(int uid, int pid);

   int addByUserId(int uid, int pid);
}
