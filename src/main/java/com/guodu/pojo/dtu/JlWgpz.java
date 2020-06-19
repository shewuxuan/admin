package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlWgpz
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/19 3:17 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JlWgpz implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 关联调试ID
     */
    private String tsid;

    /**
     * 所属区域(石景山、朝阳等)
     */
    private String ssqy;

    /**
     * 测试项目
     */
    private String csxm;

    /**
     * 技术标准/测试要求
     */
    private String csyq;

    /**
     * 测试结果
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