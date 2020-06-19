package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.sys.Auth;
import com.guodu.pojo.dtu.JlHldz;
import com.guodu.service.dtu.JlHldzService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: JlHldzController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/20 1:31 下午
 */
@RestController
@RequestMapping("jlhldz/")
public class JlHldzController {

    @Autowired
    private JlHldzService jlHldzServiceImpl;

    private Map<String, Object> map = new HashMap<>(16);

    @RequestMapping("insert")
    public String insert(@RequestBody JlHldz record, HttpServletRequest request) {
        map.clear();
        try {
            record.setId(IDUtil.getStrId());
            record.setCzr(Auth.getAuth(request).getLoginname());
            record.setCzsj(new Date());
            int i = jlHldzServiceImpl.insert(record);
            map.put("code", 0);
            map.put("msg", "添加成功！");
            map.put("data", i);
            StaticLog.info("jl_hldz表【插入】成功 -----> " + record.getId(), "INFO");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "添加失败！");
            map.put("data", 0);
            StaticLog.error(e, "jl_hldz表【插入】失败 -----> " + record.getId(), "ERROR");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("selectByAll")
    public String selectByAll(JlHldz jlHldz) {
        map.clear();
        try {
            List<JlHldz> jlHldzs = jlHldzServiceImpl.selectByAll(jlHldz);
            map.put("code", "0");
            map.put("msg", "查询完成");
            map.put("data", jlHldzs);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "查询异常");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("updateBatch")
    public String updateBatch(@RequestBody List<JlHldz> list, HttpServletRequest request) {
        map.clear();
        try {
            String czr = Auth.getAuth(request).getLoginname();
            for (JlHldz jlHldz : list) {
                jlHldz.setCzr(czr);
                jlHldz.setCzsj(new Date());
            }
            jlHldzServiceImpl.updateBatch(list);
            map.put("code", "0");
            map.put("msg", "提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "提交失败！");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public String deleteByPrimaryKey(@PathVariable String id) {
        map.clear();
        try {
            jlHldzServiceImpl.deleteByPrimaryKey(id);
            map.put("code", "0");
            map.put("msg", "删除成功");
            StaticLog.info("jl_hldz表【删除】成功 -----> " + id, "INFO");
        } catch (Exception e) {
            StaticLog.error(e, "jl_hldz表【删除】失败 -----> " + id, "ERROR");
            map.put("code", "-1");
            map.put("msg", "删除失败！");
        }
        return JSONUtil.toJsonStr(map);
    }
}
