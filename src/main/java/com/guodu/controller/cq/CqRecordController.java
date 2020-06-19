package com.guodu.controller.cq;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guodu.pojo.sys.Auth;
import com.guodu.pojo.cq.CqRecord;
import com.guodu.service.cq.CqRecordService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CqController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/3/23 1:27 下午
 */
@RestController
@RequestMapping("cqrecord/")
public class CqRecordController {

    @Autowired
    private CqRecordService cqRecordServiceImpl;

    @RequestMapping("insert")
    public String insert(@RequestBody CqRecord record, HttpServletRequest request) {
        map.clear();
        try {
            record.setCqid(IDUtil.getStrId());
            record.setCzr(Auth.getAuth(request).getLoginname());
            record.setCzsj(new Date());
            int i = cqRecordServiceImpl.insert(record);
            map.put("code", 0);
            map.put("msg", "添加成功！");
            map.put("data", i);
            StaticLog.info("cq_record表【插入】成功 -----> " + record.getCqid(), "INFO");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "添加失败！");
            map.put("data", 0);
            StaticLog.error(e, "cq_record表【插入】失败 -----> " + record.getCqid(), "ERROR");
        }
        return JSONUtil.toJsonStr(map);
    }

    private Map<String, Object> map = new HashMap<>(16);

    @RequestMapping("deleteByPrimaryKey/{id}")
    public String deleteByPrimaryKey(@PathVariable String id) {
        map.clear();
        try {
            cqRecordServiceImpl.deleteByPrimaryKey(id);
            map.put("code", "0");
            map.put("msg", "删除成功!");
            StaticLog.info("cq_record表【删除】成功 -----> " + id, "INFO");
        } catch (Exception e) {
            StaticLog.error(e, "cq_record表【删除】失败 -----> " + id, "ERROR");
            map.put("code", "-1");
            map.put("msg", "删除失败!");
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("updateByPrimaryKey")
    public String updateByPrimaryKey(@RequestBody CqRecord record, HttpServletRequest request) {
        map.clear();
        try {
            record.setCzr(Auth.getAuth(request).getLoginname());
            record.setCzsj(new Date());
            cqRecordServiceImpl.updateByPrimaryKey(record);
            map.put("code", "0");
            map.put("msg", "修改成功!");
            StaticLog.info("cq_record表【修改】成功 -----> " + record.getCqid(), "INFO");
        } catch (Exception e) {
            StaticLog.error(e, "cq_record表【修改】失败 -----> " + record.getCqid(), "ERROR");
            map.put("code", "-1");
            map.put("msg", "修改失败!");
        }
        return JSONUtil.toJsonStr(map);

    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        map.clear();
        try {
            CqRecord cqRecord = cqRecordServiceImpl.selectByPrimaryKey(id);
            map.put("code", "0");
            map.put("data", cqRecord);
        } catch (Exception e) {
            StaticLog.error(e, "cqrecord/selectByPrimaryKey --------> 查询异常", "ERROR");
            map.put("code", "-1");
            map.put("data", null);
        }
        return JSONUtil.toJsonStr(map);

    }

    @RequestMapping("selectByPage")
    public String selectByPage(CqRecord record,
                               @RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        map.clear();
        // pagehelper分页
        PageHelper.startPage(page, rows);
        List<CqRecord> cqRecords = cqRecordServiceImpl.selectByPage(record);
        PageInfo<CqRecord> pageInfo = new PageInfo<>(cqRecords);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(map);
    }

}
