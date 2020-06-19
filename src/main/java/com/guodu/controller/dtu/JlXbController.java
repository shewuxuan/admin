package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import com.guodu.pojo.sys.Auth;
import com.guodu.pojo.dtu.JlXb;
import com.guodu.service.dtu.JlXbService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: JlXbController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/20 1:38 下午
 */
@RestController
@RequestMapping("jlxb/")
public class JlXbController {

    @Autowired
    private JlXbService jlXbServiceImpl;

    private Map<String, Object> map = new HashMap<>(16);


    @RequestMapping("insert2")
    public String insert2(@RequestBody JlXb jl, HttpServletRequest request) {
        map.clear();
        try {
            jl.setId(IDUtil.getStrId());
            // 更新操作人和操作时间
            jl.setCzr(Auth.getAuth(request).getLoginname());
            jl.setCzsj(new Date());
            int i = jlXbServiceImpl.insert(jl);
            map.put("code", "0");
            map.put("msg", "提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "提交失败！");
        }
        return JSONUtil.toJsonStr(map);
    }


    @RequestMapping("selectByAll")
    public String selectByAll(JlXb jlXb) {
        map.clear();
        try {
            List<JlXb> jlXbs = jlXbServiceImpl.selectByAll(jlXb);
            map.put("code", "0");
            map.put("msg", "查询完成");
            map.put("data", jlXbs);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "查询异常");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("updateBatch")
    public String updateBatch(@RequestBody List<JlXb> list, HttpServletRequest request) {
        map.clear();
        try {
            String czr = Auth.getAuth(request).getLoginname();
            // 更新操作人和操作时间
            for (JlXb jlXb : list) {
                jlXb.setCzr(czr);
                jlXb.setCzsj(new Date());
            }
            jlXbServiceImpl.updateBatch(list);
            map.put("code", "0");
            map.put("msg", "提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "提交失败！");
        }
        return JSONUtil.toJsonStr(map);
    }
}
