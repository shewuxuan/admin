package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.dtu.BzDyxn;
import com.guodu.service.dtu.BzDyxnService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzDyxnController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 1:20 下午
 */
@RestController
@RequestMapping("bzdyxn/")
public class BzDyxnController {

    @Autowired
    private BzDyxnService bzDyxnServiceImpl;

    @RequestMapping("insert")
    public int insert(BzDyxn bzDyxn) {
        bzDyxn.setId(IDUtil.getStrId());
        try {
            int i = bzDyxnServiceImpl.insert(bzDyxn);
            StaticLog.info("bz_dyxn表【插入】成功 -----> " + bzDyxn.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_dyxn表【插入】失败 -----> " + bzDyxn.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {
        try {
            int i = bzDyxnServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_dyxn表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_dyxn表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzDyxn bzDyxn) {
        try {
            bzDyxn.setId(id);
            int i = bzDyxnServiceImpl.updateByPrimaryKey(bzDyxn);
            StaticLog.info("bz_dyxn表【修改】成功 -----> " + bzDyxn.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_dyxn表【修改】失败 -----> " + bzDyxn.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzDyxn bzDyxn = bzDyxnServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzDyxn);
    }

    @RequestMapping("selectByAll")
    public String selectByAll(BzDyxn bzDyxn) {
        List<BzDyxn> bzDyxns = bzDyxnServiceImpl.selectByAll(bzDyxn);
        return JSONUtil.toJsonStr(bzDyxns);
    }

    @GetMapping("selectByPage")
    public String selectByAll(BzDyxn bzDyxn,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("bzDyxn", bzDyxn);
        map.put("page", page);
        map.put("rows", rows);
        return bzDyxnServiceImpl.selectByPage(map);
    }
}
