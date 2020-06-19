package com.guodu.pojo.ftu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: FtuJlCyjdcs
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:04 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuJlCyjdcs implements Serializable {
    /**
    * 记录Id
    */
    private String id;

    /**
    * 调试Id
    */
    private String tsid;

    /**
    * 所属区域
    */
    private String ssqy;

    /**
    * 测量项（额定值）
    */
    private String clx;

    /**
    * IA
    */
    private BigDecimal ia;

    /**
    * IC
    */
    private BigDecimal ic;

    /**
    * I0
    */
    private BigDecimal io;

    /**
    * 结果
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