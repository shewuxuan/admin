package com.guodu.pojo.dtu;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: BzCtgy
 * Function:  TODO
 * Date:      2020/1/17 4:22 下午
 *
 * @author 2Uli
 */
@Data
@NoArgsConstructor
public class BzCtgy implements Serializable {
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
     * 安装要求
     */
    private String azyq;

    private static final long serialVersionUID = 1L;
}