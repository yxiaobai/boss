package com.qiye.boss.dto.requestDto;

/**
 * @Author: Ma Zhaocai
 * @Date: 2019-3-21
 */
public class LoginRequestDto {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
