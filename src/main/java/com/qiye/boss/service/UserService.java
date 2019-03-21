package com.qiye.boss.service;

import com.qiye.boss.dto.requestDto.BasePageRequestDto;
import com.qiye.boss.dto.requestDto.LoginRequestDto;
import com.qiye.boss.dto.responseDto.BasePageResponseDto;
import com.qiye.boss.dto.responseDto.LoginResponseDto;
import com.qiye.boss.model.User;
import com.qiye.boss.utils.ApiResult;

/**
 * @Author: Ma Zhaocai
 * @Date: 2019-3-20
 */
public interface UserService {

    ApiResult<LoginResponseDto> login(LoginRequestDto requestDto);

    ApiResult<BasePageResponseDto> getUserListByPage(BasePageRequestDto dto);

    ApiResult<Boolean> updateUser(User user);

    ApiResult<User> getUserDetailById(Integer id);
}
