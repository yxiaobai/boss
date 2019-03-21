package com.qiye.boss.dto;

import com.qiye.boss.model.UserRoleFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mazhaocai on 2017/12/20.
 * 用户菜单内容
 */
public class MenuTreeDto {

    /** 父目录菜单 */
    private String parentMenu;
    private String menuCode;
    /**
     * menuId 菜单ID
     */
    private String menuId;
    /**
     * menuLevel 菜单类别（一级菜单/二级菜单)
     */
    private Integer menuType;
    /**
     * menuId 菜单名称
     */
    private String menuTitle;
    /**
     * menuId 菜单链接
     */
    //private String menuHref;
    /**
     * menuId 子菜单
     */
    private List<MenuTreeDto> menuChildren;

    public String getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(String parentMenu) {
        this.parentMenu = parentMenu;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    /*public String getMenuHref() {
        return menuHref;
    }

    public void setMenuHref(String menuHref) {
        this.menuHref = menuHref;
    }*/

    public List<MenuTreeDto> getMenuChildren() {
        return menuChildren;
    }

    public void setMenuChildren(List<MenuTreeDto> menuChildren) {
        this.menuChildren = menuChildren;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /** 初始化用户动态菜单 */
    public List<MenuTreeDto> initMenuTree(List<UserRoleFunction> list){
        List<MenuTreeDto> menuTreeDtoList = new ArrayList<>();
        //重新封装menuTree
        for (UserRoleFunction UserRoleFunction: list){
            MenuTreeDto parentMenuDto = new MenuTreeDto();
            if (UserRoleFunction.getType()==0){
                List<MenuTreeDto> childList = new ArrayList<>();
                for (UserRoleFunction childModel: list){
                    MenuTreeDto childMenuDto = new MenuTreeDto();
                    if (childModel.getType()==1 && childModel.getParentid().equals(UserRoleFunction.getFunctionid())){
                        childMenuDto.setMenuChildren(null);
                        childMenuDto.setMenuCode(childModel.getFunctioncode());
                        //childMenuDto.setMenuHref(childModel.getModelUrl());
                        childMenuDto.setMenuId(childModel.getFunctionid().toString());
                        childMenuDto.setMenuTitle(childModel.getFunctionname());
                        childMenuDto.setMenuType(childModel.getType());
                        childList.add(childMenuDto);
                    }
                }
                parentMenuDto.setMenuChildren(childList);
                parentMenuDto.setMenuCode(UserRoleFunction.getFunctioncode());
                //parentMenuDto.setMenuHref(UserRoleFunction.getModelUrl());
                parentMenuDto.setMenuId(UserRoleFunction.getFunctionid().toString());
                parentMenuDto.setMenuTitle(UserRoleFunction.getFunctionname());
                parentMenuDto.setMenuType(UserRoleFunction.getType());
                menuTreeDtoList.add(parentMenuDto);
            }
        }
        return menuTreeDtoList;
    }

    /** 初始化用户权限数据 */
    public Map<String, Boolean> initRightOpMap(List<UserRoleFunction> list){
        Map<String, Boolean> rightMap = new HashMap<>();
        for (UserRoleFunction UserRoleFunction: list) {
            if (UserRoleFunction.getType() == 2 || UserRoleFunction.getType() == 1) {
                rightMap.put(UserRoleFunction.getFunctioncode(), Boolean.TRUE);
            }
        }
        return rightMap;
    }
}
