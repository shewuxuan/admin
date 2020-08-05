package com.guodu.controller;

import com.alibaba.fastjson.JSON;
import com.guodu.pojo.sys.Auth;
import com.guodu.pojo.sys.UserInfo;
import com.guodu.service.impl.sys.UserInfoServiceImpl;
import com.guodu.util.MD5Utils;
import com.guodu.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginAction {

    @Resource(name = "userInfoServiceImpl")
    UserInfoServiceImpl userInfoServiceImpl;

    @RequestMapping(value = {"login", "/"})
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("redirect:/index.jsp");
        return view;
    }

    @RequestMapping(value = {"loginJson.action", "/"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    @ResponseBody
    public Object loginJson(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam Map<String, Object> form) {
        Map<String, Object> res = new HashMap<String, Object>();
        String loginname = (String) form.get("loginname");
        String password = (String) form.get("password");
        String validateCode = (String) form.get("vCode");
        if (StringUtils.isEmpty(loginname)) {
            res.put("code", "-1");
            res.put("message", "用户名不可以为空!");
            res.put("url", "login");
            return JSON.toJSONString(res);
        }

        if (StringUtils.isEmpty(password)) {
            res.put("code", "-1");
            res.put("message", "密码不可以为空！");
            res.put("url", "login");
            return JSON.toJSONString(res);
        }
        if (StringUtils.isEmpty(validateCode)) {
            res.put("code", "-1");
            res.put("message", "请输入验证码！");
            res.put("url", "login");
            return JSON.toJSONString(res);
        }
        String vCode = (String) request.getSession().getAttribute("validateCode");
        if (!validateCode.toUpperCase().equals(vCode)) {
            res.put("code", "-1");
            res.put("message", "验证码不正确！");
            res.put("url", "login");
            return JSON.toJSONString(res);
        }

        Map<String, Object> vo = new HashMap<String, Object>();
        vo.put("loginName", loginname);
        vo.put("password", MD5Utils.MD5(password, "UTF-8"));
        UserInfo userInfo;
        try {
            userInfo = this.userInfoServiceImpl.queryUserByNamePassword(vo);
        } catch (Exception e) {
            e.printStackTrace();
            res.put("code", "-1");
            res.put("message", "查询数据出错！");
            res.put("url", "login");
            return JSON.toJSONString(res);
        }

        if (userInfo == null) {
            res.put("code", "-1");
            res.put("message", "用户名或密码错误，请检查！");
            res.put("url", "login");
            return JSON.toJSONString(res);
        }

        if (!userInfo.getUserType().equals("0")) {
            res.put("code", "-1");
            res.put("message", "无登录权限！");
            res.put("url", "login");
            return JSON.toJSONString(res);
        }
        Auth auth = new Auth();
        auth.setUserType(userInfo.getUserType());
        auth.setUserId(userInfo.getUserId());
        auth.setName(userInfo.getUserName());
        auth.setLoginname(userInfo.getLoginName());
        auth.setRoleId(userInfo.getRoleId());
        auth.setZwSsqy(userInfo.getZw());
        request.getSession().removeAttribute("auth"); // 先清空一下
        request.getSession().setAttribute("auth", auth);
        res.put("code", "0");
        res.put("message", "登录成功！");
        return JSON.toJSONString(res);
    }

    @RequestMapping(value = {"logoutJson.action", "/"}, produces = {"application/json;charset=UTF-8"})
    public ModelAndView logoutJson(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("redirect:/login");
        Auth auth = Auth.getAuth(request);
        request.getSession().setAttribute("oldAuth", auth);
        request.getSession().removeAttribute("auth");
        request.getSession().removeAttribute("validateCode");
        return view;
    }

    @RequestMapping(value = {"main.action", "/"}, produces = {"application/json;charset=UTF-8"})
    public ModelAndView main(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("/main");
        Map<String, Object> funcMap = this.userInfoServiceImpl.getComboTreeData(Auth.getAuth(request).getRoleId());
        Auth.getAuth(request).setRoleFunc(funcMap);
        view.addObject("funcMap", funcMap);
        return view;
    }

    @RequestMapping(value = {"toTopView.action", "/"}, produces = {"application/json;charset=UTF-8"})
    public ModelAndView main1(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("/top");
        view.addObject("loginName",Auth.getAuth(request).getLoginname());
        return view;
    }

    @RequestMapping(value = {"toLeftView.action", "/"}, produces = {"application/json;charset=UTF-8"})
    public ModelAndView main2(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("/left");
        view.addObject("funcMap", Auth.getAuth(request).getRoleFunc());
        return view;
    }

    @RequestMapping(value = {"toSjglView.action",  "/" }, produces = { "application/json;charset=UTF-8" })
    public ModelAndView main3(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("sjgl/sjgl");
        //view.addObject("funcMap", Auth.getAuth(request).getRoleFunc());
        return view;
    }
}