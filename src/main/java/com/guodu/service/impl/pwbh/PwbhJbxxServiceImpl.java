package com.guodu.service.impl.pwbh;

import cn.hutool.json.JSONUtil;
import com.guodu.mapper.pwbh.PwbhJbxxMapper;
import com.guodu.pojo.pwbh.*;
import com.guodu.service.impl.BaseServiceImpl;
import com.guodu.service.pwbh.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PwbhJbxxServiceImpl extends BaseServiceImpl<PwbhJbxx> {
    /**单一实现类直接继承BaseServiceImpl，调用父类共有方法，不需要单独写接口**/
    @Autowired
    private PwbhJbxxMapper pwbhJbxxMapper;

    /**  查询配网保护相关标准 **/
    @Autowired
    PwbhBzBhctService pwbhBzBhctServiceImpl;
    @Autowired
    PwbhBzDzjcService pwbhBzDzjcServiceImpl;
    @Autowired
    PwbhBzJdjyService pwbhBzJdjyServiceImpl;
    @Autowired
    PwbhBzJxdxService pwbhBzJxdxServiceImpl;
    @Autowired
    PwbhBzJycsService pwbhBzJycsServiceImpl;
    @Autowired
    PwbhBzLpjyService pwbhBzLpjyServiceImpl;
    @Autowired
    PwbhBzSgjcService pwbhBzSgjcServiceImpl;
    @Autowired
    PwbhBzWgjcService pwbhBzWgjcServiceImpl;
    @Autowired
    PwbhBzYqybService pwbhBzYqybServiceImpl;

    public Object getPwbh(){
        Map<String,String> result = new HashMap<>();
        List<PwbhBzBhct> pwbhBzBhct = pwbhBzBhctServiceImpl.selectByAll(null);
        List<PwbhBzDzjc> pwbhBzDzjc = pwbhBzDzjcServiceImpl.selectByAll(null);
        List<PwbhBzJdjy> pwbhBzJdjy = pwbhBzJdjyServiceImpl.selectByAll(null);
        List<PwbhBzJxdx> pwbhBzJxdx = pwbhBzJxdxServiceImpl.selectByAll(null);
        List<PwbhBzJycs> pwbhBzJycs = pwbhBzJycsServiceImpl.selectByAll(null);
        List<PwbhBzLpjy> pwbhBzLpjy = pwbhBzLpjyServiceImpl.selectByAll(null);
        List<PwbhBzSgjc> pwbhBzSgjc = pwbhBzSgjcServiceImpl.selectByAll(null);
        List<PwbhBzWgjc> pwbhBzWgjc = pwbhBzWgjcServiceImpl.selectByAll(null);
        List<PwbhBzYqyb> pwbhBzYqyb = pwbhBzYqybServiceImpl.selectByAll(null);

        result.put("bzBhct", JSONUtil.toJsonStr(pwbhBzBhct));
        result.put("bzDzjc", JSONUtil.toJsonStr(pwbhBzDzjc));
        result.put("bzJdjy", JSONUtil.toJsonStr(pwbhBzJdjy));
        result.put("bzJxdx", JSONUtil.toJsonStr(pwbhBzJxdx));
        result.put("bzJycs", JSONUtil.toJsonStr(pwbhBzJycs));
        result.put("bzLpjy", JSONUtil.toJsonStr(pwbhBzLpjy));
        result.put("bzSgjc", JSONUtil.toJsonStr(pwbhBzSgjc));
        result.put("bzWgjc", JSONUtil.toJsonStr(pwbhBzWgjc));
        result.put("bzYqyb", JSONUtil.toJsonStr(pwbhBzYqyb));

        return result;
    }
}
