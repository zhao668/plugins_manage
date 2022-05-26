package com.ym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.mapper.PluginMapper;
import com.ym.pojo.Plugins;
import com.ym.service.IPluginService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PluginServiceImpl extends ServiceImpl<PluginMapper,Plugins> implements IPluginService {

    @Autowired
    private PluginMapper pluginMapper;

    @Override
    public IPage<Plugins> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        pluginMapper.selectPage(page,null);
        return page;
    }

    //根据用户ID查询该用户的所有插件
    @Override
    public List<Plugins> listByUserId(int uid) {
        return pluginMapper.findAllByUserId(uid);
    }

    @Override
    public Boolean addByUserId(int uid, int pid) {
        return pluginMapper.addByUserId(uid, pid) > 0;
    }

    @Override
    public Boolean deleteByUserId(int uid, int pid) {
        return pluginMapper.deleteByUserId(uid, pid) > 0;
    }

    @Override
    public List<Plugins> listUnInstallByUserId(Integer uid) {
        return pluginMapper.findUnInstallByUserId(uid);
    }

    @Override
    public List<Plugins> listUnInstallByUserId(Integer uid, String name) {
        if(Strings.isNotEmpty(name)){
            return pluginMapper.findUnInstallByUserIdAndName(uid, name);
        }else{
            return pluginMapper.findUnInstallByUserId(uid);
        }

    }

    @Override
    public List<Plugins> listByUserId(Integer uid, String name) {
        if(Strings.isNotEmpty(name)){
            return pluginMapper.findAllByUserIdAndName(uid, name);
        }else{
            return pluginMapper.findAllByUserId(uid);
        }
    }

    //批量删除
    @Override
    public Boolean deleteByIds(long[] ids) {
       return pluginMapper.deleteByIds(ids) > 0;
    }

    @Override
    public IPage<Plugins> getPage(int currentPage, Integer pageSize, Plugins plugins) {
        LambdaQueryWrapper<Plugins> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(plugins.getName()),Plugins::getName,plugins.getName());
        lqw.like(Strings.isNotEmpty(plugins.getCreator()),Plugins::getCreator,plugins.getCreator());
        lqw.eq(plugins.getFlag()>=0,Plugins::getFlag,plugins.getFlag());
        IPage page = new Page(currentPage,pageSize);
        pluginMapper.selectPage(page,lqw);
        return page;
    }


}
