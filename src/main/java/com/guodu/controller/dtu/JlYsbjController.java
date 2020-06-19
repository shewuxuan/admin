package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import com.guodu.pojo.sys.Auth;
import com.guodu.pojo.dtu.JlYsbj;
import com.guodu.service.dtu.JlYsbjService;
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
 * @ClassName: JlYsbjController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/20 1:42 下午
 */
@RestController
@RequestMapping("jlysbj/")
public class JlYsbjController {

    @Autowired
    private JlYsbjService jlYsbjServiceImpl;
    private Map<String, Object> map = new HashMap<>(16);


    @RequestMapping("insert2")
    public String insert2(@RequestBody JlYsbj jlYsbj, HttpServletRequest request) {
        map.clear();
        try {
            jlYsbj.setId(IDUtil.getStrId());
            // 更新操作人和操作时间
            jlYsbj.setCzr(Auth.getAuth(request).getLoginname());
            jlYsbj.setCzsj(new Date());
            int i = jlYsbjServiceImpl.insert(jlYsbj);
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
    public String selectByAll(JlYsbj jlYsbj) {
        map.clear();
        try {
            List<JlYsbj> jlYsbjs = jlYsbjServiceImpl.selectByAll(jlYsbj);
            map.put("code", "0");
            map.put("msg", "查询完成");
            map.put("data", jlYsbjs);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "查询异常");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("updateBatch")
    public String updateBatch(@RequestBody List<JlYsbj> list, HttpServletRequest request) {
        map.clear();
        try {
            String czr = Auth.getAuth(request).getLoginname();
            for (JlYsbj jlYsbj : list) {
                jlYsbj.setCzr(czr);
                jlYsbj.setCzsj(new Date());
            }
            jlYsbjServiceImpl.updateBatch(list);
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
