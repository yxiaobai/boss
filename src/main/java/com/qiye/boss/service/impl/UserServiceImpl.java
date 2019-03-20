package com.qiye.boss.service.impl;

import com.qiye.boss.dto.requestDto.BasePageRequestDto;
import com.qiye.boss.dto.responseDto.BasePageResponseDto;
import com.qiye.boss.mapper.UserMapper;
import com.qiye.boss.model.User;
import com.qiye.boss.service.UserService;
import com.qiye.boss.utils.ApiResult;
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
