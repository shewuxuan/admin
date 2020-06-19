package com.guodu.pojo.sys;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String userName;
    private String loginName;
    private String password;
    private String userType;
    private String roleId;
    private String phone;
    private String email;
    private String zw;
    private String zt;
    private String czr;
    private Date czsj;
    private String beizhu;
}
