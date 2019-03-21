package com.qiye.boss.service.impl;

import com.qiye.boss.dto.EnumTypeDto;
import com.qiye.boss.dto.MenuTreeDto;
import com.qiye.boss.dto.requestDto.BasePageRequestDto;
import com.qiye.boss.dto.requestDto.LoginRequestDto;
import com.qiye.boss.dto.responseDto.BasePageResponseDto;
import com.qiye.boss.dto.responseDto.LoginResponseDto;
import com.qiye.boss.mapper.UserMapper;
import com.qiye.boss.mapper.UserRoleFunctionMapper;
import com.qiye.boss.model.*;
import com.qiye.boss.service.UserService;
import com.qiye.boss.utils.ApiResult;
import com.qiye.boss.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ma Zhaocai
 * @Date: 2019-3-20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleFunctionMapper userRoleFunctionMapper;

    /**
     * 用户登陆
     * @param requestDto
     * @return
     */
    @Override
    public ApiResult<LoginResponseDto> login(LoginRequestDto requestDto) {
        ApiResult<LoginResponseDto> result = ApiResult.makeSuccessResult();
        LoginResponseDto responseDto = new LoginResponseDto();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(requestDto.getUserName());
        criteria.andPasswordEqualTo(MD5Utils.GetMD5Code(requestDto.getPassword()));
        List<User> userList = userMapper.selectByExample(example);
        if (userList.size()>0){
            User user = userList.get(0);
            if (EnumTypeDto.KeYong.getNum()==user.getStatus()){
                UserRoleFunctionExample example1 = new UserRoleFunctionExample();
                UserRoleFunctionExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andUseridEqualTo(user.getId());
                List<UserRoleFunction> userRoleFunctions = userRoleFunctionMapper.selectByExample(example1);
                if (userRoleFunctions.size()>0){
                    responseDto.setUserId(user.getId());
                    responseDto.setUserName(user.getUserName());
                    responseDto.setRealName(user.getRealName());
                    MenuTreeDto menuTreeDto = new MenuTreeDto();
                    responseDto.setMenuTreeDtoList(menuTreeDto.initMenuTree(userRoleFunctions));
                    responseDto.setOperRightMap(menuTreeDto.initRightOpMap(userRoleFunctions));
                    result.setData(responseDto);
                }else {
                    result.setMsg("用户未被激活,请联系管理员!");
                }
            }else {
                result.setMsg("用户已被禁用，请联系管理员!");
            }
        }else {
            result.setMsg("用户名或密码输入有误!");
        }
        return result;
    }

    /**
     * 分页获取数据
     * @param dto
     * @return
     */
    @Override
    public ApiResult<BasePageResponseDto> getUserListByPage(BasePageRequestDto dto) {
        ApiResult<BasePageResponseDto> result = ApiResult.makeSuccessResult();
        BasePageResponseDto responseDto = new BasePageResponseDto();
        dto.setPageOffset((dto.getPageNumber()-1)*dto.getPageSize());
        List<User> userList = userMapper.getUserListByPage(dto);
        responseDto.setList(userList);
        result.setData(responseDto);
        return result;
    }

    /**
     * 新增/修改 用户
     * @param user
     * @return
     */
    @Override
    public ApiResult<Boolean> updateUser(User user) {
        ApiResult<Boolean> result = ApiResult.makeSuccessResult();
        try {
            if (user.getId()==null){
                if (userMapper.insertSelective(user)>0){
                    result.setData(Boolean.TRUE);
                }else {
                    result.setData(Boolean.FALSE);
                    result.setMsg("add user error.....");
                }
            }else {
                if (userMapper.updateByPrimaryKeySelective(user)>0){
                    result.setData(Boolean.TRUE);
                }else {
                    result.setData(Boolean.FALSE);
                    result.setMsg("update user error.....");
                }
            }
        }catch (Exception e){
            result.setData(Boolean.FALSE);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    /**
     * 获取明细
     * @param id
     * @return
     */
    @Override
    public ApiResult<User> getUserDetailById(Integer id) {
        ApiResult<User> result = ApiResult.makeSuccessResult();
        User user = userMapper.selectByPrimaryKey(id);
        result.setData(user);
        return result;
    }
}
