package com.guodu.pojo.dtu;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: BzWgpz
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:41 上午
 */
@Data
@NoArgsConstructor
public class BzWgpz implements Serializable {
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
     * 测试项目
     */
    private String csxm;

    /**
     * 技术标准/测试要求
     */
    private String csyq;

    private static final long serialVersionUID = 1L;
}