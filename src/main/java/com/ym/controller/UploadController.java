package com.ym.controller;


import com.ym.service.IUploadImageService;
import com.ym.utils.R;
import com.ym.utils.StringUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/qiniu")
public class UploadController {

    @Resource
    IUploadImageService uploadImageService;

    @PostMapping(value = "/image")
    private R upLoadImage(@RequestParam("file") MultipartFile file) throws IOException {

        // 获取文件的名称
        String fileName = file.getOriginalFilename();

        // 使用工具类根据上传文件生成唯一图片名称
        String imgName = StringUtil.getRandomImgName(fileName);

        if (!file.isEmpty()) {

            InputStream inputStream = (InputStream) file.getInputStream();

            String path = uploadImageService.uploadQNImg(inputStream, imgName);
            System.out.print("七牛云返回的图片链接:" + path);
            return new R(true,path,"图片上传成功");
        }
        return new R(false, "图片上传失败");
    }

}
