package com.guodu.service.dtu;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzCyjd;

/**
 * @ClassName: BzCyjdService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:22 上午
 */
public interface BzCyjdService {


    int deleteByPrimaryKey(String id);

    int insert(BzCyjd record);

    int insertSelective(BzCyjd record);

    BzCyjd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzCyjd record);

    int updateByPrimaryKey(BzCyjd record);

    List<BzCyjd> selectByAll(BzCyjd bzCyjd);

    int updateBatch(List<BzCyjd> list);

    int batchInsert(List<BzCyjd> list);

    int updateBatchSelective(List<BzCyjd> list);

    List<BzCyjd> selectByPage(BzCyjd record);
}

