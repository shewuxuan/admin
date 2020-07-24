package com.guodu.pojo.sys;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: SysSsxl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/25 10:53 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysSsxl implements Serializable {
    private String id;

    /**
     * 所属区域
     */
    private String ssqy;

    /**
     * 变电站
     */
    private String bdz;

    /**
     * 线路名称
     */
    private String xlmc;

    /**
     * 行运单位
     */
    private String yxdw;

    private static final long serialVersionUID = 1L;
}