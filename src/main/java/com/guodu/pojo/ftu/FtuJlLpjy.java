package com.guodu.pojo.ftu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: FtuJlLpjy
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:07 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuJlLpjy implements Serializable {
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
    * 回路
    */
    private String hl;

    /**
    * 装置读数
    */
    private BigDecimal zzds;

    /**
    * 检查结果
    */
    private String jcjg;

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