package com.ym.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ym.pojo.Plugins;
import com.ym.service.IPluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plugins")
public class PluginController {

    @Autowired
    private IPluginService pluginService;

    //查询全部插件
    @GetMapping
    public List<Plugins> getAll(){
        return pluginService.list();
    }

    //添加插件
    @PostMapping
    public Boolean save(@RequestBody Plugins plugins){
        return pluginService.save(plugins);
    }

    //更新插件
    @PutMapping
    public Boolean update(@RequestBody Plugins plugins){
        return pluginService.updateById(plugins);
    }

    //删除插件
    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable("id") Integer id){
        return pluginService.removeById(id);
    }

    //根据id查询插件
    @GetMapping("{id}")
    public Plugins getById(@PathVariable("id") Integer id){
        return pluginService.getById(id);
    }

    //分页查询插件
    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Plugins> getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        return pluginService.getPage(currentPage, pageSize);
    }
}
