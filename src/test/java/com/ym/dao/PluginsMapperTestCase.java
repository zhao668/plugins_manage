package com.ym.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.mapper.PluginMapper;
import com.ym.pojo.Plugins;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PluginsMapperTestCase {

    @Autowired
    private PluginMapper pluginMapper;

    @Test
    void testGetById() {
        pluginMapper.selectById(1);
    }

    @Test
    void testSave() {
        Plugins plugins = new Plugins();
        plugins.setName("jquery");
        plugins.setDescription("jquery框架");
        plugins.setCreator("ym");
        pluginMapper.insert(plugins);
    }

    @Test
    void testUpdate() {
        Plugins plugins = new Plugins();
        plugins.setId(2);
        plugins.setName("jqueryaaa");
        plugins.setDescription("jquery框架");
        plugins.setCreator("ym");
        pluginMapper.updateById(plugins);
    }

    @Test
    void testDelete() {
        pluginMapper.deleteById(10);
    }

    @Test
    void testGetAll() {
        pluginMapper.selectList(null);
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1,5);
        pluginMapper.selectPage(page, null);
    }

    @Test
    void testGetBy() {
        String name = "pa";
        LambdaQueryWrapper<Plugins> lqw = new LambdaQueryWrapper<>();
        lqw.like(name!=null,Plugins::getName, name);
        pluginMapper.selectList(lqw);
    }
}
