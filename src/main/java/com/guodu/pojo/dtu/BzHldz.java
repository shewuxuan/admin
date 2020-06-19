package com.guodu.pojo.dtu;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: BzHldz
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:39 上午
 */
@Data
@NoArgsConstructor
public class BzHldz implements Serializable {
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
     * 间隔
     */
    private String jg;

    /**
     * 回路
     */
    private String hl;

    /**
     * 装置类型,多个装置类型逗号隔开
     */
    private String zzlx;

    /**
     * 装置类型,多个装置类型逗号隔开
     */
    private String zzlxname;

    private static final long serialVersionUID = 1L;
}