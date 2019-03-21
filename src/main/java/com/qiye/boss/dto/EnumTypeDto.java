package com.qiye.boss.dto;

/**
 * @Author: Ma Zhaocai
 * @Date: 2019-3-21
 */
public enum  EnumTypeDto {
    genjiedian("根节点",0),mokuai("模块",1),yeqian("标签",2),
    KeYong("可用",1),JinYong("禁用",0);
    private String name;
    private Integer num;

    EnumTypeDto(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
