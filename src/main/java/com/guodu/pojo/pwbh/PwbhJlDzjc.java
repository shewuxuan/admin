package com.guodu.pojo.pwbh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: PwbhJlDzjc
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/30 1:38 下午
 */

/**
 * 定值检查记录表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwbhJlDzjc implements Serializable {
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
     * 过流1段整定值
     */
    private String g1;

    /**
     * 过流1段0.95倍定值
     */
    private String g11;

    /**
     * 过流1段1.05倍定值
     */
    private String g12;

    /**
     * 过流2段整定值
     */
    private String g2;

    /**
     * 过流2段0.95倍定值
     */
    private String g21;

    /**
     * 过流2段1.05倍定值
     */
    private String g22;

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