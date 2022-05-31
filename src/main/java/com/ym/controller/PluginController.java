package com.ym.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ym.pojo.Plugins;
import com.ym.service.IPluginService;
import com.ym.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


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
        plugins.setUpdatetime(new Date());
        Boolean flag = pluginService.save(plugins);
        return new R(flag, flag ? "添加成功" : "添加失败");
    }

    //更新插件
    @PutMapping
    public R update(@RequestBody Plugins plugins){
        plugins.setUpdatetime(new Date());
        Boolean flag = pluginService.updateById(plugins);
        return new R(flag, flag ? "更新成功" : "更新失败");
    }

    //删除插件
    @DeleteMapping("{ids}")
    public R delete(@PathVariable("ids") long[] ids){
        Boolean flag = pluginService.deleteByIds(ids);
        return new R(flag, flag ? "删除成功" : "删除失败");
    }

    //根据id查询插件
    @GetMapping("{id}")
    public R getById(@PathVariable("id") Integer id){
        return new R(true, pluginService.getById(id));
    }

    //分页查询插件
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, Plugins plugins){
        IPage<Plugins> page = pluginService.getPage(currentPage, pageSize,plugins);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = pluginService.getPage(1, pageSize,plugins);
        }
        return new R(true, page);
    }

    //根据用户ID查询该用户的所有插件
    @GetMapping("/user/{uid}")
    public R listByUserId(@PathVariable("uid") Integer uid, String name){
        List<Plugins> pluginsList = pluginService.listByUserId(uid, name);
        return new R(true, pluginsList);
    }

    //根据用户ID查询该用户未安装的所有插件
    @GetMapping("/user/uninstall/{uid}")
    public R listUnInstall(@PathVariable("uid") Integer uid, String name){
        List<Plugins> pluginsList = pluginService.listUnInstallByUserId(uid, name);
        return new R(true, pluginsList);
    }

    //根据用户ID给该用户添加插件
    @PostMapping("/user/{uid}/{pid}")
    public R install(@PathVariable("uid") Integer uid, @PathVariable("pid") Integer pid) {
        Boolean flag = pluginService.addByUserId(uid,pid);
        return new R(flag, flag ? "安装插件成功" : "安装插件失败");
    }

    //根据用户ID给该用户删除插件
    @DeleteMapping("/user/{uid}/{pid}")
    public R uninstall(@PathVariable("uid") Integer uid, @PathVariable("pid") Integer pid) {
        Boolean flag = pluginService.deleteByUserId(uid,pid);
        return new R(flag, flag ? "卸载插件成功" : "卸载插件失败");
    }

}
