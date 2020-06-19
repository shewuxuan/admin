package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlYcts
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:34 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JlYcts implements Serializable {
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
     * 电压遥测1（100V）
     */
    private String ddyc1;

    /**
     * 电压遥测2（100V）
     */
    private String ddyc2;

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