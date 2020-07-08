package com.guodu.pojo.pwbh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: PwbhJlZzsy
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/15 4:20 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwbhJlZzsy implements Serializable {
    /**
    * ID
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
    * 断路器
    */
    private String dlq;

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