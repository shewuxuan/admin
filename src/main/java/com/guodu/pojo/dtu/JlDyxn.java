package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlDyxn
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/20 1:26 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JlDyxn implements Serializable {
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
     * 测试项目
     */
    private String csxm;

    /**
     * 技术标准或测试要求
     */
    private String jsbz;

    /**
     * 检测结果
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