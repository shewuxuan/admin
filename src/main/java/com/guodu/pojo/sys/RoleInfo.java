package com.guodu.pojo.sys;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RoleInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String roleId;//角色ID
    private String roleName;//角色名称
    private String beizhu;//备注
    private String czr;//操作人
    private Date czsj;//修改时间
}
