package com.guodu.pojo.pwbh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: PwbhJlYqyb
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:29 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwbhJlYqyb implements Serializable {
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
     * 试验仪器名称
     */
    private String yqmc;

    /**
     * 设备型号
     */
    private String sbxh;

    /**
     * 编号
     */
    private String bh;

    /**
     * 合格期限
     */
    private String hgqx;

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