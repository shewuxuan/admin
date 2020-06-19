package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: BzJydz
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:39 上午
 */
@Data
@NoArgsConstructor
public class BzJydz implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 所属区域
     */
    private String ssqy;

    /**
     * 所属区域名
     */
    private String ssqyname;

    /**
     * 北侧回路
     */
    private String bchl;

    /**
     * 试验电压（伏）
     */
    private String sydy;

    private static final long serialVersionUID = 1L;
}