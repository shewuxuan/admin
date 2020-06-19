package com.guodu.mapper.sys;

import java.util.List;
import java.util.Map;

import com.guodu.mapper.BaseMapper;
import com.guodu.pojo.sys.RoleInfo;

public interface RoleInfoMapper extends BaseMapper<RoleInfo> {
    List<Map<String, Object>> getRoleByFunc(String roleId);

    List<Map<String, Object>> getAllFunc();

    void addRoleFuncByRoleId(Map<String, Object> map);

    void updateRoleFuncByRoleId(Map<String, Object> map);

    void deleteFuncInfoByRoleId(String roleId);

	List<Map<String,Object>> queryAllRoleInfo();
}
