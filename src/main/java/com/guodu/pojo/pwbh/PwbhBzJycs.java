package com.guodu.pojo.pwbh;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: PwbhBzJycs
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/18 1:47 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwbhBzJycs implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 所属区域
     */
    private String ssqy;

    /**
     * 检查内容
     */
    private String jcnr;

    /**
     * 标准
     */
    private String bz;

    /**
     * 所属区域名
     */
    private String ssqyname;

    private static final long serialVersionUID = 1L;
}