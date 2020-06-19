package com.guodu.service.ftu;

import com.guodu.pojo.ftu.FtuJlCyjd;

import java.util.List;

/**
* @ClassName: FtuJlCyjdService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/5/12 2:03 下午
*/
public interface FtuJlCyjdService{


int deleteByPrimaryKey(String id);

int insert(FtuJlCyjd record);

int insertOrUpdate(FtuJlCyjd record);

int insertOrUpdateSelective(FtuJlCyjd record);

int insertSelective(FtuJlCyjd record);

FtuJlCyjd selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(FtuJlCyjd record);

int updateByPrimaryKey(FtuJlCyjd record);

List<FtuJlCyjd> selectByAll(FtuJlCyjd ftuJlCyjd);

int updateBatch(List<FtuJlCyjd> list);

int updateBatchSelective(List<FtuJlCyjd> list);

int batchInsert(List<FtuJlCyjd> list);

}
