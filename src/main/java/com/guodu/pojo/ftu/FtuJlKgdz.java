package com.guodu.pojo.ftu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: FtuJlKgdz
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:07 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuJlKgdz implements Serializable {
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
    * 定值单号
    */
    private String dzdh;

    /**
    * 过流1段1
    */
    private String g11;

    /**
    * 过流1段2
    */
    private String g12;

    /**
    * 过流2段1
    */
    private String g21;

    /**
    * 过流2段2
    */
    private String g22;

    /**
    * 零序1段1
    */
    private String lx11;

    /**
    * 零序1段2
    */
    private String lx12;

    /**
    * 零序2段1
    */
    private String lx21;

    /**
    * 零序2段2
    */
    private String lx22;

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