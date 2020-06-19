package com.guodu.controller.pwbh;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guodu.pojo.pwbh.PwbhBzLpjy;
import com.guodu.service.pwbh.PwbhBzLpjyService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: PwbhBzLpjyController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/9 1:50 下午
 */
@RestController
@RequestMapping("pwbh_bz_lpjy/")
public class PwbhBzLpjyController {

    @Autowired
    private PwbhBzLpjyService serviceImpl;
    private final Map<String, Object> map = new HashMap<>(16);

    @RequestMapping("insert")
    public String insert(@RequestBody PwbhBzLpjy record) {
        map.clear();
        try {
            record.setId(IDUtil.getStrId());
            int i = serviceImpl.insert(record);
            map.put("code", 0);
            map.put("msg", "添加成功！");
            map.put("data", i);
            StaticLog.info("pwbh_bz_lpjy表【插入】成功 -----> " + record.getId(), "INFO");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "添加失败！");
            StaticLog.error(e, "pwbh_bz_lpjy表【插入】失败 -----> " + record.getId(), "ERROR");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public String deleteByPrimaryKey(@PathVariable String id) {
        map.clear();
        try {
            int i = serviceImpl.deleteByPrimaryKey(id);
            map.put("code", 0);
            map.put("msg", "删除成功！");
            map.put("data", i);
            StaticLog.info("pwbh_bz_lpjy表【删除】成功 -----> " + id, "INFO");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "删除失败！");
            StaticLog.error(e, "pwbh_bz_lpjy表【删除】失败 -----> " + id, "ERROR");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("updateByPrimaryKey")
    public String updateByPrimaryKey(@RequestBody PwbhBzLpjy record) {
        map.clear();
        try {
            record.setId(record.getId());
            int i = serviceImpl.updateByPrimaryKey(record);
            map.put("code", 0);
            map.put("msg", "修改成功！");
            map.put("data", i);
            StaticLog.info("pwbh_bz_lpjy表【修改】成功 -----> " + record.getId(), "INFO");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "修改失败！");
            StaticLog.error(e, "pwbh_bz_lpjy表【修改】失败 -----> " + record.getId(), "ERROR");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        map.clear();
        try {
            PwbhBzLpjy record = serviceImpl.selectByPrimaryKey(id);
            map.put("code", 0);
            map.put("msg", "查询成功！");
            map.put("data", record);
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "查询异常！");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("selectByAll")
    public String selectByAll(PwbhBzLpjy record) {
        List<PwbhBzLpjy> list = serviceImpl.selectByAll(record);
        return JSONUtil.toJsonStr(list);
    }

    @GetMapping("selectByPage")
    public String selectByAll(PwbhBzLpjy record,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        map.clear();
        // pagehelper分页
        PageHelper.startPage(page, rows);
        List<PwbhBzLpjy> list = serviceImpl.selectByPage(record);

        PageInfo<PwbhBzLpjy> pageInfo = new PageInfo<>(list);

        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(map);
    }
}
