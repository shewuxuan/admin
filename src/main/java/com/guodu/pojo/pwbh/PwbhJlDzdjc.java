package com.guodu.pojo.pwbh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: PwbhJlDzdjc
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:02 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwbhJlDzdjc implements Serializable {
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
    * 出单日期
    */
    private String cdrq;

    /**
    * 定值单号
    */
    private String dzdh;

    /**
    * 版本
    */
    private String bb;

    /**
    * 校验码
    */
    private String jym;

    /**
    * 程序形成时间
    */
    private String cxsj;

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