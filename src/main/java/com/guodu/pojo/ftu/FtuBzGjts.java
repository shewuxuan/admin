package com.guodu.pojo.ftu;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: FtuBzGjts
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:20 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuBzGjts implements Serializable {
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
    * 测试项
    */
    private String csx;

    /**
    * 不动作/动作
    */
    private String dz;

    private static final long serialVersionUID = 1L;
}