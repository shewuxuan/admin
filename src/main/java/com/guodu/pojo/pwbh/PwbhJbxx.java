package com.guodu.pojo.pwbh;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PwbhJbxx implements Serializable {
    /* 基本信息表 */
    private String tsid;//调试ID
    private String ssqy;//所属区域
    private String tssj;//调试时间
    private String azddDdh;//安装地点及调度号
    private String ssxl;//所属线路
    private String lm;//路名
    private String gzfzr;//工作负责人
    private String gzry;//工作人员
    private String shr;//审核人
    private String czr;//操作人
    private Date czsj;//操作时间
    private String beizhu;//备注
    private String upload;

    /**
     * 所属区域名
     */
    private String ssqyname;

    /**
     * 变电站
     */
    private String bdz;

    /**
     * 线路名称
     */
    private String xlmc;
    private static final long serialVersionUID = 1L;
}
