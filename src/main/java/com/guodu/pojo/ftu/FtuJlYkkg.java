package com.guodu.pojo.ftu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: FtuJlYkkg
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:08 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtuJlYkkg implements Serializable {
    /**
    * 记录Id
    */
    private String id;

    /**
    * 调试Id
    */
    private String tsid;

    /**
    * 所属区域
    */
    private String ssqy;

    /**
    * 遥控分
    */
    private String ykf;

    /**
    * 检查结果
    */
    private String jcjgYkf;

    /**
    * 遥控合
    */
    private String ykh;

    /**
    * 检查结果
    */
    private String jcjgYkh;

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