package com.ym.pojo;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Plugins {

    private Integer id;


    private String name;


    private String avatar;


    private String creator;


    private LocalDateTime updatetime;


    private Integer installnum;


    private String description;

    private Integer likenum;

    private String support;

}
