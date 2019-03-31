package com.qiye.boss.mapper;

import com.qiye.boss.model.Gradation;

import java.util.List;

public interface GradationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gradation record);

    int insertSelective(Gradation record);

    Gradation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gradation record);

    int updateByPrimaryKey(Gradation record);

    List<Gradation> selectListByProductId();

    List<Gradation> getGradationList();
}