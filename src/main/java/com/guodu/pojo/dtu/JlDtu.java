package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JlDtu
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/11 4:44 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JlDtu implements Serializable {
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
     * 远方
     */
    private String yf;

    /**
     * 就地
     */
    private String jd;

    /**
     * 电池欠压
     */
    private String dcqy;

    /**
     * 电池活化
     */
    private String dchh;

    /**
     * 交流失电
     */
    private String jlsd;

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