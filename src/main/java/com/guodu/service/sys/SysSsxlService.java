package com.guodu.service.sys;

import com.guodu.pojo.sys.SysSsxl;

import java.util.List;

/**
 * @ClassName: SysSsxlService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/22 5:14 下午
 */
public interface SysSsxlService {


    SysSsxl selectByPrimaryKey(String id);

    List<SysSsxl> selectByAll(SysSsxl record);

    List<SysSsxl> selectByGroup(SysSsxl sysSsxl, String groupBy);
}

