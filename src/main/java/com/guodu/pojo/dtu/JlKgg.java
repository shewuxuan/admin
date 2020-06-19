package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlKgg
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:34 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JlKgg implements Serializable {
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
     * 手把（远方）
     */
    private String sbyf;

    /**
     * 手把（就地）
     */
    private String sbjd;

    /**
     * 地刀（分）
     */
    private String ddf;

    /**
     * 地刀（合）
     */
    private String ddh;

    /**
     * 开关（分）
     */
    private String kgf;

    /**
     * 开关（合）
     */
    private String kgh;

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