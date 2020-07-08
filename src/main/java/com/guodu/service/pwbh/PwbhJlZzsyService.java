package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlZzsy;

import java.util.List;

/**
* @ClassName: PwbhJlZzsyService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/6/15 4:20 下午
*/
public interface PwbhJlZzsyService{


int deleteByPrimaryKey(String id);

int insert(PwbhJlZzsy record);

int insertSelective(PwbhJlZzsy record);

PwbhJlZzsy selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(PwbhJlZzsy record);

int updateByPrimaryKey(PwbhJlZzsy record);

List<PwbhJlZzsy> selectByAll(PwbhJlZzsy pwbhJlZzsy);

int updateBatch(List<PwbhJlZzsy> list);

int updateBatchSelective(List<PwbhJlZzsy> list);

int batchInsert(List<PwbhJlZzsy> list);

}
