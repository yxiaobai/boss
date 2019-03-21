package com.qiye.boss.dto.responseDto;


import com.qiye.boss.dto.MenuTreeDto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by mashenwei on 2017/12/20.
 * 用户登录后的返回实体
 */
public class LoginResponseDto implements Serializable{

    private Integer userId;
    private String userName;
    private String realName;
    /** 用户关联的权限菜单树 */
    private List<MenuTreeDto> menuTreeDtoList;
    /** 用户关联的页签或按钮操作权限 */
    private Map<String, Boolean> operRightMap ;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<MenuTreeDto> getMenuTreeDtoList() {
        return menuTreeDtoList;
    }

    public void setMenuTreeDtoList(List<MenuTreeDto> menuTreeDtoList) {
        this.menuTreeDtoList = menuTreeDtoList;
    }

    public Map<String, Boolean> getOperRightMap() {
        return operRightMap;
    }

    public void setOperRightMap(Map<String, Boolean> operRightMap) {
        this.operRightMap = operRightMap;
    }
}
