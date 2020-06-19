package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlYkts
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:35 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JlYkts implements Serializable {
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
     * 间隔
     */
    private String jg;

    /**
     * 遥控（分）
     */
    private String ykf;

    /**
     * 遥控（合）
     */
    private String ykh;

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