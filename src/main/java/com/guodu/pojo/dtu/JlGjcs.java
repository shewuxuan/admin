package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlGjcs
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/21 4:45 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JlGjcs implements Serializable {
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
     * 间隔
     */
    private String jg;

    /**
     * 告警类型
     */
    private String gjlx;

    /**
     * A相（0.95倍, 4.75A）
     */
    private String a1;

    /**
     * A相（1.05倍, 5.25A)
     */
    private String a2;

    /**
     * B相（0.95倍, 4.75A）
     */
    private String b1;

    /**
     * B相（1.05倍, 5.25A)
     */
    private String b2;

    /**
     * C相（0.95倍, 4.75A）
     */
    private String c1;

    /**
     * C相（1.05倍, 5.25A）
     */
    private String c2;

    /**
     * 零序（0.95倍, 0.95A）
     */
    private String l1;

    /**
     * 零序（1.05倍, 1.05A）
     */
    private String l2;

    /**
     * 测试结果1
     */
    private String csjg1;

    /**
     * 测试结果2
     */
    private String csjg2;

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