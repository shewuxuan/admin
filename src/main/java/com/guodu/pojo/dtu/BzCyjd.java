package com.guodu.pojo.dtu;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: BzCyjd
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/22 3:45 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzCyjd implements Serializable {
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
     * 测量项（额定值）
     */
    private String clx;

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