package com.guodu.pojo.ftu;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: FtuJlGjdz
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/7/14 3:35 下午
 */

/**
 * 告警定值表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuJlGjdz implements Serializable {
    /**
     * 记录ID
     */
    private String id;

    /**
     * 过流I段定值
     */
    private String gl1ddz;

    /**
     * 过流I段时间？秒
     */
    private String gl1dsj;

    /**
     * 过流I段通电？秒
     */
    private String gl1dtd;

    /**
     * 过流II段定值
     */
    private String gl2ddz;

    /**
     * 过流II段时间？秒
     */
    private String gl2dsj;

    /**
     * 过流II段通电？秒
     */
    private String gl2dtd;

    /**
     * 零序I段定值
     */
    private String lx1ddz;

    /**
     * 零序I段时间？秒
     */
    private String lx1dsj;

    /**
     * 零序I段通电？秒
     */
    private String lx1dtd;

    /**
     * 零序II段定值
     */
    private String lx2ddz;

    /**
     * 零序II段时间？秒
     */
    private String lx2dsj;

    private String lx22;

    private String lx21;

    private String lx2;

    private String lx12;

    private String lx11;

    private String lx1;

    /**
     * 零序II段通电？秒
     */
    private String lx2dtd;

    private static final long serialVersionUID = 1L;
}