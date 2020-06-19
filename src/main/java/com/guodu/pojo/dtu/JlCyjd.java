package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlCyjd
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/19 3:17 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JlCyjd implements Serializable {
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
     * 测量项（额定值）
     */
    private String clx;

    /**
     * 额定值A
     */
    private String a;

    /**
     * 额定值B
     */
    private String b;

    /**
     * 额定值C
     */
    private String c;

    /**
     * 额定值零序
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
     * 操作时间
     */
    private Date czsj;

    /**
     * 备注
     */
    private String beizhu;

    private static final long serialVersionUID = 1L;
}