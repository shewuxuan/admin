package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import com.guodu.pojo.sys.Auth;
import com.guodu.pojo.dtu.JlDtu;
import com.guodu.service.dtu.JlDtuService;
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
 * @ClassName: JlDtuController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/20 6:27 下午
 */
@RestController
@RequestMapping("jldtu/")
public class JlDtuController {

    @Autowired
    private JlDtuService jlDtuServiceImpl;

    private Map<String, Object> map = new HashMap<>(16);

    @RequestMapping("insert2")
    public String insert2(@RequestBody JlDtu jlDtu, HttpServletRequest request) {
        map.clear();
        try {
            jlDtu.setId(IDUtil.getStrId());
            // 更新操作人和操作时间
            jlDtu.setCzr(Auth.getAuth(request).getLoginname());
            jlDtu.setCzsj(new Date());
            int i = jlDtuServiceImpl.insert(jlDtu);
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
    public String selectByAll(JlDtu jlDtu) {
        map.clear();
        try {
            List<JlDtu> jlDtus = jlDtuServiceImpl.selectByAll(jlDtu);
            map.put("code", "0");
            map.put("msg", "查询完成");
            map.put("data", jlDtus);
            map.put("count", jlDtus.size());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "查询异常");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("updateBatch")
    public String updateBatch(@RequestBody List<JlDtu> list, HttpServletRequest request) {
        map.clear();
        try {
            String czr = Auth.getAuth(request).getLoginname();
            // 更新操作人和操作时间
            for (JlDtu jlDtu : list) {
                jlDtu.setCzr(czr);
                jlDtu.setCzsj(new Date());
            }
            jlDtuServiceImpl.updateBatch(list);
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
