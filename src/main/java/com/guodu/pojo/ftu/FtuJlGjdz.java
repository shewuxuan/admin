package com.guodu.pojo.ftu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName: FtuJlGjdz
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:05 下午
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
    private BigDecimal gl1ddz;

    /**
    * 过流I段时间？秒
    */
    private BigDecimal gl1dsj;

    /**
    * 过流I段通电？秒
    */
    private BigDecimal gl1dtd;

    /**
    * 过流II段定值
    */
    private BigDecimal gl2ddz;

    /**
    * 过流II段时间？秒
    */
    private BigDecimal gl2dsj;

    /**
    * 过流II段通电？秒
    */
    private BigDecimal gl2dtd;

    /**
    * 零序I段定值
    */
    private BigDecimal lx1ddz;

    /**
    * 零序I段时间？秒
    */
    private BigDecimal lx1dsj;

    /**
    * 零序I段通电？秒
    */
    private BigDecimal lx1dtd;

    /**
    * 零序II段定值
    */
    private BigDecimal lx2ddz;

    /**
    * 零序II段时间？秒
    */
    private BigDecimal lx2dsj;

    /**
    * 零序II段通电？秒
    */
    private BigDecimal lx2dtd;

    private static final long serialVersionUID = 1L;
}