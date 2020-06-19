package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.dtu.BzCtgy;
import com.guodu.service.dtu.BzCtgyService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzCtgyController
 * @Description: TODO
 * @Author: 2uli
 * @Date: 2020/1/19 10:48 上午
 */
@RestController
@RequestMapping("bzctgy/")
public class BzCtgyController {

    @Autowired
    private BzCtgyService bzCtgyServiceImpl;

    /**
     * @MethodName: insert
     * @Description: TODO
     * @Param: [bzCtgy]
     * @Return: int
     * @Author: 2uli
     * @Date: 2020/1/19 10:37 上午
     */
    @RequestMapping("insert")
    public int insert(BzCtgy bzCtgy) {
        bzCtgy.setId(IDUtil.getStrId());
        try {
            int i = bzCtgyServiceImpl.insert(bzCtgy);
            StaticLog.info("bz_ctgy表【插入】成功 -----> " + bzCtgy.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_ctgy表【插入】失败 -----> " + bzCtgy.getId(), "ERROR");
            return 0;
        }
    }

    /**
     * @MethodName: deleteByPrimaryKey
     * @Description: TODO
     * @Param: [id]
     * @Return: int
     * @Author: 2uli
     * @Date: 2020/1/19 10:50 上午
     */
    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {
        try {
            int i = bzCtgyServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_ctgy表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_ctgy表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    /**
     * @MethodName: updateByPrimaryKey
     * @Description: TODO
     * @Param: [bzCtgy]
     * @Return: int
     * @Author: 2uli
     * @Date: 2020/1/19 10:49 上午
     */
    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzCtgy bzCtgy) {
        try {
            bzCtgy.setId(id);
            int i = bzCtgyServiceImpl.updateByPrimaryKey(bzCtgy);
            StaticLog.info("bz_ctgy表【修改】成功 -----> " + bzCtgy.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_ctgy表【修改】失败 -----> " + bzCtgy.getId(), "ERROR");
            return 0;
        }
    }

    /**
     * @MethodName: selectByPrimaryKey
     * @Description: TODO
     * @Param: [id]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/1/19 10:38 上午
     */
    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzCtgy bzCtgy = bzCtgyServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzCtgy);
    }

    /**
     * @MethodName: selectByAll
     * @Description: TODO
     * @Param: [bzCtgy]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/1/19 10:38 上午
     */
    @RequestMapping("selectByAll")
    public String selectByAll(BzCtgy bzCtgy) {
        List<BzCtgy> bzCtgies = bzCtgyServiceImpl.selectByAll(bzCtgy);
        return JSONUtil.toJsonStr(bzCtgies);
    }

    @GetMapping("selectByPage")
    public String selectByAll(BzCtgy bzCtgy,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("bzCtgy", bzCtgy);
        map.put("page", page);
        map.put("rows", rows);
        return bzCtgyServiceImpl.selectByPage(map);
    }
}
