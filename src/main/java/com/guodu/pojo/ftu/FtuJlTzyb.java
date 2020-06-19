package com.guodu.pojo.ftu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: FtuJlTzyb
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:07 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuJlTzyb implements Serializable {
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
    * 检验项目
    */
    private String jyxm;

    /**
    * 故障模拟
    */
    private String gzmn;

    /**
    * 模拟断路器
    */
    private String mndl;

    /**
    * 主站信号
    */
    private String zzxh;

    /**
    * 装置显示
    */
    private String zzxs;

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