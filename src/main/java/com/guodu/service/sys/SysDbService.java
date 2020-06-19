package com.guodu.service.sys;

import com.guodu.pojo.sys.SysDb;

import java.util.List;

/**
 * @ClassName: SysDbService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/15 5:07 下午
 */
public interface SysDbService {


    int insert(SysDb record);

    int insertSelective(SysDb record);

    List<SysDb> selectByAll(SysDb sysDb);

    int batchInsert(List<SysDb> list);

}



