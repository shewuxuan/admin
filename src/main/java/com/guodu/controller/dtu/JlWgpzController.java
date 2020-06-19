package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.guodu.pojo.sys.Auth;
import com.guodu.pojo.dtu.JlWgpz;
import com.guodu.service.dtu.JlWgpzService;
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
 * @ClassName: BzWgpzController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:39 下午
 */
@RestController
@RequestMapping("jlwgpz/")
public class JlWgpzController {

    @Autowired
    private JlWgpzService jlWgpzServiceImpl;

    private Map<String, Object> map = new HashMap<>(16);

    @RequestMapping("insert")
    public String insert(@RequestBody JlWgpz record, HttpServletRequest request) {
        map.clear();
        try {
            record.setId(IDUtil.getStrId());
            record.setCzr(Auth.getAuth(request).getLoginname());
            record.setCzsj(new Date());
            int i = jlWgpzServiceImpl.insert(record);
            map.put("code", 0);
            map.put("msg", "添加成功！");
            map.put("data", i);
            StaticLog.info("jl_wgpz表【插入】成功 -----> " + record.getId(), "INFO");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "添加失败！");
            map.put("data", 0);
            StaticLog.error(e, "jl_wgpz表【插入】失败 -----> " + record.getId(), "ERROR");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public String deleteByPrimaryKey(@PathVariable String id) {
        map.clear();
        try {
            jlWgpzServiceImpl.deleteByPrimaryKey(id);
            map.put("code", "0");
            map.put("msg", "删除成功");
            StaticLog.info("jl_wgpz表【删除】成功 -----> " + id, "INFO");
        } catch (Exception e) {
            StaticLog.error(e, "jl_wgpz表【删除】失败 -----> " + id, "ERROR");
            map.put("code", "-1");
            map.put("msg", "删除失败！");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("updateByPrimaryKey")
    public int updateByPrimaryKey(JlWgpz jlWgpz) {
        try {
            int i = jlWgpzServiceImpl.updateByPrimaryKey(jlWgpz);
            StaticLog.info("jl_wgpz表【修改】成功 -----> " + jlWgpz.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "jl_wgpz表【修改】失败 -----> " + jlWgpz.getId(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey")
    public String selectByPrimaryKey(String id) {
        JlWgpz jlWgpz = jlWgpzServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(jlWgpz);
    }


    @RequestMapping("selectByAll")
    public String selectByAll(JlWgpz jlWgpz) {
        map.clear();
        try {
            List<JlWgpz> jlWgpzs = jlWgpzServiceImpl.selectByAll(jlWgpz);
            map.put("code", "0");
            map.put("msg", "查询完成");
            map.put("data", jlWgpzs);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "查询异常");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("updateBatch")
    public String updateBatch(@RequestBody List<JlWgpz> list, HttpServletRequest request) {
        map.clear();
        try {
            String czr = Auth.getAuth(request).getLoginname();
            for (JlWgpz jlWgpz : list) {
                jlWgpz.setCzr(czr);
                jlWgpz.setCzsj(new Date());
            }
            jlWgpzServiceImpl.updateBatch(list);
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
