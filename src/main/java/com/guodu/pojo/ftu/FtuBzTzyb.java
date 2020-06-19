package com.guodu.pojo.ftu;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: FtuBzTzyb
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:22 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuBzTzyb implements Serializable {
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
    * 检验项目
    */
    private String jyxm;

    /**
    * 故障模拟
    */
    private String gzmn;

    private static final long serialVersionUID = 1L;
}