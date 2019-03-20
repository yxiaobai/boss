package com.qiye.boss.dto.requestDto;

/**
 * @Author: Ma Zhaocai
 * @Date: 2019-3-20
 * 分页请求
 */
public class BasePageRequestDto {
    private Integer pageNumber = 1;// 当前页码
    private Integer pageOffset = 0;//开始下标
    private Integer pageSize = 20;// 每页记录数




    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(Integer pageOffset) {
        this.pageOffset = pageOffset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
