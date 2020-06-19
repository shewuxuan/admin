package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.dtu.BzYcts;
import com.guodu.service.dtu.BzYctsService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzYctsController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:39 下午
 */
@RestController
@RequestMapping("bzycts/")
public class BzYctsController {

    @Autowired
    private BzYctsService bzYctsServiceImpl;

    @RequestMapping("insert")
    public int insert(BzYcts bzYcts) {
        bzYcts.setId(IDUtil.getStrId());
        try {
            int i = bzYctsServiceImpl.insert(bzYcts);
            StaticLog.info("bz_ycts表【插入】成功 -----> " + bzYcts.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_ycts表【插入】失败 -----> " + bzYcts.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {
        try {
            int i = bzYctsServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_ycts表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_ycts表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzYcts bzYcts) {
        try {
            bzYcts.setId(id);
            int i = bzYctsServiceImpl.updateByPrimaryKey(bzYcts);
            StaticLog.info("bz_ycts表【修改】成功 -----> " + bzYcts.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_ycts表【修改】失败 -----> " + bzYcts.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzYcts bzYcts = bzYctsServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzYcts);
    }


    @RequestMapping("selectByAll")
    public String selectByAll(BzYcts bzYcts) {
        List<BzYcts> bzYctss = bzYctsServiceImpl.selectByAll(bzYcts);
        return JSONUtil.toJsonStr(bzYctss);
    }

    @GetMapping("selectByPage")
    public String selectByAll(BzYcts bzYcts,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("bzYcts", bzYcts);
        map.put("page", page);
        map.put("rows", rows);
        return bzYctsServiceImpl.selectByPage(map);
    }
}
