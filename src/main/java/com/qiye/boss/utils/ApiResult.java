package com.qiye.boss.utils;


import com.qiye.boss.common.RetConstant;

/**
 * @Author: Ma Zhaocai
 * @Date: 2019-3-20
 * 接口统一返回对象
 */
public class ApiResult<TData> {

    int ret;//返回码,ret=200时，代表接口调用成功。

    String msg; // 返回信息,ret不等于200时，抛出异常信息

    String clientMsg;//返回给客户端信息.

    public TData data;//对象

    public static ApiResult makeSuccessResult()
    {
        ApiResult result = new ApiResult();
        result.setMsg(RetConstant.MSG_SUCCESS);
        result.setRet(RetConstant.CODE_SUCCESS);
        result.setData(null);
        return result;
    }

    public static ApiResult errLogin() {
        ApiResult<String> result = ApiResult.makeSuccessResult();
        result.setRet(RetConstant.CODE_UNLOGIN);
        result.setData(null);
        result.setMsg(RetConstant.MSG_UNLOGIN);
        result.setClientMsg("");
        return result;
    }

    public static ApiResult errAuth(String errAuthString) {
        ApiResult<String> result = ApiResult.makeSuccessResult();
        result.setRet(RetConstant.CODE_NORIGHT);
        result.setData(null);
        result.setMsg(RetConstant.MSG_NORIGHT);
        result.setClientMsg("");
        return result;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getClientMsg() {
        return clientMsg;
    }

    public void setClientMsg(String clientMsg) {
        this.clientMsg = clientMsg;
    }

    public TData getData() {
        return data;
    }

    public void setData(TData data) {
        this.data = data;
    }
}
