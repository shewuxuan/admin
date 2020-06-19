package com.guodu.controller.ftu;

import cn.hutool.json.JSONUtil;
import com.guodu.pojo.ftu.FtuJbxx;
import com.guodu.service.ftu.FtuJbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: FtuJbxxController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/19 3:59 下午
 */
@RestController
@RequestMapping("ftuJbxx/")
public class FtuJbxxController {

    @Autowired
    private FtuJbxxService ftuJbxxServiceImpl;

    @GetMapping("selectByPrimaryKey/{tsid}")
    public String selectByPrimaryKey(@PathVariable String tsid){
        FtuJbxx ftuJbxx = ftuJbxxServiceImpl.selectByPrimaryKey(tsid);
        return JSONUtil.toJsonStr(ftuJbxx);
    }
}
