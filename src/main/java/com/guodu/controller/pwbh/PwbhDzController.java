package com.guodu.controller.pwbh;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.pwbh.PwbhDz;
import com.guodu.service.pwbh.PwbhDzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DzController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:00 下午
 */
@RestController
@RequestMapping("pwbh_dz/")
public class PwbhDzController {

    @Autowired
    private PwbhDzService serviceImpl;

    private final Map<String, Object> map = new HashMap<>(16);

    @RequestMapping("insert")
    public String insert(@RequestBody PwbhDz record, HttpServletRequest request) {
        map.clear();
        try {
            int i = serviceImpl.insert(record);
            map.put("code", 0);
            map.put("msg", "添加成功！");
            map.put("data", i);
            StaticLog.info("pwbh_dz表【插入】成功 -----> " + record.getTsid(), "INFO");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "添加失败！");
            map.put("data", 0);
            StaticLog.error(e, "pwbh_dz表【插入】失败 -----> " + record.getTsid(), "ERROR");
        }
        return JSONUtil.toJsonStr(map);
    }

    @GetMapping("selectByPrimaryKey/{tsid}")
    public String selectByPrimaryKey(@PathVariable String tsid) {
        map.clear();
        try {
            PwbhDz pwbhDz = serviceImpl.selectByPrimaryKey(tsid);
            map.put("code", 0);
            map.put("msg", "查询完成");
            map.put("data", pwbhDz);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "查询异常");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("selectByAll")
    public String selectByAll(PwbhDz jlDzdjc) {
        map.clear();
        try {
            List<PwbhDz> jlDzdjcs = serviceImpl.selectByAll(jlDzdjc);
            map.put("code", 0);
            map.put("msg", "查询完成");
            map.put("data", jlDzdjcs);
            map.put("rows", jlDzdjcs);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "查询异常");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("updateByPrimaryKey")
    public String updateByPrimaryKey(@RequestBody PwbhDz record) {
        map.clear();
        try {
            serviceImpl.updateByPrimaryKeySelective(record);
            map.put("code", 0);
            map.put("msg", "提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "提交失败！");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public String deleteByPrimaryKey(@PathVariable String id) {
        map.clear();
        try {
            serviceImpl.deleteByPrimaryKey(id);
            map.put("code", 0);
            map.put("msg", "删除成功");
            StaticLog.info("pwbh_dz表【删除】成功 -----> " + id, "INFO");
        } catch (Exception e) {
            StaticLog.error(e, "pwbh_dz表【删除】失败 -----> " + id, "ERROR");
            map.put("code", -1);
            map.put("msg", "删除失败！");
        }
        return JSONUtil.toJsonStr(map);
    }
}
