package com.qiye.boss.interceptor;

import com.alibaba.fastjson.JSON;
import com.qiye.boss.utils.ApiResult;
import com.qiye.boss.utils.AuthUtils;
import com.qiye.boss.utils.BossCommonUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by mazhaocai on 2017/12/4.
 */
@Component
public class ApiInterceptor extends HandlerInterceptorAdapter {

    /**
     * 接口拦截相关
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUrl = request.getRequestURI();
        HttpSession session = request.getSession();

        if (BossCommonUtils.needAuthCheck(requestUrl)) {
            //需要登录验证
            if (!AuthUtils.isLoginUser(session)) {
                ApiResult<String> result = ApiResult.errLogin();
                response.setHeader("Content-Type","application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                writer.append(JSON.toJSONString(result));
                writer.close();
                return false;
            }
        }
        /*if (!BossCommonUtils.getAuthWords(requestUrl).equals("")){
            //需要进行权限验证
            //验证的权限类型
            //主要针对TYPE=2的操作
            String authWord = BossCommonUtils.getAuthWords(requestUrl);
            if (!AuthUtils.getAuth(authWord,session)){
                ApiResult<String> result = ApiResult.errAuth(authWord);
                response.setHeader("Content-Type","application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                writer.append(JSON.toJSONString(result));
                writer.close();
                return false;
            }
//            else {
//                String afterUrl = BossCommonUtils.getAuthRightUrl(requestUrl);
//                response.sendRedirect(afterUrl);
//            }
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
