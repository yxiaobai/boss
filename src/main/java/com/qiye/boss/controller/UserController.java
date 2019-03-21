package com.qiye.boss.controller;

import com.qiye.boss.dto.requestDto.BasePageRequestDto;
import com.qiye.boss.dto.requestDto.LoginRequestDto;
import com.qiye.boss.dto.responseDto.BasePageResponseDto;
import com.qiye.boss.dto.responseDto.LoginResponseDto;
import com.qiye.boss.model.User;
import com.qiye.boss.service.UserService;
import com.qiye.boss.utils.ApiResult;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Ma Zhaocai
 * @Date: 2019-3-20
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult login(HttpServletRequest request, @RequestBody LoginRequestDto requestDto){
        ApiResult<LoginResponseDto> result = userService.login(requestDto);
        if (result.getData() != null) {
            request.getSession().setAttribute("user", result.getData());
        }
        return result;
    }

    /**
     * 分页获取数据
     * @param dto
     * @return
     */
    @RequestMapping(value = "/auth_UQ2/getUserListByPage",method = RequestMethod.POST)
    public ApiResult<BasePageResponseDto> getUserListByPage(@RequestBody BasePageRequestDto dto){
        ApiResult<BasePageResponseDto> result = userService.getUserListByPage(dto);
        return result;
    }

    /**
     * 新增/修改  用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/auth_A1/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<Boolean> updateUser(@RequestBody User user){
        ApiResult<Boolean> result = userService.updateUser(user);
        return result;
    }

    @RequestMapping(value = "/auth_UQ1/getUserDetailById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<User> getUserDetailById(@PathVariable Integer id){
        ApiResult<User> result = userService.getUserDetailById(id);
        return result;
    }

}
