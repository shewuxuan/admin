package com.guodu.pojo.pwbh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: PwbhJbxxBeizhu
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:01 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwbhJbxxBeizhu implements Serializable {
    /**
    * 调试Id
    */
    private String tsid;

    /**
    * 外观检查
    */
    private String pwbhJlWgjc;

    /**
    * 紧线对线
    */
    private String pwbhJlJxdx;

    /**
    * 绝缘测试
    */
    private String pwbhJlJycs;

    /**
    * 零漂校验
    */
    private String pwbhJlLpjy;

    /**
    * 精度检验
    */
    private String pwbhJlJdjy;

    /**
    * 保护CT极性
    */
    private String pwbhJlBhctjx;

    /**
    * 保护CT变化
    */
    private String pwbhJlBhctbh;

    /**
    * 定值检查
    */
    private String pwbhJlDzjc;

    /**
    * 整组试验
    */
    private String pwbhJlZzsy;

    /**
    * 保护CT回路
    */
    private String pwbhJlBhcthl;

    /**
    * 收工前检查
    */
    private String pwbhJlSgjc;

    /**
    * 校对时钟检查结果
    */
    private String szjcjg;

    private static final long serialVersionUID = 1L;
}