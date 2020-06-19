package com.guodu.pojo.ftu;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: FtuBzCyjdcs
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:20 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuBzCyjdcs implements Serializable {
    /**
    * 标准Id
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
    * 测量项
    */
    private String clx;

    private static final long serialVersionUID = 1L;
}