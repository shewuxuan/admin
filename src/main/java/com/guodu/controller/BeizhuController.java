package com.guodu.controller;

import cn.hutool.json.JSONUtil;
import com.guodu.pojo.ftu.FtuJbxxBeizhu;
import com.guodu.pojo.dtu.JbxxBeizhu;
import com.guodu.service.ftu.FtuJbxxBeizhuService;
import com.guodu.service.dtu.JbxxBeizhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: JbxxBeizhuController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/29 12:33 下午
 */
@RequestMapping("beizhu/")
@RestController
public class BeizhuController {

    @Autowired
    private JbxxBeizhuService jbxxBeizhuServiceImpl;
    @Autowired
    private FtuJbxxBeizhuService ftuJbxxBeizhuServiceImpl;
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

    /**
     * @MethodName: selectFtuBeizhuByPrimaryKey
     * @Description: TODO 查询FTU备注
     * @Param: [tsid]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/5/13 11:28 上午
     */
    @GetMapping("selectFtuBeizhuByPrimaryKey/{tsid}")
    public String selectFtuBeizhuByPrimaryKey(@PathVariable String tsid) {
        FtuJbxxBeizhu ftuBeizhu = ftuJbxxBeizhuServiceImpl.selectByPrimaryKey(tsid);
        return JSONUtil.toJsonStr(ftuBeizhu);
    }


    /**
     * @MethodName: updateFtuBeizhuByPrimaryKey
     * @Description: TODO 修改FTU备注
     * @Param: [record]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/5/13 11:29 上午
     */
    @PostMapping("updateFtuBeizhuByPrimaryKey")
    public String updateFtuBeizhuByPrimaryKey(@RequestBody FtuJbxxBeizhu record) {
        try {
            int i = ftuJbxxBeizhuServiceImpl.updateByPrimaryKeySelective(record);
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
