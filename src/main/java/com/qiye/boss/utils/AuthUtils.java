package com.qiye.boss.utils;

import com.qiye.boss.dto.responseDto.LoginResponseDto;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by mazhaocai on 2017/12/14.
 * 权限操作工具类
 */
public class AuthUtils {


    public static Boolean isLoginUser(HttpSession session){
        Object o = session.getAttribute("user");
        LoginResponseDto responseDto = (LoginResponseDto)session.getAttribute("user");
        return responseDto != null;
    }

}
