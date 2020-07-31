package com.guodu.controller.sys;

import cn.hutool.json.JSONUtil;
import com.guodu.pojo.sys.SysSsxl;
import com.guodu.service.sys.SysSsxlService;
import com.guodu.util.ImportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SysSsxlController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/14 2:34 下午
 */
@RestController
public class SysSsxlController {

    @Autowired
    private SysSsxlService sysSsxlServiceImpl;

    @GetMapping("ssxl/selectByAll")
    public String selectByAll(@RequestBody SysSsxl record) {
        List<SysSsxl> sysSsxls = sysSsxlServiceImpl.selectByAll(record);
        return JSONUtil.toJsonStr(sysSsxls);
    }

    /**
     * @MethodName: selectByGroup
     * @Description: TODO 分组查询
     * @Param: [sysSsxl, groupBy]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/5/25 4:38 下午
     */
    @GetMapping("ssxl/selectByGroup/{groupBy}")
    public String selectByGroup(SysSsxl sysSsxl, @PathVariable("groupBy") String groupBy) {
        List<SysSsxl> sysSsxls = sysSsxlServiceImpl.selectByGroup(sysSsxl, groupBy);
        return JSONUtil.toJsonStr(sysSsxls);
    }

    @GetMapping("ssxl/selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable("id") String id) {
        SysSsxl sysSsxl = sysSsxlServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(sysSsxl);
    }

    /***
     * 下载所属线路
     * @return
     */
    @GetMapping("ssxl/getSsxl")
    public String getSsxl() {
        List<SysSsxl> sysSsxls = sysSsxlServiceImpl.selectByAll(new SysSsxl());
        return JSONUtil.toJsonStr(sysSsxls);
    }

    /***
     * 导入所属线路
     * @return
     */
    @RequestMapping(value = {"ssxl/importExcel"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Object importExcel(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        InputStream in =null;
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("code", "0");
        res.put("message", "导入成功！");
        try{
            in = file.getInputStream();
            SysSsxl ssxl = new SysSsxl();
            List<SysSsxl> oldSsxls = null;
            List<List<Object>> datas = ImportExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
            if(datas!=null && datas.size()>0){
               for (List<Object> data:datas){
                   ssxl.setSsqy(toSsqyByValue(data.get(1).toString()));
                   ssxl.setYxdw(data.get(2).toString());
                   ssxl.setBdz(data.get(3).toString());
                   ssxl.setXlmc(data.get(4).toString());
                   oldSsxls =sysSsxlServiceImpl.selectByAll(ssxl);
                   if(oldSsxls != null && oldSsxls.size()>0){
                       continue;
                   }else {
                       ssxl.setId(String.valueOf(sysSsxlServiceImpl.getMaxId()+1));
                       sysSsxlServiceImpl.insert(ssxl);
                   }
               }
            }
        }catch (Exception e){
            res.put("code", "-1");
            res.put("message", "导入出错，请检查数据格式！");
            e.printStackTrace();
        }finally{
            if(in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return JSONUtil.toJsonStr(res);
    }

    public String toSsqyByValue(String value){
        String str = value;
        if(value.contains("石景山")){
            str = "1";
        }else if(value.contains("门头沟")){
            str = "2";
        }else if(value.contains("朝阳")){
            str = "3";
        }
        return str;
    }

}
