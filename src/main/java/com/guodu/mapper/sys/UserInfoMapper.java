package com.guodu.mapper.sys;

import com.guodu.mapper.BaseMapper;
import com.guodu.pojo.sys.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    List<Map<String, Object>> getComboTreeData(String roleId);
}
