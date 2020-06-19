package com.guodu.pojo.ftu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: FtuJlHbdy
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:06 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuJlHbdy implements Serializable {
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
    * 检查内容
    */
    private String jcnr;

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