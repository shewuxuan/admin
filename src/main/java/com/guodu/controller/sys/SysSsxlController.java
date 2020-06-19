package com.guodu.controller.sys;

import cn.hutool.json.JSONUtil;
import com.guodu.pojo.sys.SysSsxl;
import com.guodu.service.sys.SysSsxlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: SysSsxlController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/14 2:34 下午
 */
@RestController
public class SysSsxlController {

    @Autowired
    private SysSsxlService sysSsxlServiceImpl;

    @GetMapping("ssxl/selectByAll")
    public String selectByAll(@RequestBody SysSsxl record) {
        List<SysSsxl> sysSsxls = sysSsxlServiceImpl.selectByAll(record);
        return JSONUtil.toJsonStr(sysSsxls);
    }

    /**
     * @MethodName: selectByGroup
     * @Description: TODO 分组查询
     * @Param: [sysSsxl, groupBy]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/5/25 4:38 下午
     */
    @GetMapping("ssxl/selectByGroup/{groupBy}")
    public String selectByGroup(SysSsxl sysSsxl, @PathVariable("groupBy") String groupBy) {
        List<SysSsxl> sysSsxls = sysSsxlServiceImpl.selectByGroup(sysSsxl, groupBy);
        return JSONUtil.toJsonStr(sysSsxls);
    }

    @GetMapping("ssxl/selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable("id") String id) {
        SysSsxl sysSsxl = sysSsxlServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(sysSsxl);
    }

    /***
     * 下载所属线路
     * @return
     */
    @GetMapping("ssxl/getSsxl")
    public String getSsxl() {
        List<SysSsxl> sysSsxls = sysSsxlServiceImpl.selectByAll(new SysSsxl());
        return JSONUtil.toJsonStr(sysSsxls);
    }

}
