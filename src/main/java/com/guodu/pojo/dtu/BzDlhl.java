package com.guodu.pojo.dtu;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: BzDlhl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/22 3:59 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzDlhl implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 所属区域
     */
    private String ssqy;

    /**
     * 所属区域
     */
    private String ssqyname;

    /**
     * 间隔
     */
    private String jg;

    /**
     * 测试功能
     */
    private String csgn;

    /**
     * 测试方法
     */
    private String csff;

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