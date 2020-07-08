package com.guodu.pojo.pwbh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: PwbhJlJxdx
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:03 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwbhJlJxdx implements Serializable {
    /**
    * 主键
    */
    private String id;

    /**
    * 调试ID
    */
    private String tsid;

    /**
    * 所属区域
    */
    private String ssqy;

    /**
    * 内容
    */
    private String nr;

    /**
    * 检查结果
    */
    private String jcjg;

    /**
    * 操作人
    */
    private String czr;

    /**
    * 操作时间
    */
    private Date czsj;

    /**
    * 备注
    */
    private String beizhu;

    private static final long serialVersionUID = 1L;
}