package com.guodu.pojo.ftu;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: FtuJbxx
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/19 2:31 下午
 */

/**
 * FTU基本信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuJbxx implements Serializable {
    /**
     * 调试Id
     */
    private String tsid;

    /**
     * 所属区域
     */
    private String ssqy;

    /**
     * 调试时间
     */
    private Date tssj;

    /**
     * 调度编号
     */
    private String ddbh;

    /**
     * 线路名称
     */
    private String xlmc;

    /**
     * FTU编码
     */
    private String ftuBm;

    /**
     * 验收人员
     */
    private String ysry;

    /**
     * 验收日期
     */
    private Date ysrq;

    /**
     * 验收单位
     */
    private String ysdw;

    /**
     * 开关本体厂家
     */
    private String kgCj;

    /**
     * 开关本体型号
     */
    private String kgXh;

    /**
     * 开关本体生产日期
     */
    private Date kgScrq;

    /**
     * 相间CT变比
     */
    private String kgXjbb;

    /**
     * 零序CT变比
     */
    private String kgLxbb;

    /**
     * FTU厂家
     */
    private String ftuCj;

    /**
     * FTU型号
     */
    private String ftuXh;

    /**
     * FTU生产日期
     */
    private Date ftuScrq;

    /**
     * 通讯设备厂家
     */
    private String txsbCj;

    /**
     * 通讯设备型号
     */
    private String txsbXh;

    /**
     * 通讯设备生产日期
     */
    private Date txsbScrq;

    /**
     * 无线卡号
     */
    private String wxkh;

    /**
     * IP地址
     */
    private String ipdz;

    /**
     * 装置类型
     */
    private String zzlx;

    /**
     * 调试人员姓名
     */
    private String tsryxm;

    /**
     * 经度
     */
    private String jd;

    /**
     * 纬度
     */
    private String wd;

    /**
     * 详细位置
     */
    private String xxwz;

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

    /**
     * 是否上传 0未上传1上传
     */
    private String upload;

    private static final long serialVersionUID = 1L;
}