package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlBhctbh;

import java.util.List;

/**
* @ClassName: PwbhJlBhctbhService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/6/11 4:02 下午
*/
public interface PwbhJlBhctbhService{


int deleteByPrimaryKey(String id);

int insert(PwbhJlBhctbh record);

int insertSelective(PwbhJlBhctbh record);

PwbhJlBhctbh selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(PwbhJlBhctbh record);

int updateByPrimaryKey(PwbhJlBhctbh record);

List<PwbhJlBhctbh> selectByAll(PwbhJlBhctbh pwbhJlBhctbh);

int updateBatch(List<PwbhJlBhctbh> list);

int updateBatchSelective(List<PwbhJlBhctbh> list);

int batchInsert(List<PwbhJlBhctbh> list);

}
