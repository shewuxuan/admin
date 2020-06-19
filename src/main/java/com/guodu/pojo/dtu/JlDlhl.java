package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlDlhl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:32 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JlDlhl implements Serializable {
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
     * 测试功能
     */
    private String csgn;

    /**
     * 测试方法
     */
    private String csff;

    /**
     * A(30A)
     */
    private String a;

    /**
     * B(30A)
     */
    private String b;

    /**
     * C(30A)
     */
    private String c;

    /**
     * 零序（20A）
     */
    private String lx;

    /**
     * 测试结果
     */
    private String csjg;

    /**
     * 操作人
     */
    private String czr;

    /**
     * 测试时间
     */
    private Date czsj;

    /**
     * 备注
     */
    private String beizhu;

    private static final long serialVersionUID = 1L;
}