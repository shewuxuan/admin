package com.guodu.service.impl;

import com.guodu.pojo.dtu.Jbxx;
import com.guodu.pojo.dtu.JbxxPhoto;
import com.guodu.pojo.equip.EquipInfo;
import com.guodu.pojo.equip.EquipPhoto;
import com.guodu.service.*;
import com.guodu.service.dtu.JbxxBeizhuService;
import com.guodu.service.impl.dtu.*;
import com.guodu.service.impl.equip.EquipInfoServiceImpl;
import com.guodu.service.impl.equip.EquipPhotoServiceImpl;
import com.guodu.service.impl.sys.SysSccjServiceImpl;
import com.guodu.util.FileHandleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UploadServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/3/3 5:48 下午
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private JlCtgyServiceImpl jlCtgyServiceImpl;
    @Autowired
    private JlCyjdServiceImpl jlCyjdServiceImpl;
    @Autowired
    private JlDlhlServiceImpl jlDlhlServiceImpl;
    @Autowired
    private JlDtuServiceImpl jlDtuServiceImpl;
    @Autowired
    private JlDyxnServiceImpl jlDyxnServiceImpl;
    @Autowired
    private JlGjcsServiceImpl jlGjcsServiceImpl;
    @Autowired
    private JlGncsServiceImpl jlGncsServiceImpl;
    @Autowired
    private JlHldzServiceImpl jlHldzServiceImpl;
    @Autowired
    private JlJydzServiceImpl jlJydzServiceImpl;
    @Autowired
    private JlKggServiceImpl jlKggServiceImpl;
    @Autowired
    private JlLpjyServiceImpl jlLpjyServiceImpl;
    @Autowired
    private JlWgpzServiceImpl jlWgpzServiceImpl;
    @Autowired
    private JlXbServiceImpl jlXbServiceImpl;
    @Autowired
    private JlYctsServiceImpl jlYctsServiceImpl;
    @Autowired
    private JlYktsServiceImpl jlYktsServiceImpl;
    @Autowired
    private JlYsbjServiceImpl jlYsbjServiceImpl;
    @Autowired
    private JbxxServiceImpl jbxxServiceImpl;
    @Autowired
    private EquipInfoServiceImpl equipInfoServiceImpl;
    @Autowired
    private JbxxGjdzServiceImpl jbxxGjdzServiceImpl;
    @Autowired
    private JbxxPhotoServiceImpl jbxxPhotoServiceImpl;
    @Autowired
    private JbxxBeizhuService jbxxBeizhuServiceImpl;
    @Autowired
    private EquipPhotoServiceImpl equipPhotoServiceImpl;
    @Autowired
    private SysSccjServiceImpl sysSccjServiceImpl;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void uploadJl(Jbxx jbxx) {
        if (jbxx != null) {
            jbxxServiceImpl.insert(jbxx);
            //上传时添加设备信息
            EquipInfo equip = new EquipInfo();
            equip.setSbid(jbxx.getTsid());
            equip.setSsqy(jbxx.getSsqy());
            equip.setAzddDdh(jbxx.getAzddDdh());
            equip.setZdmc(jbxx.getZdmc());
            equip.setSsxl(jbxx.getSsxl());
            equip.setTxmkcj(jbxx.getTsryxm());
            equip.setIpdz(jbxx.getIpdz());
            equip.setWlwkh(jbxx.getWlwkh());
            equip.setRtudz(jbxx.getRtudz());
            equip.setDkh(jbxx.getDkh());
            equip.setSccs(jbxx.getSccs());
            equip.setScrq(new SimpleDateFormat("yyyy-MM-dd").format(jbxx.getScrq()));
            equip.setZbxh(jbxx.getZzxh());
            equip.setZbbh(jbxx.getZzbh());
            equip.setZzlx(jbxx.getZzlx());
            equip.setRjbbJym(jbxx.getRjbbJym());
            equip.setYjbb(jbxx.getYjbb());
            equip.setSccsYcg(jbxx.getSccsYcg());
            equip.setZbxhYcg(jbxx.getZbxhYcg());
            equip.setTsryxmYcg(jbxx.getTsryxmYcg());
            equip.setSccsYs(jbxx.getSccsYs());
            equip.setZbxhYs(jbxx.getZbxhYs());
            equip.setTsryxmYs(jbxx.getTsryxmYs());
            equip.setSccsXf(jbxx.getSccsXf());
            equip.setZbxhXf(jbxx.getZbxhXf());
            equip.setTsryxmXf(jbxx.getTsryxmXf());
            equip.setJd(jbxx.getJd());
            equip.setWd(jbxx.getWd());
            equip.setXxwz(jbxx.getXxwz());
            equip.setCzr(jbxx.getCzr());
            equip.setCzsj(jbxx.getCzsj());
            equip.setBeizhu(jbxx.getBeizhu());
            EquipInfo oldEquip = equipInfoServiceImpl.selectByPrimaryKey(jbxx.getTsid());
            if(oldEquip != null){
                equipInfoServiceImpl.edit(equip);
            }else{
                equipInfoServiceImpl.add(equip);
            }
            //添加未保存的模块厂家
            String txmkcj = jbxx.getTxmkcj() == null?"":jbxx.getTxmkcj();
            if(!txmkcj.equals("")) sysSccjServiceImpl.addCjmcByName(txmkcj);

            //DTU生产厂商
            String sccs = jbxx.getSccs() == null?"":jbxx.getSccs();
            if(!sccs.equals("")) sysSccjServiceImpl.addCjmcByName(sccs);
            //一次柜生产厂商
            String sccsYcg = jbxx.getSccsYcg() == null?"":jbxx.getSccsYcg();
            if(!sccsYcg.equals("")) sysSccjServiceImpl.addCjmcByName(sccsYcg);
            //溢水生产厂商
            String sccsYs = jbxx.getSccsYs() == null?"":jbxx.getSccsYs();
            if(!sccsYs.equals("")) sysSccjServiceImpl.addCjmcByName(sccsYs);
            //消防生产厂商
            String sccsXf = jbxx.getSccsXf() == null?"":jbxx.getSccsXf();
            if(!sccsXf.equals("")) sysSccjServiceImpl.addCjmcByName(sccsXf);

            // 删除原记录
            jlCtgyServiceImpl.deleteByTsid(jbxx.getTsid());
            // 插入新纪录
            if (jbxx.getJlCtgys().size() != 0) {
                jlCtgyServiceImpl.batchInsert(jbxx.getJlCtgys());
            }
            jlCyjdServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlCyjds().size() != 0) {
                jlCyjdServiceImpl.batchInsert(jbxx.getJlCyjds());
            }
            jlDlhlServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlDlhls().size() != 0) {
                jlDlhlServiceImpl.batchInsert(jbxx.getJlDlhls());
            }
            jlDtuServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlDtu() != null) {
                jlDtuServiceImpl.insert(jbxx.getJlDtu());
            }
            jlDyxnServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlDyxns().size() != 0) {
                jlDyxnServiceImpl.batchInsert(jbxx.getJlDyxns());
            }
            jlGjcsServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlGjcss().size() != 0) {
                jlGjcsServiceImpl.batchInsert(jbxx.getJlGjcss());
            }
            jlGncsServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlGncss().size() != 0) {
                jlGncsServiceImpl.batchInsert(jbxx.getJlGncss());
            }
            jlHldzServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlHldzs().size() != 0) {
                jlHldzServiceImpl.batchInsert(jbxx.getJlHldzs());
            }
            jlJydzServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlJydzs().size() != 0) {
                jlJydzServiceImpl.batchInsert(jbxx.getJlJydzs());
            }
            jlKggServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlKggs().size() != 0) {
                jlKggServiceImpl.batchInsert(jbxx.getJlKggs());
            }
            jlLpjyServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlLpjys().size() != 0) {
                jlLpjyServiceImpl.batchInsert(jbxx.getJlLpjys());
            }
            jlWgpzServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlWgpzs().size() != 0) {
                jlWgpzServiceImpl.batchInsert(jbxx.getJlWgpzs());
            }
            jlXbServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlXb() != null) {
                jlXbServiceImpl.insert(jbxx.getJlXb());
            }
            jlYctsServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlYctss().size() != 0) {
                jlYctsServiceImpl.batchInsert(jbxx.getJlYctss());
            }
            jlYktsServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlYktss().size() != 0) {
                jlYktsServiceImpl.batchInsert(jbxx.getJlYktss());
            }
            jlYsbjServiceImpl.deleteByTsid(jbxx.getTsid());
            if (jbxx.getJlYsbj() != null) {
                jlYsbjServiceImpl.insert(jbxx.getJlYsbj());
            }
            jbxxGjdzServiceImpl.deleteAllByTsid(jbxx.getTsid());
            if (jbxx.getJbxxGjdz() != null) {
                jbxxGjdzServiceImpl.deleteAllByTsid(jbxx.getTsid());
                jbxxGjdzServiceImpl.add(jbxx.getJbxxGjdz());
            }
            jbxxBeizhuServiceImpl.deleteByPrimaryKey(jbxx.getTsid());
            if (jbxx.getJbxxBeizhu() != null) {
                jbxxBeizhuServiceImpl.deleteByPrimaryKey(jbxx.getTsid());
                jbxxBeizhuServiceImpl.insert(jbxx.getJbxxBeizhu());
            }
        }
    }

    public void uploadJbxxFile(String tsid,List<Map<String,Object>> jbxxPhotos,String imgSavePath) throws Exception{
        Map<String,Object> jbxxPhoto = null;
        //删除磁盘原有文件
        Map vo = new HashMap();
        vo.put("tsid",tsid);
        List<JbxxPhoto> oldJbxxPhotos = jbxxPhotoServiceImpl.selectList(vo);
        for (JbxxPhoto oldJbxxPhoto:oldJbxxPhotos){
            FileHandleUtils.deleteFile(oldJbxxPhoto.getPPath());
        }
        //db中插入新的photo数据
        String path = "";
        for (int i = 0;i<jbxxPhotos.size();i++) {
            jbxxPhoto = jbxxPhotos.get(i);
            path = jbxxPhoto.get("P_PATH").toString();
            JbxxPhoto photo = new JbxxPhoto();
            photo.setPid(jbxxPhoto.get("PID").toString());
            photo.setTsid(jbxxPhoto.get("TSID").toString());
            photo.setPName(jbxxPhoto.get("P_NAME").toString());
            photo.setPPath(path.replaceFirst("client","admin"));
            jbxxPhotoServiceImpl.add(photo);
            EquipPhoto equipPhoto = new EquipPhoto();
            equipPhoto.setPid(jbxxPhoto.get("PID").toString());
            equipPhoto.setSbid(jbxxPhoto.get("TSID").toString());
            equipPhoto.setPName(jbxxPhoto.get("P_NAME").toString());
            equipPhoto.setPPath(path.replaceFirst("client","admin"));
            equipPhotoServiceImpl.add(equipPhoto);
        }
        //删除db中相应photo记录
        for (JbxxPhoto oldJbxxPhoto:oldJbxxPhotos){
            jbxxPhotoServiceImpl.delete(oldJbxxPhoto.getPid());
        }
    }

    public void deleteJlByJbxx(String tsid) {
        jlCtgyServiceImpl.deleteByTsid(tsid);
        jlCyjdServiceImpl.deleteByTsid(tsid);
        jlDlhlServiceImpl.deleteByTsid(tsid);
        jlDtuServiceImpl.deleteByTsid(tsid);
        jlDyxnServiceImpl.deleteByTsid(tsid);
        jlGjcsServiceImpl.deleteByTsid(tsid);
        jlGncsServiceImpl.deleteByTsid(tsid);
        jlHldzServiceImpl.deleteByTsid(tsid);
        jlJydzServiceImpl.deleteByTsid(tsid);
        jlKggServiceImpl.deleteByTsid(tsid);
        jlLpjyServiceImpl.deleteByTsid(tsid);
        jlWgpzServiceImpl.deleteByTsid(tsid);
        jlXbServiceImpl.deleteByTsid(tsid);
        jlYctsServiceImpl.deleteByTsid(tsid);
        jlYktsServiceImpl.deleteByTsid(tsid);
        jlYsbjServiceImpl.deleteByTsid(tsid);
    }
}
