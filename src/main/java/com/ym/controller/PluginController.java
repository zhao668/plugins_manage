package com.ym.controller;

import com.ym.config.R;
import com.ym.pojo.Plugins;
import com.ym.service.IPluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/plugins")
public class PluginController {

    @Autowired
    private IPluginService pluginService;

    //查询全部插件
    @GetMapping
    public R getAll(){
        return new R(true,pluginService.list());
    }

    //添加插件
    @PostMapping
    public R save(@RequestBody Plugins plugins){
        return new R(pluginService.save(plugins));
    }

    //更新插件
    @PutMapping
    public R update(@RequestBody Plugins plugins){
        return new R(pluginService.updateById(plugins));
    }

    //删除插件
    @DeleteMapping("{id}")
    public R delete(@PathVariable("id") Integer id){
        return new R(pluginService.removeById(id));
    }

    //根据id查询插件
    @GetMapping("{id}")
    public R getById(@PathVariable("id") Integer id){
        return new R(true, pluginService.getById(id));
    }

    //分页查询插件
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        return new R(true, pluginService.getPage(currentPage, pageSize));
    }
}
