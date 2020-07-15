package com.guodu.pojo.ftu;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: FtuBzGjts
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/7/15 5:09 下午
 */

/**
 * 告警调试标准
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
     * 测试项
     */
    private String csx;

    private static final long serialVersionUID = 1L;
}