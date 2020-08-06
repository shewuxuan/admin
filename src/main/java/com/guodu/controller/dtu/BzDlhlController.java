package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guodu.pojo.dtu.BzCyjd;
import com.guodu.pojo.dtu.BzDlhl;
import com.guodu.pojo.sys.Auth;
import com.guodu.service.dtu.BzDlhlService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzDlhlController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:39 下午
 */
@RestController
@RequestMapping("bzdlhl/")
public class BzDlhlController {

    @Autowired
    private BzDlhlService bzDlhlServiceImpl;

    @RequestMapping("insert")
    public int insert(BzDlhl bzDlhl) {
        bzDlhl.setId(IDUtil.getStrId());
        try {
            int i = bzDlhlServiceImpl.insert(bzDlhl);
            StaticLog.info("bz_dlhl表【插入】成功 -----> " + bzDlhl.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_dlhl表【插入】失败 -----> " + bzDlhl.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {
        try {
            int i = bzDlhlServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_dlhl表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_dlhl表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzDlhl bzDlhl) {
        try {
            bzDlhl.setId(id);
            int i = bzDlhlServiceImpl.updateByPrimaryKey(bzDlhl);
            StaticLog.info("bz_dlhl表【修改】成功 -----> " + bzDlhl.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_dlhl表【删除】失败 -----> " + bzDlhl.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzDlhl bzDlhl = bzDlhlServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzDlhl);
    }


    @RequestMapping("selectByAll")
    public String selectByAll(BzDlhl bzDlhl) {
        List<BzDlhl> bzDlhls = bzDlhlServiceImpl.selectByAll(bzDlhl);
        return JSONUtil.toJsonStr(bzDlhls);
    }

    @GetMapping("selectByPage")
    public String selectByAll(HttpServletRequest request,BzDlhl record,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        // pagehelper分页
        if (record.getSsqy() == null || record.getSsqy().equals("0")){
            Auth auth = Auth.getAuth(request);
            record.setSsqy(auth.getZwSsqy());
        }
        PageHelper.startPage(page, rows);
        List<BzDlhl> list = bzDlhlServiceImpl.selectByPage(record);
        PageInfo<BzDlhl> pageInfo = new PageInfo<>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(map);
    }
}
