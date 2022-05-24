package com.ym.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@ApiModel(value="Plugin对象", description="")
public class Plugins {

    @ApiModelProperty(value = "插件id")
    private Integer id;

    @ApiModelProperty(value = "插件名称")
    private String name;

    @ApiModelProperty(value = "插件图片")
    private String avatar;

    @ApiModelProperty(value = "插件的创建者")
    private String creator;

    @ApiModelProperty(value = "插件的最后一次更新时间")
    private LocalDateTime updatetime;

    @ApiModelProperty(value = "插件被安装的次数")
    private Integer installnum;

    @ApiModelProperty(value = "插件功能描述")
    private String description;

    @ApiModelProperty(value = "插件的点赞数")
    private Integer likenum;

    @ApiModelProperty(value = "技术支持")
    private String support;

    @ApiModelProperty(value = "是否审核的标志")
    private Integer flag;
}
