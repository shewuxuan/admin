package com.guodu.controller.sys;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.guodu.pojo.sys.Auth;
import com.guodu.pojo.sys.UserInfo;
import com.guodu.service.impl.sys.UserInfoServiceImpl;
import com.guodu.util.F;
import com.guodu.util.MD5Utils;
import com.guodu.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("user")
public class UserInfoAction {
    private static Logger log = Logger.getLogger(UserInfoAction.class);
    @Autowired
    UserInfoServiceImpl userInfoServiceImpl;

    @RequestMapping(value = {"sysByUser.action", "/"}, produces = {"application/json;charset=UTF-8"})
    public ModelAndView sysByUser(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("sys/userManage");
        view.addObject("funcMap", Auth.getAuth(request).getRoleFunc());
        return view;
    }

    @RequestMapping(value = {"selectListUserInfo.action", "/"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Object selectListUserInfo(HttpServletRequest request, @RequestParam Map<String, Object> form) {
        Map<String, Object> res = new HashMap<String, Object>();
        String rows = (String) form.get("rows");
        String page = (String) form.get("page");
        String loginName = (String) form.get("loginName");
        String userName = (String) form.get("userName");
        String zt = (String) form.get("zt");
        Map<String, Object> vo = new HashMap<String, Object>();
        vo.put("loginName", loginName);
        vo.put("userName", userName);
        vo.put("zt", zt);
        vo.put("rows", rows);
        vo.put("page", page);
        try {
            res = this.userInfoServiceImpl.selectPage(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(res);

    }

    @RequestMapping(value = {"toAddUserInfoView.action", "/"}, produces = {"application/json;charset=UTF-8"})
    public ModelAndView toAddUserInfoView(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("sys/addUser");
        String userId = request.getParameter("userId") == null ? "" : request.getParameter("userId").toString();
        if (!userId.equals("")) {
            Map<String, Object> vo = new HashMap<String, Object>();
            vo.put("userId", userId);
            UserInfo userInfo = this.userInfoServiceImpl.selectList(vo).get(0);
            view.addObject("userInfo", userInfo);
        }
        view.addObject("funcMap",Auth.getAuth(request).getRoleFunc());
        return view;
    }

    @RequestMapping(value = {"addUserInfo.action", "/"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Object addUserInfo(UserInfo userInfo, HttpServletRequest request) {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("code", "0");
        res.put("message", "添加成功");
        String loginName = userInfo.getLoginName();
        Map<String, Object> vo = new HashMap<String, Object>();
        vo.put("loginName", loginName);
        List<UserInfo> selectList = userInfoServiceImpl.selectList(vo);
        if (selectList != null && selectList.size() > 0) {
            res.put("code", "-1");
            res.put("message", "账户名已被注册！");
            return JSON.toJSONString(res);
        }
        try {

            Date createDate = new Date();
            userInfo.setLoginName(loginName);
            userInfo.setUserType(F.UserType.admin);
            userInfo.setZt(F.UserStatus.enable);
            String userId = StringUtils.createDateRandomString(createDate);
            userInfo.setUserId(userId);
            userInfo.setCzsj(createDate);
            String password = MD5Utils.MD5(F.UserPwd.defaultPwd, "utf-8");
            userInfo.setPassword(password);
            userInfo.setCzr(Auth.getAuth(request).getUserId());
            res.put("lockData", "用户ID：" + userId + ",用户姓名：" + userInfo.getUserName());
            this.userInfoServiceImpl.add(userInfo);
        } catch (Exception e) {
            res.put("code", "-1");
            res.put("message", "操作失败");
            e.printStackTrace();
        }
        return JSON.toJSONString(res);
    }

    @RequestMapping(value = {"updateUserInfo.action", "/"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Object updateUserInfo(UserInfo userInfo) {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("code", "0");
        res.put("message", "修改成功");
        try {
            if (!userInfo.getPassword().equals(F.UserPwd.defaultPwd)){//更改
                userInfo.setPassword(MD5Utils.MD5(userInfo.getPassword(), "utf-8"));
            }else{//未修改
                userInfo.setPassword(null);
            }
            userInfo.setCzsj(new Date());
            res.put("lockData", "用户ID：" + userInfo.getUserId() + ",用户姓名：" + userInfo.getUserName());
            this.userInfoServiceImpl.edit(userInfo);
        } catch (Exception e) {
            res.put("code", "-1");
            res.put("message", "修改失败");
            e.printStackTrace();
        }
        return JSON.toJSONString(res);
    }

    @RequestMapping(value = {"delUserInfo.action", "/"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Object delUserInfo(@RequestParam Map<String, Object> form) {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("code", "0");
        res.put("message", "删除成功");
        String userId = (String) form.get("userId");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setZt(F.UserStatus.cancel);
        userInfo.setCzsj(new Date());
        UserInfo userInfo2 = this.userInfoServiceImpl.selectById(userId);
        res.put("lockData", "用户ID：" + userId + ",用户姓名：" + userInfo2.getUserName());
        log.info("删除用户：userId=" + userId);
        try {
            this.userInfoServiceImpl.edit(userInfo);
        } catch (Exception e) {
            res.put("code", "-1");
            res.put("message", "删除失败");
            e.printStackTrace();
        }
        return JSON.toJSONString(res);
    }

    @RequestMapping(value = {"changePassword.action", "/"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Object changePassword(HttpServletRequest request, @RequestParam Map<String, Object> form) {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("code", "0");
        res.put("message", "修改成功");
        String oldPassword = (String) form.get("oldPassword");
        String newPassword = (String) form.get("newPassword");
        String comPassword = (String) form.get("comPassword");
        if (!newPassword.equals(comPassword)) {
            res.put("code", "-1");
            res.put("message", "确认密码不一致");
            return JSON.toJSONString(res);
        }
        String encPassword = MD5Utils.MD5(oldPassword, "UTF-8");
        String userId = Auth.getAuth(request).getUserId();
        UserInfo userInfo2 = this.userInfoServiceImpl.selectById(userId);
        res.put("lockData", "用户ID：" + userId + ",用户姓名：" + userInfo2.getUserName());
        boolean check = userInfoServiceImpl.checkUserPassword(userId, encPassword);
        if (!check) {
            res.put("code", "-1");
            res.put("message", "原密码错误");
            return JSON.toJSONString(res);
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setPassword(MD5Utils.MD5(newPassword, "UTF-8"));
        userInfo.setCzsj(new Date());
        try {
            this.userInfoServiceImpl.edit(userInfo);
        } catch (Exception e) {
            res.put("code", "-1");
            res.put("message", "修改密码失败");
            log.error(e.getMessage());
        }

        return JSON.toJSONString(res);
    }

    /***
     * 下载用户
     * @return
     */
    @GetMapping("getUsers")
    public String getUsers() {
        Map<String, Object>  param = new HashMap<>();
        List<UserInfo> users = userInfoServiceImpl.selectList(param);
        return JSONUtil.toJsonStr(users);
    }
}