package com.guodu.pojo.pwbh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: PwbhDz
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/30 1:39 下午
 */

/**
 * 定值表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwbhDz implements Serializable {
    /**
     * 调试Id
     */
    private String tsid;

    /**
     * 过流1段定值
     */
    private String g1;

    /**
     * 过流1段时间
     */
    private String g11;

    /**
     * 过流1段通电
     */
    private String g12;

    /**
     * 过流2段定值
     */
    private String g2;

    /**
     * 过流2段时间
     */
    private String g21;

    /**
     * 过流2段通电
     */
    private String g22;

    /**
     * 零序1段定值
     */
    private String l1;

    /**
     * 零序1段时间
     */
    private String l11;

    /**
     * 零序1段通电
     */
    private String l12;

    /**
     * 零序2段定值
     */
    private String l2;

    /**
     * 零序2段时间
     */
    private String l21;

    private String lx22;

    private String lx21;

    private String lx2;

    private String lx12;

    private String lx11;

    private String lx1;

    /**
     * 零序2段通电
     */
    private String l22;

    private static final long serialVersionUID = 1L;
}