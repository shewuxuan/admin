package com.guodu.pojo.dtu;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: Jbxx
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/3/6 6:02 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jbxx implements Serializable {
    /**
     * 调试id（主键）
     */
    private String tsid;

    /**
     * 所属区域(石景山、朝阳等)
     */
    private String ssqy;

    /**
     * 所属区域名
     */
    private String ssqyName;

    /**
     * 调试时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tssj;

    /**
     * 安装地点及调度号
     */
    private String azddDdh;

    /**
     * IP地址
     */
    private String ipdz;

    /**
     * 物联网卡号
     */
    private String wlwkh;

    /**
     * RTU地址
     */
    private String rtudz;

    /**
     * 端口号
     */
    private String dkh;

    /**
     * 生产厂商
     */
    private String sccs;

    /**
     * 生产日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date scrq;

    /**
     * 装置型号
     */
    private String zzxh;

    /**
     * 装置编号
     */
    private String zzbh;

    /**
     * 装置类型（1开闭器；2分界室；3箱变；4配电室）
     */
    private String zzlx;

    /**
     * 装置类型名（1开闭器；2分界室；3箱变；4配电室）
     */
    private String zzlxName;

    /**
     * 软件版本及校验码
     */
    private String rjbbJym;

    /**
     * 硬件版本
     */
    private String yjbb;

    /**
     * 调试人员姓名
     */
    private String tsryxm;

    /**
     * 0未上传; 1已上传
     */
    private String upload;

    /**
     * 操作人
     */
    private String czr;

    /**
     * 操作时间
     */
    private Date czsj;

    /**
     * 备注
     */
    private String beizhu;
    private String zdmc;//终端名称
    private String ssxl;//所属线路
    private String txmkcj;//通信模块厂家
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
    private List<JbxxPhoto> photo;

    private List<JlCtgy> jlCtgys;
    private List<JlCyjd> jlCyjds;
    private List<JlDlhl> jlDlhls;
    private JlDtu jlDtu;
    private List<JlDyxn> jlDyxns;
    private List<JlGjcs> jlGjcss;
    private List<JlGncs> jlGncss;
    private List<JlHldz> jlHldzs;
    private List<JlJydz> jlJydzs;
    private List<JlKgg> jlKggs;
    private List<JlLpjy> jlLpjys;
    private List<JlWgpz> jlWgpzs;
    private JlXb jlXb;
    private List<JlYcts> jlYctss;
    private List<JlYkts> jlYktss;
    private JlYsbj jlYsbj;

    private JbxxGjdz jbxxGjdz;
    private JbxxBeizhu jbxxBeizhu;

    private static final long serialVersionUID = 1L;
}