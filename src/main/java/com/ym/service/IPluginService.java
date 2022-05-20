package com.ym.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.pojo.Plugins;

public interface IPluginService extends IService<Plugins> {
    IPage<Plugins> getPage(int currentPage, int pageSize);

}
