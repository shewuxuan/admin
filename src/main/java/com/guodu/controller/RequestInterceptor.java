package com.guodu.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean check = false;
        StringBuffer url = request.getRequestURL();
       if(isStatic(url)){
           check = true;
       }else{
           Object auth = request.getSession().getAttribute("auth");
           if(auth == null){
               String scheme = request.getScheme();
               String serverName = request.getServerName();
               int port = request.getServerPort();
               String context = request.getContextPath();
               String path = scheme+"://"+serverName+":"+port+context+"/";
               String str = "<script language='javascript'>alert('登录状态过期，请重新登陆!');"
                       +"if (window != top){top.location.href = '"+ path +"login';}location.href='"+path+"login'"
                       +"</script>";
               response.setContentType("text/html;charset=UTF-8");// 解决中文乱码
               try {
                   PrintWriter writer = response.getWriter();
                   writer.write(str);
                   writer.flush();
                   writer.close();
               } catch (Exception e) {e.printStackTrace();}
           }else{
               check = true;
           }
       }
       return  check;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public boolean isStatic(StringBuffer url) {
        boolean result = false;
        String[] arr = {
                "/login", //首页
                "/img", //验证码
                "/css",
                "/style",//样式表
                "/images",//图片
                "/js",//js脚本
                "/themes",//themes模板
                "/demo",
                "/layui",
                "/selectByAll",
                "/getUsers",
                "/uploadJl",
                "/uploadPwbhJl",
                "/changeJbxxFiles",
                "/uploadJbxxPhotos",
                "/sccj",
                "/ssxl",
                "getPwbh",
                "getFtu"
        };
        for (String a : arr) {
            if (url.indexOf(a) != -1) {
                result = true;
            }
        }
        return result;
    }
}
