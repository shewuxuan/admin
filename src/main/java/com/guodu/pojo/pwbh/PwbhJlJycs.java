package com.guodu.pojo.pwbh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: PwbhJlJycs
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/18 2:52 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwbhJlJycs implements Serializable {
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
     * 检查内容
     */
    private String jcnr;

    /**
     * 标准
     */
    private String bz;

    /**
     * 试验结果
     */
    private String syjg;

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