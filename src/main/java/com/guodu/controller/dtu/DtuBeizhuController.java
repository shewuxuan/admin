package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import com.guodu.pojo.dtu.JbxxBeizhu;
import com.guodu.service.dtu.JbxxBeizhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DtuBeizhuController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/7/28 4:14 下午
 */
@RequestMapping("beizhu/")
public class DtuBeizhuController {

    @Autowired
    private JbxxBeizhuService jbxxBeizhuServiceImpl;

    private Map<String, Object> map = new HashMap<>(16);

    @GetMapping("selectBeizhuByPrimaryKey/{tsid}")
    public String selectBeizhuByPrimaryKey(@PathVariable String tsid) {
        JbxxBeizhu jbxxBeizhu = jbxxBeizhuServiceImpl.selectByPrimaryKey(tsid);
        return JSONUtil.toJsonStr(jbxxBeizhu);
    }

    @PostMapping("updateByPrimaryKey")
    public String updateByPrimaryKey(@RequestBody JbxxBeizhu record) {
        try {
            int i = jbxxBeizhuServiceImpl.updateByPrimaryKeySelective(record);
            map.put("code", 1);
            map.put("msg", "修改成功！");
            map.put("data", i);
        } catch (Exception e) {
            map.put("code", 0);
            map.put("msg", "修改失败！");
        }
        return JSONUtil.toJsonStr(map);
    }

}
