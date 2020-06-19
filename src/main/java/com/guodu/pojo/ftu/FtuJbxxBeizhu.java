package com.guodu.pojo.ftu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: FtuJbxxBeizhu
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/14 10:46 上午
 */

/**
    * FTU记录备注表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuJbxxBeizhu implements Serializable {
    /**
    * 调试ID
    */
    private String tsid;

    /**
    * 采样精度测试(二次值)表
    */
    private String jlCyjd;

    /**
    * 采样精度测试(一次值)表
    */
    private String jlCyjdcs;

    /**
    * 告警调试表
    */
    private String jlGjts;

    /**
    * 功能测试表
    */
    private String jlGncs;

    /**
    * 后备电源表
    */
    private String jlHbdy;

    /**
    * 开关定值表
    */
    private String jlKgdz;

    /**
    * 电流电压零漂校验表
    */
    private String jlLpjy;

    /**
    * 投运前检查表
    */
    private String jlTyjc;

    /**
    * 跳闸压板表
    */
    private String jlTzyb;

    /**
    * 遥控传动表
    */
    private String jlYkcd;

    /**
    * 带开关遥控表
    */
    private String jlYkkg;

    private static final long serialVersionUID = 1L;
}