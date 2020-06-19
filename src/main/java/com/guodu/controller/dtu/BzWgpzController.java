package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.dtu.BzWgpz;
import com.guodu.service.dtu.BzWgpzService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzWgpzController
 * @Description: TODO DTU外观配置
 * @Author: 2Uli
 * @Date: 2020/1/19 12:39 下午
 */
@RestController
@RequestMapping("bzwgpz/")
public class BzWgpzController {

    @Autowired
    private BzWgpzService bzWgpzServiceImpl;

    @RequestMapping("insert")
    public int insert(BzWgpz bzWgpz) {
        bzWgpz.setId(IDUtil.getStrId());
        try {
            int i = bzWgpzServiceImpl.insert(bzWgpz);
            StaticLog.info("bz_wgpz表【插入】成功 -----> " + bzWgpz.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_wgpz表【插入】失败 -----> " + bzWgpz.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {
        try {
            int i = bzWgpzServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_wgpz表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_wgpz表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzWgpz bzWgpz) {
        try {
            bzWgpz.setId(id);
            int i = bzWgpzServiceImpl.updateByPrimaryKey(bzWgpz);
            StaticLog.info("bz_wgpz表【修改】成功 -----> " + bzWgpz.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_wgpz表【修改】失败 -----> " + bzWgpz.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzWgpz bzWgpz = bzWgpzServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzWgpz);
    }

    @RequestMapping("selectByAll")
    public String selectByAll(BzWgpz bzWgpz) {
        List<BzWgpz> bzWgpzs = bzWgpzServiceImpl.selectByAll(bzWgpz);
        return JSONUtil.toJsonStr(bzWgpzs);
    }

    @GetMapping("selectByPage")
    public String selectByAll(BzWgpz bzWgpz,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("bzWgpz", bzWgpz);
        map.put("page", page);
        map.put("rows", rows);
        return bzWgpzServiceImpl.selectByPage(map);
    }

}
