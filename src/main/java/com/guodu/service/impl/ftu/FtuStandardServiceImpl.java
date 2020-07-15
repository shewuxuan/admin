package com.guodu.service.impl.ftu;

import cn.hutool.json.JSONUtil;
import com.guodu.pojo.ftu.*;
import com.guodu.pojo.pwbh.*;
import com.guodu.service.pwbh.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: admin
 * @description: ftu所有标准下载
 * @author: she
 * @create: 2020-07-15 10:10
 */
@Service
public class FtuStandardServiceImpl {


    /***
     * 下载所有Ftu标准
     */
    @Autowired
    FtuBzCyjdcsServiceImpl ftuBzCyjdcsServiceImpl;
    @Autowired
    FtuBzCyjdServiceImpl ftuBzCyjdServiceImpl;
    @Autowired
    FtuBzGjtsServiceImpl ftuBzGjtsServiceImpl;
    @Autowired
    FtuBzGncsServiceImpl ftuBzGncsServiceImpl;
    @Autowired
    FtuBzHbdyServiceImpl ftuBzHbdyServiceImpl;
    @Autowired
    FtuBzLpjyServiceImpl ftuBzLpjyServiceImpl;
    @Autowired
    FtuBzTyjcServiceImpl ftuBzTyjcServiceImpl;
    @Autowired
    FtuBzTzybServiceImpl ftuBzTzybServiceImpl;
    public Object getAllStandard() {
        Map<String, String> result = new HashMap<>();

        List<FtuBzCyjdcs> bzCyjdcs = ftuBzCyjdcsServiceImpl.selectByAll(null);
        List<FtuBzCyjd> bzCyjd = ftuBzCyjdServiceImpl.selectByAll(null);
        List<FtuBzGjts> bzGjts = ftuBzGjtsServiceImpl.selectByAll(null);
        List<FtuBzGncs> bzGncs = ftuBzGncsServiceImpl.selectByAll(null);
        List<FtuBzHbdy> bzHbdy = ftuBzHbdyServiceImpl.selectByAll(null);
        List<FtuBzLpjy> bzLpjy = ftuBzLpjyServiceImpl.selectByAll(null);
        List<FtuBzTyjc> bzTyjc = ftuBzTyjcServiceImpl.selectByAll(null);
        List<FtuBzTzyb> bzTzyb = ftuBzTzybServiceImpl.selectByAll(null);

        result.put("bzCyjdcs", JSONUtil.toJsonStr(bzCyjdcs));
        result.put("bzCyjd", JSONUtil.toJsonStr(bzCyjd));
        result.put("bzGjts", JSONUtil.toJsonStr(bzGjts));
        result.put("bzGncs", JSONUtil.toJsonStr(bzGncs));
        result.put("bzHbdy", JSONUtil.toJsonStr(bzHbdy));
        result.put("bzLpjy", JSONUtil.toJsonStr(bzLpjy));
        result.put("bzTyjc", JSONUtil.toJsonStr(bzTyjc));
        result.put("bzTzyb", JSONUtil.toJsonStr(bzTzyb));
        return result;
    }
}
