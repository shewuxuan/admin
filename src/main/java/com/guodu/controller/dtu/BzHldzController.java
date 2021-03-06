package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guodu.pojo.dtu.BzGjcs;
import com.guodu.pojo.dtu.BzHldz;
import com.guodu.pojo.sys.Auth;
import com.guodu.service.dtu.BzHldzService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzHldzController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:39 下午
 */
@RestController
@RequestMapping("bzhldz/")
public class BzHldzController {

    @Autowired
    private BzHldzService bzHldzServiceImpl;

    @RequestMapping("insert")
    public int insert(BzHldz bzHldz) {
        bzHldz.setId(IDUtil.getStrId());
        try {
            int i = bzHldzServiceImpl.insert(bzHldz);
            StaticLog.info("bz_hldz表【插入】成功 -----> " + bzHldz.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_hldz表【插入】失败 -----> " + bzHldz.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {
        try {
            int i = bzHldzServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_hldz表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_hldz表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzHldz bzHldz) {
        try {
            bzHldz.setId(id);
            int i = bzHldzServiceImpl.updateByPrimaryKey(bzHldz);
            StaticLog.info("bz_hldz表【修改】成功 -----> " + bzHldz.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_hldz表【修改】失败 -----> " + bzHldz.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzHldz bzHldz = bzHldzServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzHldz);
    }

    @RequestMapping("selectByAll")
    public String selectByAll(BzHldz bzHldz) {
        List<BzHldz> bzHldzs = bzHldzServiceImpl.selectByAll(bzHldz);
        return JSONUtil.toJsonStr(bzHldzs);
    }

    @GetMapping("selectByPage")
    public String selectByAll(HttpServletRequest request,BzHldz record,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        // pagehelper分页
        if (record.getSsqy() == null || record.getSsqy().equals("0")){
            Auth auth = Auth.getAuth(request);
            record.setSsqy(auth.getZwSsqy());
        }
        PageHelper.startPage(page, rows);
        List<BzHldz> list = bzHldzServiceImpl.selectByPage(record);
        PageInfo<BzHldz> pageInfo = new PageInfo<>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(map);
    }
}
