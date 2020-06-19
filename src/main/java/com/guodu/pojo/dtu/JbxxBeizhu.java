package com.guodu.pojo.dtu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: JbxxBeizhu
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/29 12:22 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JbxxBeizhu implements Serializable {
    /**
     * 调试Id
     */
    private String tsid;

    /**
     * DTU外观测试记录
     */
    private String jlWgpz;

    /**
     * 绝缘电阻测试记录
     */
    private String jlJydz;

    /**
     * CT回路电阻测试记录
     */
    private String jlHldz;

    /**
     * 电源性能测试记录
     */
    private String jlDyxn;

    /**
     * 电流电压零漂校验
     */
    private String jlLpjy;

    /**
     * 采样经度测试
     */
    private String jlCyjd;

    /**
     * 模拟CT一次电流验证回路
     */
    private String jlDlhl;

    /**
     * 功能测试表
     */
    private String jlGncs;

    /**
     * CT安装工艺检查
     */
    private String jlCtgy;

    /**
     * 开关柜记录
     */
    private String jlKgg;

    /**
     * Dtu表
     */
    private String jlDtu;

    /**
     * 溢水报警表
     */
    private String jlYsbj;

    /**
     * 箱变表
     */
    private String jlXb;

    /**
     * 遥控功能调试表
     */
    private String jlYkts;

    /**
     * 遥测功能调试表
     */
    private String jlYcts;

    /**
     * 告警功能测试表
     */
    private String jlGjcs;

    public JbxxBeizhu(String tsid){
        this.tsid = tsid;
        this.jlWgpz = tsid;
        this.jlJydz = tsid;
        this.jlHldz = tsid;
        this.jlDyxn = tsid;
        this.jlLpjy = tsid;
        this.jlCyjd = tsid;
        this.jlDlhl = tsid;
        this.jlGncs = tsid;
        this.jlCtgy = tsid;
        this.jlKgg = tsid;
        this.jlDtu = tsid;
        this.jlYsbj = tsid;
        this.jlXb = tsid;
        this.jlYkts = tsid;
        this.jlYcts = tsid;
        this.jlGjcs = tsid;
    }

    private static final long serialVersionUID = 1L;
}