package com.qiye.boss.utils;

import com.qiye.boss.dto.responseDto.LoginResponseDto;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by mazhaocai on 2017/12/14.
 * 权限操作工具类
 */
public class AuthUtils {

    public static Boolean getAuth(String authName, HttpSession session){
        LoginResponseDto responseDto = (LoginResponseDto)session.getAttribute("user");
        Map<String, Boolean> rightMap = responseDto.getOperRightMap();
        if (rightMap == null)
            return Boolean.FALSE;
        return rightMap.get(authName)!=null;
    }

    public static Boolean isLoginUser(HttpSession session){
        Object o = session.getAttribute("user");
        LoginResponseDto responseDto = (LoginResponseDto)session.getAttribute("user");
        return responseDto != null;
    }

    public static LoginResponseDto getUserBySession(HttpSession session){
        LoginResponseDto responseDto = (LoginResponseDto)session.getAttribute("user");
        return responseDto;
    }

    public static Integer getUserIdBySession(HttpSession session){
        LoginResponseDto responseDto = getUserBySession(session);
        if (responseDto == null)
            return null;
        return responseDto.getUserId();
    }

    public static String getUserCodeBySession(HttpSession session){
        LoginResponseDto responseDto = getUserBySession(session);
        if (responseDto == null)
            return null;
        return responseDto.getUserName();
    }

}
