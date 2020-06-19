package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.dtu.BzGjcs;
import com.guodu.service.dtu.BzGjcsService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzGjcsController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:39 下午
 */
@RestController
@RequestMapping("bzgjcs/")
public class BzGjcsController {

    @Autowired
    private BzGjcsService bzGjcsServiceImpl;

    @RequestMapping("insert")
    public int insert(BzGjcs bzGjcs) {
        bzGjcs.setId(IDUtil.getStrId());
        try {
            int i = bzGjcsServiceImpl.insert(bzGjcs);
            StaticLog.info("bz_gjcs表【插入】成功 -----> " + bzGjcs.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_gjcs表【插入】失败 -----> " + bzGjcs.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {

        try {
            int i = bzGjcsServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_gjcs表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_gjcs表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }

    }

    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzGjcs bzGjcs) {

        try {
            bzGjcs.setId(id);
            int i = bzGjcsServiceImpl.updateByPrimaryKey(bzGjcs);
            StaticLog.info("bz_gjcs表【修改】成功 -----> " + bzGjcs.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_gjcs表【修改】失败 -----> " + bzGjcs.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzGjcs bzGjcs = bzGjcsServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzGjcs);
    }


    @RequestMapping("selectByAll")
    public String selectByAll(BzGjcs bzGjcs) {
        List<BzGjcs> bzGjcss = bzGjcsServiceImpl.selectByAll(bzGjcs);
        return JSONUtil.toJsonStr(bzGjcss);
    }

    @GetMapping("selectByPage")
    public String selectByAll(BzGjcs bzGjcs,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("bzGjcs", bzGjcs);
        map.put("page", page);
        map.put("rows", rows);
        return bzGjcsServiceImpl.selectByPage(map);
    }
}
