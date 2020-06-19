package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlYsbj
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/11 4:45 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JlYsbj implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 调试ID
     */
    private String tsid;

    /**
     * 所属区域
     */
    private String ssqy;

    /**
     * 高水位告警
     */
    private String gswgj;

    /**
     * 低水位告警
     */
    private String dswgj;

    /**
     * 水泵启动告警
     */
    private String sbqdgj;

    /**
     * 溢水装置异常
     */
    private String yszzyc;

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

    private static final long serialVersionUID = 1L;
}