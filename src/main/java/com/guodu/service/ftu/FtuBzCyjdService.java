package com.guodu.service.ftu;

import java.util.List;

import com.guodu.pojo.ftu.FtuBzCyjd;

/**
 * @ClassName: FtuBzCyjdService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:16 下午
 */
public interface FtuBzCyjdService {


    int deleteByPrimaryKey(String id);

    int insert(FtuBzCyjd record);

    int insertSelective(FtuBzCyjd record);

    FtuBzCyjd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuBzCyjd record);

    int updateByPrimaryKey(FtuBzCyjd record);

    List<FtuBzCyjd> selectByAll(FtuBzCyjd ftuBzCyjd);

    int updateBatch(List<FtuBzCyjd> list);

    int batchInsert(List<FtuBzCyjd> list);

    List<FtuBzCyjd> selectByPage(FtuBzCyjd record);
}

