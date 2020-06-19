package com.guodu.service.impl.sys;

import com.guodu.mapper.sys.UserInfoMapper;
import com.guodu.pojo.sys.UserInfo;
import com.guodu.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo queryUserByNamePassword(Map<String, Object> map) {
        List<UserInfo> userInfo = this.userInfoMapper.selectList(map);
        if (userInfo != null && userInfo.size() == 1) {
            return userInfo.get(0);
        }
        return null;
    }

    public Map<String, Object> getComboTreeData(String roleId) {
        List<Map<String, Object>> funcList = this.userInfoMapper.getComboTreeData(roleId);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        for (Map<String, Object> func : funcList) {
            resultMap.put(func.get("FUNCCODE").toString(), func.get("AUTHVALUE"));
        }
        return resultMap;
    }

    public boolean checkUserPassword(String userId, String oldPassword) {
        boolean check = false;
        UserInfo userInfo = this.userInfoMapper.selectById(userId);
        if (userInfo.getPassword().equals(oldPassword)) {
            check = true;
        }
        return check;
    }

    public List<Map<String, Object>> queryListAll() throws Exception {
        return this.selectListAll();
    }
}
