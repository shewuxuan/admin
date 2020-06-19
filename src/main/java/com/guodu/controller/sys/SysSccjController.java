package com.guodu.controller.sys;

import cn.hutool.json.JSONUtil;
import com.guodu.pojo.sys.SysSccj;
import com.guodu.service.impl.sys.SysSccjServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SysSsxlController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/14 2:34 下午
 */
@RestController
public class SysSccjController {

    @Autowired
    private SysSccjServiceImpl sysSccjServiceImpl;

    /***
     * 下载厂家
     * @return
     */
    @GetMapping("sccj/getSccj")
    public String getSccj() {
        Map<String, Object> param = new HashMap<>();
        List<SysSccj> sysSccjs = sysSccjServiceImpl.selectList(param);
        return JSONUtil.toJsonStr(sysSccjs);
    }

}
