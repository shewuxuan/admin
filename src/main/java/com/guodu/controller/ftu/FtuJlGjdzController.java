package com.guodu.controller.ftu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.ftu.FtuJlGjdz;
import com.guodu.service.ftu.FtuJlGjdzService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: JlGjdzController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/20 1:17 下午
 */
@RestController
@RequestMapping("ftu_jl_gjdz/")
public class FtuJlGjdzController {

    @Autowired
    private FtuJlGjdzService jlGjdzServiceImpl;

    private final Map<String, Object> map = new HashMap<>(16);

    @RequestMapping("insert")
    public String insert(@RequestBody FtuJlGjdz record, HttpServletRequest request) {
        map.clear();
        try {
            record.setId(IDUtil.getStrId());
            int i = jlGjdzServiceImpl.insert(record);
            map.put("code", 0);
            map.put("msg", "添加成功！");
            map.put("data", i);
            StaticLog.info("ftu_jl_gjdz表【插入】成功 -----> " + record.getId(), "INFO");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "添加失败！");
            map.put("data", 0);
            StaticLog.error(e, "ftu_jl_gjdz表【插入】失败 -----> " + record.getId(), "ERROR");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("selectByAll")
    public String selectByAll(FtuJlGjdz jlGjdz) {
        map.clear();
        try {
            List<FtuJlGjdz> jlGjdzs = jlGjdzServiceImpl.selectByAll(jlGjdz);
            map.put("code", 0);
            map.put("msg", "查询完成");
            map.put("data", jlGjdzs);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "查询异常");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public String deleteByPrimaryKey(@PathVariable String id) {
        map.clear();
        try {
            jlGjdzServiceImpl.deleteByPrimaryKey(id);
            map.put("code", 0);
            map.put("msg", "删除成功");
            StaticLog.info("ftu_jl_gjdz表【删除】成功 -----> " + id, "INFO");
        } catch (Exception e) {
            StaticLog.error(e, "ftu_jl_gjdz表【删除】失败 -----> " + id, "ERROR");
            map.put("code", -1);
            map.put("msg", "删除失败！");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("updateByPrimaryKey")
    public String updateByPrimaryKey(@RequestBody FtuJlGjdz record) {
        map.clear();
        try {
            int i = jlGjdzServiceImpl.updateByPrimaryKey(record);
            map.put("code", 0);
            map.put("msg", "修改成功!");
            map.put("data", i);
            StaticLog.info("ftu_jl_gjdz表【修改】成功 -----> " + record.getId(), "INFO");
        } catch (Exception e) {
            StaticLog.error(e, "ftu_jl_gjdz表【修改】失败 -----> " + record.getId(), "ERROR");
            map.put("code", -1);
            map.put("msg", "修改失败！");
        }
        return JSONUtil.toJsonStr(map);
    }

    @GetMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        FtuJlGjdz ftuJlGjdz = jlGjdzServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(ftuJlGjdz);
    }
}
