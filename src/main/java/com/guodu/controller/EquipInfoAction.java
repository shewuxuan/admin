package com.guodu.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.guodu.pojo.sys.Auth;
import com.guodu.pojo.equip.EquipInfo;
import com.guodu.pojo.equip.EquipPhoto;
import com.guodu.pojo.sys.SysDb;
import com.guodu.pojo.sys.SysSccj;
import com.guodu.pojo.sys.SysSsxl;
import com.guodu.service.impl.equip.EquipInfoServiceImpl;
import com.guodu.service.impl.equip.EquipPhotoServiceImpl;
import com.guodu.service.impl.sys.SysSccjServiceImpl;
import com.guodu.service.sys.SysDbService;
import com.guodu.service.sys.SysSsxlService;
import com.guodu.util.FileHandleUtils;
import com.guodu.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.*;

@RestController
@RequestMapping("equip")
public class EquipInfoAction {
    private static Logger log = Logger.getLogger(EquipInfoAction.class);
    @Autowired
    EquipInfoServiceImpl equipInfoServiceImpl;
    @Autowired
    EquipPhotoServiceImpl equipPhotoServiceImpl;
    @Autowired
    SysDbService sysDbServiceImpl;
    @Autowired
    SysSsxlService sysSsxlServiceImpl;
    @Value("${imgSavePath}")
    String imgSavePath;
    @Autowired
    SysSccjServiceImpl sysSccjServiceImpl;

    @RequestMapping(value = {"toEquipInfoView.action"}, produces = {"application/json;charset=UTF-8"})
    public ModelAndView toEquipInfoView(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("equip/equipInfoList");
        view.addObject("funcMap", Auth.getAuth(request).getRoleFunc());//暂时没有添加权限
        return view;
    }

    @RequestMapping(value = {"selectListEquipInfo.action"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Object selectListEquipInfo(HttpServletRequest request, @RequestParam Map<String, Object> form) {
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            if(form.get("ssqy").equals("")){
                Auth auth = Auth.getAuth(request);
                form.put("ssqy",auth.getZwSsqy());
            }
            res = this.equipInfoServiceImpl.selectPage(form);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(res);

    }

    @RequestMapping(value = {"toAddEquipInfoView.action"}, produces = {"application/json;charset=UTF-8"})
    public ModelAndView toAddEquipInfoView(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("equip/addEquipInfo");
        return view;
    }

    @RequestMapping(value = {"toEditEquipInfoView.action"}, produces = {"application/json;charset=UTF-8"})
    public ModelAndView toEditEquipInfoView(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("equip/editEquipInfo");
        String sbid = request.getParameter("sbid") == null ? "" : request.getParameter("sbid").toString();
        if (!sbid.equals("")) {
            Map<String, Object> vo = new HashMap<String, Object>();
            vo.put("sbid", sbid);
            EquipInfo equipInfo = this.equipInfoServiceImpl.selectList(vo).get(0);
            List<EquipPhoto> files = equipPhotoServiceImpl.selectList(vo);
            view.addObject("equipInfo", equipInfo);
            view.addObject("files",files);
        }
        return view;
    }

    @RequestMapping(value = {"toSeeEquipInfoView.action"}, produces = {"application/json;charset=UTF-8"})
    public ModelAndView toSeeEquipInfoView(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("equip/seeEquipInfo");
        String sbid = request.getParameter("sbid").toString();
        EquipInfo equipInfo = this.equipInfoServiceImpl.selectById(sbid);
        view.addObject("equipInfo", equipInfo);

        Map<String, Object> vo = new HashMap<>();
        vo.put("sbid", sbid);
        List<EquipPhoto> files = equipPhotoServiceImpl.selectList(vo);
        view.addObject("files",files);
        //为了实现页面轮播图
        vo.put("files",files);
        List<Map> tempList = (List<Map>)vo.get("files");
        List ids = new ArrayList();
        ids.add("0");//默认二维码id
        for (Map tmap :tempList){
            ids.add(tmap.get("PID").toString());
        }
        view.addObject("ids",JSON.toJSONString(ids));
        return view;
    }

    @RequestMapping(value = {"toSeeAllEquipInfoView.action"}, produces = {"application/json;charset=UTF-8"})
    public ModelAndView toSeeAllEquipInfoView(@RequestParam Map<String,Object> form, HttpServletRequest request) {
        ModelAndView view = new ModelAndView("equip/seeAllEquipInfo");
        return view;
    }

    @RequestMapping(value = {"seeAllEquipInfoQuery.action"}, produces = {"application/json;charset=UTF-8"})
    public Object seeAllEquipInfoQuery(@RequestParam Map<String,Object> form, HttpServletRequest request) {
        List<EquipInfo> equipInfos = this.equipInfoServiceImpl.selectList(form);
       return equipInfos;
    }

    @RequestMapping(value = {"addEquipInfo.action"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Object addEquipInfo(EquipInfo equipInfo, HttpServletRequest request) {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("code", "0");
        res.put("message", "添加成功");

        try {
            Map<String, Object> vo = new HashMap<String, Object>();
            vo.put("azddDdh",equipInfo.getAzddDdh());
            EquipInfo temp = new EquipInfo();
            temp.setAzddDdh(equipInfo.getAzddDdh());
            List<EquipInfo> equipInfos = equipInfoServiceImpl.selectByAll(temp);
            if(equipInfos != null && equipInfos.size()>0){
                res.put("code", "-1");
                res.put("message", "设备调度号已存在！");
                return JSON.toJSONString(res);
            }
            Date createDate = new Date();
            String sbid = StringUtils.createDateRandomString(createDate);
            equipInfo.setSbid(sbid);
            equipInfo.setCzr(Auth.getAuth(request).getUserId());
            equipInfo.setCzsj(createDate);
           // this.equipInfoServiceImpl.add(equipInfo);
            this.equipInfoServiceImpl.txAddEquipAndPhoto(request,equipInfo,sbid,imgSavePath);
        } catch (Exception e) {
            res.put("code", "-1");
            res.put("message", "操作失败");
            e.printStackTrace();
        }
        return JSON.toJSONString(res);
    }

    @RequestMapping(value = {"updateEquipInfo.action"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Object updateEquipInfo(EquipInfo equipInfo, HttpServletRequest request) {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("code", "0");
        res.put("message", "修改成功");
        try {
            equipInfo.setCzr(Auth.getAuth(request).getUserId());
            equipInfo.setCzsj(new Date());
            this.equipInfoServiceImpl.txUpdateEquipInfoAndPhoto(equipInfo,request,imgSavePath);
        } catch (Exception e) {
            res.put("code", "-1");
            res.put("message", "修改失败");
            e.printStackTrace();
        }
        return JSON.toJSONString(res);
    }

    @RequestMapping(value = {"deleteEquipInfo.action"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Object deleteEquipInfo(@RequestParam Map<String, Object> form) {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("code", "0");
        res.put("message", "删除成功");
        String sbid = (String) form.get("sbid");
        try {
            this.equipInfoServiceImpl.delete(sbid);
        } catch (Exception e) {
            res.put("code", "-1");
            res.put("message", "删除失败");
            e.printStackTrace();
        }
        return JSON.toJSONString(res);
    }

    @GetMapping("/selectByAll")
    public String selectByAll(EquipInfo equipInfo) {
        List<EquipInfo> equipInfos = equipInfoServiceImpl.selectByAll(equipInfo);
        return JSONUtil.toJsonStr(equipInfos);
    }

    @RequestMapping("/selectByPrimaryKey/{sbid}")
    public String selectByPrimaryKey(@PathVariable String sbid) {
        EquipInfo equipInfo = equipInfoServiceImpl.selectByPrimaryKey(sbid);
        return JSONUtil.toJsonStr(equipInfo);
    }

    @RequestMapping("/createQRCodeByEquipInfo.action")
    public void createQRCodeByEquipInfo(HttpServletRequest request, HttpServletResponse response) {
        EquipInfo equipInfo = equipInfoServiceImpl.selectById(request.getParameter("sbid"));
        //转换所属线路
        if(equipInfo.getSsxl() != null && !equipInfo.getSsxl().equals("")){
            SysSsxl sysSsxl = sysSsxlServiceImpl.selectByPrimaryKey(equipInfo.getSsxl());
            equipInfo.setSsxl(sysSsxl.getYxdw()+sysSsxl.getBdz()+sysSsxl.getXlmc());
        }else{
            equipInfo.setSsxl("");
        }
        //转换装置类型
        SysDb sysDb = new SysDb();
        sysDb.setKeycode("zz_type");
        sysDb.setKeyvalue(equipInfo.getZzlx());
        equipInfo.setZzlx(sysDbServiceImpl.selectByAll(sysDb).get(0).getKeymemo());
        sysDb.setKeycode("region");
        sysDb.setKeyvalue(equipInfo.getSsqy());
        equipInfo.setSsqy(sysDbServiceImpl.selectByAll(sysDb).get(0).getKeymemo());

        BufferedImage image = null;
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            response.addHeader("Content-Disposition", "attachment;filename=" +  java.net.URLEncoder.encode(equipInfo.getAzddDdh()+".jpg", "UTF-8"));
            image = equipInfoServiceImpl.createQRCodeByEquipInfo(request,equipInfo);
            // 输出图象到页面
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getEquipPhotos.action")
    public Object getEquipPhotoView(@RequestParam Map<String,Object> form) {
        List<EquipPhoto> phootos = equipPhotoServiceImpl.selectList(form);
        return JSONUtil.toJsonStr(phootos);
    }

    @RequestMapping("/getEquipPhotoView.action")
    public void getEquipPhotoView(HttpServletRequest request, HttpServletResponse response) {
        EquipPhoto equipPhoto = equipPhotoServiceImpl.selectById(request.getParameter("pid"));
        FileHandleUtils.previewImage(request,response,equipPhoto.getPPath());
    }

    /***
     * 查询通信模块厂家
     * @param param
     * @return
     */
    @RequestMapping("selectListSccj.action")
    public String selectListSccj(@RequestParam() Map<String,Object> param) {
        List<SysSccj> sysSccjList = sysSccjServiceImpl.selectList(param);
        return JSONUtil.toJsonStr(sysSccjList);
    }

    /***
     * 下载图片
     * @param form
     * @param request
     * @param response
     */
    @RequestMapping(value = {"/downLoadFileByFileId.action"}, produces = {"application/json;charset=UTF-8"})
    public void downLoadFileByFileId(@RequestParam Map<String, Object> form,HttpServletRequest request,HttpServletResponse response){
        String pId = (String)form.get("pId");
        EquipPhoto equipPhoto = equipPhotoServiceImpl.selectById(pId);
        String oldPath = equipPhoto.getPPath();
        String suffix = oldPath.substring(oldPath.lastIndexOf('.'));
        FileHandleUtils.downloadSingleFile(response,equipPhoto.getPPath(),equipPhoto.getPName()==""?"下载"+suffix:equipPhoto.getPName()+suffix);
    }
}