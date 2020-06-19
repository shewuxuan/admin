package com.guodu.pojo.ftu;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: FtuBzTyjc
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:22 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuBzTyjc implements Serializable {
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
    * 检查项目
    */
    private String jcxm;

    private static final long serialVersionUID = 1L;
}