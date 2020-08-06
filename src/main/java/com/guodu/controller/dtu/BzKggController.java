package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guodu.pojo.dtu.BzHldz;
import com.guodu.pojo.dtu.BzKgg;
import com.guodu.pojo.sys.Auth;
import com.guodu.service.dtu.BzKggService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzKggController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:39 下午
 */
@RestController
@RequestMapping("bzkgg/")
public class BzKggController {

    @Autowired
    private BzKggService bzKggServiceImpl;

    @RequestMapping("insert")
    public int insert(BzKgg bzKgg) {
        bzKgg.setId(IDUtil.getStrId());
        try {
            int i = bzKggServiceImpl.insert(bzKgg);
            StaticLog.info("bz_kgg表【插入】成功 -----> " + bzKgg.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_kgg表【插入】失败 -----> " + bzKgg.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {
        try {
            int i = bzKggServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_kgg表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_kgg表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzKgg bzKgg) {
        try {
            bzKgg.setId(id);
            int i = bzKggServiceImpl.updateByPrimaryKey(bzKgg);
            StaticLog.info("bz_kgg表【修改】成功 -----> " + bzKgg.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_kgg表【修改】失败 -----> " + bzKgg.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzKgg bzKgg = bzKggServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzKgg);
    }


    @RequestMapping("selectByAll")
    public String selectByAll(BzKgg bzKgg) {
        List<BzKgg> bzKggs = bzKggServiceImpl.selectByAll(bzKgg);
        return JSONUtil.toJsonStr(bzKggs);
    }

    @GetMapping("selectByPage")
    public String selectByAll(HttpServletRequest request,BzKgg record,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        // pagehelper分页
        if (record.getSsqy() == null || record.getSsqy().equals("0")){
            Auth auth = Auth.getAuth(request);
            record.setSsqy(auth.getZwSsqy());
        }
        PageHelper.startPage(page, rows);
        List<BzKgg> list = bzKggServiceImpl.selectByPage(record);
        PageInfo<BzKgg> pageInfo = new PageInfo<>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(map);
    }
}
