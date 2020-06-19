package com.guodu.pojo.equip;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class EquipInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sbid;//设备Id
    private String ssqy;//所属区域
    private String azddDdh;//安装地点及调度号
    private String zdmc;//终端名称
    private String ssxl;//所属线路
    private String txmkcj;//通信模块厂家
    private String ipdz;//IP地址
    private String wlwkh;//物联网卡号
    private String rtudz;//RTU地址
    private String dkh;//端口号
    private String sccs;//生产厂商（终端厂家
    private String scrq;//生产日期
    private String zbxh;//装置型号
    private String zbbh;//装置编号
    private String zzlx;//装置类型
    private String rjbbJym;//软件版本及校验码
    private String yjbb;//硬件版本
    private String sccsYcg;//一次柜生产厂商
    private String zbxhYcg;//一次柜装置型号
    private String tsryxmYcg;//一次柜调试人员姓名
    private String sccsYs;//溢水生产厂商
    private String zbxhYs;//溢水柜装置型号
    private String tsryxmYs;//溢水柜调试人员姓名
    private String sccsXf;//消防生产厂商
    private String zbxhXf;//消防装置型号
    private String tsryxmXf;//消防调试人员姓名
    private String jd;//经度
    private String wd;//纬度
    private String xxwz;//详细位置
    private String czr;//操作人
    private Date czsj;//操作时间
    private String beizhu;//备注
    private String flagArrayStr;//删除的pid
    private String[] imgName;//重置照片名称
    private List<EquipPhoto> photo;//编辑照片

    /**
     * 所属区域名
     */
    private String ssqyname;

    /**
     * 所属线路名
     */
    private String ssxlname;

    /**
     * 装置类型名
     */
    private String zzlxname;
}