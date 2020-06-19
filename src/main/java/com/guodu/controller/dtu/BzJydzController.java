package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.dtu.BzJydz;
import com.guodu.service.dtu.BzJydzService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzJydzController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:39 下午
 */
@RestController
@RequestMapping("bzjydz/")
public class BzJydzController {

    @Autowired
    private BzJydzService bzJydzServiceImpl;

    @RequestMapping("insert")
    public int insert(BzJydz bzJydz) {
        bzJydz.setId(IDUtil.getStrId());
        try {
            int i = bzJydzServiceImpl.insert(bzJydz);
            StaticLog.info("bz_jydz表【插入】成功 -----> " + bzJydz.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_jydz表【插入】失败 -----> " + bzJydz.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {
        try {
            int i = bzJydzServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_jydz表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_jydz表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzJydz bzJydz) {
        try {
            bzJydz.setId(id);
            int i = bzJydzServiceImpl.updateByPrimaryKey(bzJydz);
            StaticLog.info("bz_jydz表【修改】成功 -----> " + bzJydz.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_jydz表【修改】失败 -----> " + bzJydz.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzJydz bzJydz = bzJydzServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzJydz);
    }

    @RequestMapping("selectByAll")
    public String selectByAll(BzJydz bzJydz) {
        List<BzJydz> bzJydzs = bzJydzServiceImpl.selectByAll(bzJydz);
        return JSONUtil.toJsonStr(bzJydzs);
    }

    @GetMapping("selectByPage")
    public String selectByAll(BzJydz bzJydz,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("bzJydz", bzJydz);
        map.put("page", page);
        map.put("rows", rows);
        return bzJydzServiceImpl.selectByPage(map);
    }

}
