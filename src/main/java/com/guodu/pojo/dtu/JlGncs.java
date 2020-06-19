package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlGncs
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:33 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JlGncs implements Serializable {
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