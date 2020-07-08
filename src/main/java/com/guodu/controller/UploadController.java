package com.guodu.controller;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.guodu.pojo.dtu.Jbxx;
import com.guodu.pojo.pwbh.PwbhBzZzsy;
import com.guodu.pojo.pwbh.PwbhJbxx;
import com.guodu.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UploadController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/3/3 4:27 下午
 */
@RestController
public class UploadController {

    @Autowired
    private UploadService uploadServiceImpl;

    @Value("${imgSavePath}")
    private String imgSavePath;

    private Map<Object, Object> map = new HashMap<>(16);

    @RequestMapping("uploadJl")
    public String uploadJl(@RequestBody Jbxx jbxx) {
        map.clear();
        try {
            uploadServiceImpl.uploadJl(jbxx);
            map.put("code", 0);
            map.put("msg", "上传记录成功！");
            StaticLog.info("上传记录成功 -----> " + jbxx.getTsid(), "INFO");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "上传记录失败！");
            StaticLog.error(e, "上传记录失败 -----> " + jbxx.getTsid(), "ERROR");
        }
        map.put("data", JSONUtil.toJsonStr(jbxx));
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("uploadJbxxPhotos")
    public String uploadJbxxPhotos(@RequestBody  List<Map<String,Object>> jbxxPhotos) {
        map.clear();
        try {
            String tsid = jbxxPhotos.get(0).get("TSID").toString();
            uploadServiceImpl.uploadJbxxFile(tsid,jbxxPhotos,imgSavePath);
            map.put("code", 0);
            map.put("msg", "上传照片成功！");
            StaticLog.info("上传照片成功");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "上传照片失败！");
            StaticLog.error(e, "上传照片失败");
            e.printStackTrace();
        }
        return JSONUtil.toJsonStr(map);
    }

    @RequestMapping("changeJbxxFiles")
    public void changeJbxxFile(@RequestBody ArrayList<File> imgList) {
        FileOutputStream ous = null;
        FileInputStream ins = null;
        File newImg = null;
        try {
            for (File img:imgList){
                newImg = new File(imgSavePath+img.getName());
                ins = new FileInputStream(img);
                if(!newImg.getParentFile().exists()){
                    newImg.getParentFile().mkdir();
                }
                ous = new FileOutputStream(newImg);
                byte[] bt = new byte[1024];
                while (ins.read(bt) != -1) {
                    ous.write(bt);
                }
            }
            if (ous!=null) ous.close();
            if (ins!=null) ins.close();
            StaticLog.info("更新照片成功");
        } catch (Exception e) {
            StaticLog.error(e, "更新照片失败");
            e.printStackTrace();
        }
    }

    /***
     * 配网保护上传
     * @return
     */
    @RequestMapping(value = {"uploadPwbhJl"}, produces = {"application/json;charset=UTF-8"})
    public String uploadPwbhJl(@RequestBody  Map<String, Object> param) {
        System.out.println(123);
        map.clear();
        map.put("code", 0);
        try {
            uploadServiceImpl.uploadPwbhJl(param);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
        }
        return JSONUtil.toJsonStr(map);
    }
}
