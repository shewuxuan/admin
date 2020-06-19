package com.guodu.pojo.pwbh;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: PwbhBzDzjc
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:58 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwbhBzDzjc implements Serializable {
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

    private static final long serialVersionUID = 1L;
}