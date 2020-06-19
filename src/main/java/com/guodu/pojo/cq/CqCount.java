package com.guodu.pojo.cq;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: CqCount
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 1:43 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CqCount implements Serializable {
    private String sbid;

    private String ssqy;

    private String ssqyname;

    private String ssxl;

    private String ssxlname;

    private String azddDdh;

    private Date cqrq;

    private Integer qx1;

    private Integer qx2;

    private Integer qx3;

    private Integer qx4;

    private Integer qx5;

    private Integer xTotal;

    private static final long serialVersionUID = 1L;
}