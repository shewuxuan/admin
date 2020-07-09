package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.guodu.pojo.dtu.Jbxx;
import com.guodu.pojo.dtu.JbxxPhoto;
import com.guodu.service.*;
import com.guodu.service.dtu.JbxxService;
import com.guodu.service.impl.cq.CqRecordServiceImpl;
import com.guodu.service.impl.dtu.ExportDocumentService;
import com.guodu.service.impl.dtu.JbxxBeizhuServiceImpl;
import com.guodu.service.impl.dtu.JbxxGjdzServiceImpl;
import com.guodu.service.impl.dtu.JbxxPhotoServiceImpl;
import com.guodu.util.FileHandleUtils;
import com.guodu.util.IDUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: JbxxController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:39 下午
 */
@RestController
@RequestMapping("jbxx/")
public class JbxxController {

    @Autowired
    private JbxxService jbxxServiceImpl;
    @Autowired
    private ExportDocumentService exportDocumentService;

    private Map<String, Object> map = new HashMap<>(16);


    @RequestMapping("insert")
    public int insert(Jbxx jbxx) {
        map.clear();
        jbxx.setTsid(IDUtil.getStrId());
        try {
            jbxx.setTsid(IDUtil.getStrId());
            jbxx.setSsqy("1");
            jbxx.setTssj(new Date());
            jbxx.setAzddDdh("bj");
            jbxx.setZzlx("1");
            jbxx.setCzr("ad");
            jbxx.setCzsj(new Date());
            int i = jbxxServiceImpl.insert(jbxx);

            map.put("ssqy", jbxx.getSsqy());
            map.put("tsid", jbxx.getTsid());
            StaticLog.info("jbxx表【插入】成功 -----> " + jbxx.getTsid(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "jbxx表【插入】失败 -----> " + jbxx.getTsid(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("deleteByPrimaryKey")
    public int deleteByPrimaryKey(String id) {
        map.clear();
        try {
            int i = jbxxServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("jbxx表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "jbxx表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    @RequestMapping("updateByPrimaryKey")
    public int updateByPrimaryKey(Jbxx jbxx) {
        map.clear();
        try {
            int i = jbxxServiceImpl.updateByPrimaryKey(jbxx);
            StaticLog.info("jbxx表【修改】成功 -----> " + jbxx.getTsid(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "jbxx表【修改】失败 -----> " + jbxx.getTsid(), "ERROR");
            return 0;
        }
    }

    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        map.clear();
        Jbxx jbxx = jbxxServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(jbxx);
    }


    @RequestMapping("selectByPage")
    public String selectByPage(
            @RequestParam(value = "ssqy", defaultValue = "") String ssqy
            , @RequestParam(value = "zzlx", defaultValue = "") String zzlx
            , @RequestParam(value = "startTssj", defaultValue = "") String startTssj
            , @RequestParam(value = "endTssj", defaultValue = "") String endTssj
            , @RequestParam(value = "azddDdh", defaultValue = "") String azddDdh
            , @RequestParam(value = "page", defaultValue = "1") Integer page
            , @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        map.clear();
        try {
            map.put("ssqy", ssqy);
            map.put("zzlx", zzlx);
            map.put("startTssj", startTssj);
            map.put("endTssj", endTssj);
            map.put("azddDdh", azddDdh);
            PageHelper.startPage(page, limit);
            List<Jbxx> jbxxs = jbxxServiceImpl.selectByPage(map);
            map.clear();
            map.put("code", 0);
            map.put("msg", "查询完成！");
            map.put("count", jbxxs.size());
            map.put("data", jbxxs);
        } catch (Exception e) {
            map.clear();
            map.put("code", -1);
            map.put("msg", "查询异常！");
            map.put("data", null);
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping(value = {"selectListJbxx.action", "/"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Object selectListJbxx(HttpServletRequest request, @RequestParam Map<String, Object> form) {
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            res = this.jbxxServiceImpl.selectPage(form);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(res);

    }

    /***
     * 调试信息导出
     * @param request
     * @param response
     */
    @RequestMapping(value = {"exportToWordByJbxx.action",  "/" }, produces = { "application/json;charset=UTF-8" })
    public void exportToWordByJbxx(HttpServletRequest request, HttpServletResponse response) {
        String tsid = request.getParameter("tsid");
        XWPFDocument doc = null;
        OutputStream os = null;
        try {
            Jbxx jbxx = jbxxServiceImpl.selectByPrimaryKey(tsid);
            doc = exportDocumentService.exportToWordByWord(jbxx);
            os = response.getOutputStream();
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");
            response.setHeader("Content-disposition","attachment;filename="+java.net.URLEncoder.encode(jbxx.getAzddDdh()+"DTU调试记录表", "UTF-8")+".docx");//filename为导出的word的名字
            doc.write(os);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(os!=null){
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Autowired
    JbxxPhotoServiceImpl jbxxPhotoServiceImpl;
    @Autowired
    JbxxBeizhuServiceImpl jbxxBeizhuServiceImpl;
    @Autowired
    CqRecordServiceImpl createTsjlServiceImpl;
    @Autowired
    JbxxGjdzServiceImpl jbxxGjdzServiceImpl;
    @Autowired
    UploadService uploadServiceImpl;

    @RequestMapping(value = {"deleteJbxxAndRecord.action" }, produces = { "application/json;charset=UTF-8" },method=RequestMethod.POST)
    public Object deleteJbxxAndRecord(@RequestParam Map<String, Object> form) {
        Map<String , Object> res = new HashMap<String , Object>();
        res.put("code", "0");
        res.put("message", "删除成功");
        String tsid = (String)form.get("tsid");
        try{
            Map vo = new HashMap();
            vo.put("tsid",tsid);
            List<JbxxPhoto> photos = jbxxPhotoServiceImpl.selectList(vo);
            for(JbxxPhoto photo:photos){
                FileHandleUtils.deleteFile(photo.getPPath());//删除磁盘文件
                jbxxPhotoServiceImpl.delete(photo.getPid());//删除文件记录
            }
            jbxxBeizhuServiceImpl.deleteByPrimaryKey(tsid);//删除备注表
            uploadServiceImpl.deleteJlByJbxx(tsid);//删除所有调试记录
            jbxxGjdzServiceImpl.deleteAllByTsid(tsid);//删除告警定值记录
            jbxxServiceImpl.deleteByPrimaryKey(tsid);
        }catch(Exception e){
            res.put("code", "-1");
            res.put("message", "删除失败");
            e.printStackTrace();
        }
        return JSON.toJSONString(res);
    }
}
