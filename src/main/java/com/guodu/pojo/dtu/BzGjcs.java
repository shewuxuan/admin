package com.guodu.pojo.dtu;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: BzGjcs
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/22 4:22 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzGjcs implements Serializable {
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
     * 告警类型
     */
    private String gjlx;

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