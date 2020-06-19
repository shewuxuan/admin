package com.guodu.util;

public final class F {

    public static final String NAMESPACE_DANCE = "com.guodu.util";
    /**
     * 用户类型
     *  0	超级管理员
     *	1	管理员
     */
    public interface UserType  {
        String superAdmin = "0";
        String admin	= "1";
    }

    /**
     * 用户状态
     *  0	启用
     *  1	注销
     *  2	禁用
     */
    public interface UserStatus  {
        String enable ="0";
        String cancel ="1";
        String forbid ="2";
    }

    /**
     * 用户默认密码
     */
    public interface UserPwd  {
        String defaultPwd = "888888";
    }

    /**
     * keyccode字典代码
     */
    public interface SysKey  {
        String region = "region";//所属区域
        String zzType = "zz_type";//装置类型
    }
}
