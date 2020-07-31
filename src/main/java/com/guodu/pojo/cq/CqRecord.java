package com.guodu.pojo.cq;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName: CqRecord
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/22 4:50 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CqRecord implements Serializable {
    /**
     * 处缺ID
     */
    private String cqid;

    /**
     * 设备ID
     */
    private String sbid;

    /**
     * 所属区域
     */
    private String ssqy;

    /**
     * 所属线路
     */
    private String ssxl;

    /**
     * 安装地点及调度号
     */
    private String azddDdh;

    /**
     * 装置类型
     */
    private String zzlx;

    /**
     * 处缺日期
     */
    private Date cqrq;

    /**
     * 缺陷分类
     */
    private String qxfl;

    /**
     * 缺陷
     */
    private String qx;

    /**
     * 处缺记录
     */
    private String cqjl;

    /**
     * 处缺结果
     */
    private String cqjg;

    /**
     * 处缺人员
     */
    private String sgdw;

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
     * 所属区域名称
     */
    private String ssqyname;

    /**
     * 装置类型名称
     */
    private String zzlxname;

    /**
     * 单位
     */
    private String yxdw;

    /**
     * 变电站
     */
    private String bdz;

    /**
     * 线路名称
     */
    private String xlmc;

    /**
     * 缺陷分类名称
     */
    private String qxflname;

    /**
     * 开始处缺日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startCqrq;

    /**
     * 结束处缺日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endCqrq;

    /**
     * 多列模糊查询
     */
    private String searchParam;

    private static final long serialVersionUID = 1L;
}