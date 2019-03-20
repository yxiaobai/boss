package com.qiye.boss.controller;

import com.qiye.boss.dto.requestDto.BasePageRequestDto;
import com.qiye.boss.dto.responseDto.BasePageResponseDto;
import com.qiye.boss.model.User;
import com.qiye.boss.service.UserService;
import com.qiye.boss.utils.ApiResult;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 分页获取数据
     * @param dto
     * @return
     */
    @RequestMapping(value = "/getUserListByPage",method = RequestMethod.POST)
    public ApiResult<BasePageResponseDto> getUserListByPage(@RequestBody BasePageRequestDto dto){
        ApiResult<BasePageResponseDto> result = userService.getUserListByPage(dto);
        return result;
    }

    /**
     * 新增/修改  用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<Boolean> updateUser(@RequestBody User user){
        ApiResult<Boolean> result = userService.updateUser(user);
        return result;
    }

    @RequestMapping(value = "/getUserDetailById/{id}",method = RequestMethod.GET)
    public ApiResult<User> getUserDetailById(@PathVariable Integer id){
        ApiResult<User> result = userService.getUserDetailById(id);
        return result;
    }

}
