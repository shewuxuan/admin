package com.guodu.controller.pwbh;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.pwbh.PwbhJbxxBeizhu;
import com.guodu.service.pwbh.PwbhJbxxBeizhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("pwbh_beizhu/")
@RestController
public class PwbhBeizhuController {

    @Autowired
    private PwbhJbxxBeizhuService pwbhJbxxBeizhuServiceImpl;
    private final Map<String, Object> map = new HashMap<>(16);

    @GetMapping("selectByPrimaryKey/{tsid}")
    public String selectBeizhuByPrimaryKey(@PathVariable String tsid) {
        PwbhJbxxBeizhu pwbhJbxxBeizhu = pwbhJbxxBeizhuServiceImpl.selectByPrimaryKey(tsid);
        return JSONUtil.toJsonStr(pwbhJbxxBeizhu);
    }

    @RequestMapping("updateByPrimaryKey")
    public String updateByPrimaryKeySelective(@RequestBody PwbhJbxxBeizhu record) {
        map.clear();
        try {
            pwbhJbxxBeizhuServiceImpl.updateByPrimaryKeySelective(record);
            map.put("code", 0);
            map.put("msg", "备注修改成功");
        } catch (Exception e) {
            StaticLog.error("");
            map.put("code", -1);
            map.put("msg", "备注修改失败");
        }
        return JSONUtil.toJsonStr(map);
    }
}
