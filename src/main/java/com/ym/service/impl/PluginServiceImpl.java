package com.ym.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.mapper.PluginMapper;
import com.ym.pojo.Plugins;
import com.ym.service.IPluginService;
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
}
