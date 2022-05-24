package com.ym.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.pojo.Plugins;

import java.util.List;

public interface IPluginService extends IService<Plugins> {
    IPage<Plugins> getPage(int currentPage, int pageSize);

    //根据用户ID查询该用户的所有插件
    List<Plugins> listByUserId(int uid);

    Boolean addByUserId(int uid, int pid);

    Boolean deleteByUserId(int uid, int pid);


    List<Plugins> listUnInstallByUserId(Integer uid);

    List<Plugins> listUnInstallByUserId(Integer uid, String name);

    List<Plugins> listByUserId(Integer uid, String name);
}
