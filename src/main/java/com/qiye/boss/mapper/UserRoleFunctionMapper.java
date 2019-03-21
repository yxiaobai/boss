package com.qiye.boss.mapper;

import com.qiye.boss.model.UserRoleFunction;
import com.qiye.boss.model.UserRoleFunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleFunctionMapper {
    long countByExample(UserRoleFunctionExample example);

    int deleteByExample(UserRoleFunctionExample example);

    int insert(UserRoleFunction record);

    int insertSelective(UserRoleFunction record);

    List<UserRoleFunction> selectByExample(UserRoleFunctionExample example);

    int updateByExampleSelective(@Param("record") UserRoleFunction record, @Param("example") UserRoleFunctionExample example);

    int updateByExample(@Param("record") UserRoleFunction record, @Param("example") UserRoleFunctionExample example);
}