package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlHldz
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:33 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JlHldz implements Serializable {
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
     * 回路
     */
    private String hl;

    /**
     * 装置侧
     */
    private String zzc;

    /**
     * CT侧
     */
    private String ctc;

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