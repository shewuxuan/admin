package com.guodu.pojo.ftu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: FtuJlGncs
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:06 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuJlGncs implements Serializable {
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
    * 测试功能
    */
    private String csgn;

    /**
    * 技术标准或测试要求
    */
    private String jsbz;

    /**
    * 结果
    */
    private String jg;

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