package com.guodu.pojo.sys;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: SysDb
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/15 5:14 下午
 */
@Data
@NoArgsConstructor
public class SysDb implements Serializable {
    /**
     * 字典代码
     */
    private String keycode;

    /**
     * 值
     */
    private String keyvalue;

    /**
     * 说明
     */
    private String keymemo;

    /**
     * 类型
     */
    private String keytype;

    private static final long serialVersionUID = 1L;
}