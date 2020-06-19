package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlJydz
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:33 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JlJydz implements Serializable {
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
     * 被测回路
     */
    private String bchl;

    /**
     * 试验电压（伏）
     */
    private String sydy;

    /**
     * 规程要求(兆欧）
     */
    private String gcyq;

    /**
     * 测量阻值（兆欧）
     */
    private String clzz;

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