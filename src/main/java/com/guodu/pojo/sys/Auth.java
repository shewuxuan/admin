package com.guodu.pojo.sys;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Auth {
    private String userType;
    private String userId;
    private String name;
    private String loginname;
    private String roleId;
    private Map<String, Object> roleFunc;

    static public Auth getAuth(HttpServletRequest request) {

        Auth auth = (Auth) request.getSession().getAttribute("auth");

        return auth;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Map<String, Object> getRoleFunc() {
        return roleFunc;
    }

    public void setRoleFunc(Map<String, Object> roleFunc) {
        this.roleFunc = roleFunc;
    }


}
