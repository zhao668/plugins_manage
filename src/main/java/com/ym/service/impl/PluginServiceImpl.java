package com.ym.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.mapper.PluginMapper;
import com.ym.pojo.Plugins;
import com.ym.service.IPluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
