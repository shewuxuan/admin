package com.guodu.service.ftu;

import com.guodu.pojo.ftu.FtuJlGjts;

import java.util.List;

/**
 * @ClassName: FtuJlGjtsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:05 下午
 */
public interface FtuJlGjtsService {


    int deleteByPrimaryKey(String id);

    int insert(FtuJlGjts record);

    int insertOrUpdate(FtuJlGjts record);

    int insertOrUpdateSelective(FtuJlGjts record);

    int insertSelective(FtuJlGjts record);

    FtuJlGjts selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuJlGjts record);

    int updateByPrimaryKey(FtuJlGjts record);

    List<FtuJlGjts> selectByAll(FtuJlGjts ftuJlGjts);

    int updateBatch(List<FtuJlGjts> list);

    int updateBatchSelective(List<FtuJlGjts> list);

    int batchInsert(List<FtuJlGjts> list);

}

