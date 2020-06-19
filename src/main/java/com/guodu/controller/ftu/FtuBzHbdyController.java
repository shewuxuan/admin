package com.guodu.controller.ftu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guodu.pojo.ftu.FtuBzHbdy;
import com.guodu.service.ftu.FtuBzHbdyService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: FtuBzCyjdController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/9 1:50 下午
 */
@RestController
@RequestMapping("ftu_bz_hbdy/")
public class FtuBzHbdyController {

    @Autowired
    private FtuBzHbdyService serviceImpl;
    private Map<String, Object> map = new HashMap<>(16);

    @RequestMapping("insert")
    public String insert(@RequestBody FtuBzHbdy record) {
        map.clear();
        try {
            record.setId(IDUtil.getStrId());
            int i = serviceImpl.insert(record);
            map.put("code", 0);
            map.put("msg", "添加成功！");
            map.put("data", i);
            StaticLog.info("ftu_bz_hbdy表【插入】成功 -----> " + record.getId(), "INFO");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "添加失败！");
            StaticLog.error(e, "ftu_bz_hbdy表【插入】失败 -----> " + record.getId(), "ERROR");
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
            StaticLog.info("ftu_bz_hbdy表【删除】成功 -----> " + id, "INFO");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "删除失败！");
            StaticLog.error(e, "ftu_bz_hbdy表【删除】失败 -----> " + id, "ERROR");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("updateByPrimaryKey")
    public String updateByPrimaryKey(@RequestBody FtuBzHbdy record) {
        map.clear();
        try {
            record.setId(record.getId());
            int i = serviceImpl.updateByPrimaryKey(record);
            map.put("code", 0);
            map.put("msg", "修改成功！");
            map.put("data", i);
            StaticLog.info("ftu_bz_hbdy表【修改】成功 -----> " + record.getId(), "INFO");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "修改失败！");
            StaticLog.error(e, "ftu_bz_hbdy表【修改】失败 -----> " + record.getId(), "ERROR");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        map.clear();
        try {
            FtuBzHbdy record = serviceImpl.selectByPrimaryKey(id);
            map.put("code", 0);
            map.put("msg", "查询成功！");
            map.put("data", record);
        } catch (Exception e) {
            map.put("code", 0);
            map.put("msg", "查询异常！");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("selectByAll")
    public String selectByAll(FtuBzHbdy record) {
        List<FtuBzHbdy> list = serviceImpl.selectByAll(record);
        return JSONUtil.toJsonStr(list);
    }

    @GetMapping("selectByPage")
    public String selectByAll(FtuBzHbdy record,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        map.clear();
        // pagehelper分页
        PageHelper.startPage(page, rows);
        List<FtuBzHbdy> list = serviceImpl.selectByPage(record);

        PageInfo<FtuBzHbdy> pageInfo = new PageInfo<>(list);

        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(map);
    }
}
