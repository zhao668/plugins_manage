package com.ym.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.pojo.Plugins;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PluginServiceTestCase {
    @Autowired
    private IPluginService pluginService;

    @Test
    void testGetById() {
        System.out.println(pluginService.getById(1));
    }

    @Test
    void testSave() {
        Plugins plugins = new Plugins();
        plugins.setName("jquery");
        plugins.setDescription("jquery框架");
        plugins.setCreator("ym");
        pluginService.save(plugins);
    }

    @Test
    void testUpdate() {
        Plugins plugins = new Plugins();
        plugins.setId(13);
        plugins.setName("jquerya111111111aa");
        plugins.setDescription("jquery框架");
        plugins.setCreator("ym");
        pluginService.updateById(plugins);
    }

    @Test
    void testDelete() {
        pluginService.removeById(13);
    }

    @Test
    void testGetAll() {
        System.out.println(pluginService.list());
    }

    @Test
    void testGetPage() {
        IPage<Plugins> page = new Page<Plugins>(1,5);
        pluginService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
