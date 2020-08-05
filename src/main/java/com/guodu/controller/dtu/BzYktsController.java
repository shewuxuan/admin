package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.dtu.BzYkts;
import com.guodu.pojo.sys.Auth;
import com.guodu.service.dtu.BzYktsService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzYktsController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:39 下午
 */
@RestController
@RequestMapping("bzykts/")
public class BzYktsController {

    @Autowired
    private BzYktsService bzYktsServiceImpl;

    @RequestMapping("insert")
    public int insert(BzYkts bzYkts) {
        bzYkts.setId(IDUtil.getStrId());
        try {
            int i = bzYktsServiceImpl.insert(bzYkts);
            StaticLog.info("bz_ykts表【插入】成功 -----> " + bzYkts.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_ykts表【插入】失败 -----> " + bzYkts.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {
        try {
            int i = bzYktsServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_ykts表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_ykts表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzYkts bzYkts) {
        try {
            bzYkts.setId(id);
            int i = bzYktsServiceImpl.updateByPrimaryKey(bzYkts);
            StaticLog.info("bz_ykts表【修改】成功 -----> " + bzYkts.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_ykts表【修改】失败 -----> " + bzYkts.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzYkts bzYkts = bzYktsServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzYkts);
    }


    @RequestMapping("selectByAll")
    public String selectByAll(BzYkts bzYkts) {
        List<BzYkts> bzYktss = bzYktsServiceImpl.selectByAll(bzYkts);
        return JSONUtil.toJsonStr(bzYktss);
    }

    @GetMapping("selectByPage")
    public String selectByAll(HttpServletRequest request,BzYkts bzYkts,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("bzYkts", bzYkts);
        map.put("page", page);
        map.put("rows", rows);
        if (bzYkts.getSsqy() == null || bzYkts.getSsqy().equals("0")){
            Auth auth = Auth.getAuth(request);
            map.put("ssqy",auth.getZwSsqy());
        }
        return bzYktsServiceImpl.selectByPage(map);
    }
}
