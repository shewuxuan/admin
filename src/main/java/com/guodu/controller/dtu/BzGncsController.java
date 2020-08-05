package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.dtu.BzGncs;
import com.guodu.pojo.sys.Auth;
import com.guodu.service.dtu.BzGncsService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzGncsController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:39 下午
 */
@RestController
@RequestMapping("bzgncs/")
public class BzGncsController {

    @Autowired
    private BzGncsService bzGncsServiceImpl;

    @RequestMapping("insert")
    public int insert(BzGncs bzGncs) {
        bzGncs.setId(IDUtil.getStrId());
        try {
            int i = bzGncsServiceImpl.insert(bzGncs);
            StaticLog.info("bz_gncs表【插入】成功 -----> " + bzGncs.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_gncs表【插入】失败 -----> " + bzGncs.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {
        try {
            int i = bzGncsServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_gncs表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_gncs表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzGncs bzGncs) {
        try {
            bzGncs.setId(id);
            int i = bzGncsServiceImpl.updateByPrimaryKey(bzGncs);
            StaticLog.info("bz_gncs表【修改】成功 -----> " + bzGncs.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_gncs表【修改】失败 -----> " + bzGncs.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzGncs bzGncs = bzGncsServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzGncs);
    }


    @RequestMapping("selectByAll")
    public String selectByAll(BzGncs bzGncs) {
        List<BzGncs> bzGncss = bzGncsServiceImpl.selectByAll(bzGncs);
        return JSONUtil.toJsonStr(bzGncss);
    }

    @GetMapping("selectByPage")
    public String selectByAll(HttpServletRequest request,BzGncs bzGncs,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("bzGncs", bzGncs);
        map.put("page", page);
        map.put("rows", rows);
        if (bzGncs.getSsqy() == null || bzGncs.getSsqy().equals("0")){
            Auth auth = Auth.getAuth(request);
            map.put("ssqy",auth.getZwSsqy());
        }
        return bzGncsServiceImpl.selectByPage(map);
    }
}
