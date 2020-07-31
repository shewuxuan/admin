package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guodu.pojo.dtu.BzLpjy;
import com.guodu.service.dtu.BzLpjyService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzLpjyController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:39 下午
 */
@RestController
@RequestMapping("bzlpjy/")
public class BzLpjyController {

    @Autowired
    private BzLpjyService bzLpjyServiceImpl;

    private final Map<String, Object> map = new HashMap<>(16);

    @RequestMapping("insert")
    public int insert(BzLpjy bzLpjy) {
        bzLpjy.setId(IDUtil.getStrId());
        try {
            int i = bzLpjyServiceImpl.insert(bzLpjy);
            StaticLog.info("bz_lpjy表【插入】成功 -----> " + bzLpjy.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_lpjy表【插入】失败 -----> " + bzLpjy.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {
        try {
            int i = bzLpjyServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_lpjy表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_lpjy表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzLpjy bzLpjy) {
        try {
            bzLpjy.setId(id);
            int i = bzLpjyServiceImpl.updateByPrimaryKey(bzLpjy);
            StaticLog.info("bz_lpjy表【修改】成功 -----> " + bzLpjy.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_lpjy表【修改】失败 -----> " + bzLpjy.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzLpjy bzLpjy = bzLpjyServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzLpjy);
    }

    @RequestMapping("selectByAll")
    public String selectByAll(BzLpjy bzLpjy) {
        List<BzLpjy> bzLpjys = bzLpjyServiceImpl.selectByAll(bzLpjy);
        return JSONUtil.toJsonStr(bzLpjys);
    }

    @GetMapping("selectByPage")
    public String selectByAll(BzLpjy record,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        map.clear();
        // pagehelper分页
        PageHelper.startPage(page, rows);
        List<BzLpjy> list = bzLpjyServiceImpl.selectByPage(record);
        PageInfo<BzLpjy> pageInfo = new PageInfo<>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(map);
    }
}
