package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlBhcthl;

import java.util.List;

/**
* @ClassName: PwbhJlBhcthlService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/6/11 4:02 下午
*/
public interface PwbhJlBhcthlService{


int deleteByPrimaryKey(String id);

int insert(PwbhJlBhcthl record);

int insertSelective(PwbhJlBhcthl record);

PwbhJlBhcthl selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(PwbhJlBhcthl record);

int updateByPrimaryKey(PwbhJlBhcthl record);

List<PwbhJlBhcthl> selectByAll(PwbhJlBhcthl pwbhJlBhcthl);

int updateBatch(List<PwbhJlBhcthl> list);

int updateBatchSelective(List<PwbhJlBhcthl> list);

int batchInsert(List<PwbhJlBhcthl> list);

}
