package com.guodu.controller.sys;

import cn.hutool.json.JSONUtil;
import com.guodu.pojo.sys.SysDb;
import com.guodu.service.sys.SysDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: SysDbController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/14 2:34 下午
 */
@RestController
public class SysDbController {

    @Autowired
    private SysDbService sysDbServiceImpl;

    /**
     * @MethodName: selectSsqyByAll
     * @Description: TODO 所属区域
     * @Param: []
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/5/22 5:00 下午
     */
    @RequestMapping("ssqy/selectSsqyByAll")
    public String selectSsqyByAll() {
        SysDb sysDb = new SysDb();
        sysDb.setKeycode("region");
        List<SysDb> sysDbs = sysDbServiceImpl.selectByAll(sysDb);
        return JSONUtil.toJsonStr(sysDbs);
    }

    /**
     * @MethodName: selectZzlxByAll
     * @Description: TODO DTU装置类型
     * @Param: []
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/5/22 5:00 下午
     */
    @RequestMapping("zzlx/selectZzlxByAll")
    public String selectZzlxByAll() {
        SysDb sysDb = new SysDb();
        sysDb.setKeycode("zz_type");
        List<SysDb> sysDbs = sysDbServiceImpl.selectByAll(sysDb);
        return JSONUtil.toJsonStr(sysDbs);
    }

    /**
     * @MethodName: selectSbZzlxByAll
     * @Description: TODO 设备装置类型
     * @Param: []
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/5/22 4:59 下午
     */
    @RequestMapping("sbZzlx/selectSbZzlxByAll")
    public String selectSbZzlxByAll() {
        SysDb sysDb = new SysDb();
        sysDb.setKeycode("sb_type");
        List<SysDb> sysDbs = sysDbServiceImpl.selectByAll(sysDb);
        return JSONUtil.toJsonStr(sysDbs);
    }

    /**
     * @MethodName: selectQxTypeByAll
     * @Description: TODO 缺陷分类
     * @Param: []
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/5/22 5:00 下午
     */
    @GetMapping("qxfl/selectQxTypeByAll")
    public String selectQxTypeByAll() {
        SysDb sysDb = new SysDb();
        sysDb.setKeycode("qx_type");
        List<SysDb> sysDbs = sysDbServiceImpl.selectByAll(sysDb);
        return JSONUtil.toJsonStr(sysDbs);
    }

}
