package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlJycs;

import java.util.List;

/**
* @ClassName: PwbhJlJycsService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/6/11 4:03 下午
*/
public interface PwbhJlJycsService{


int deleteByPrimaryKey(String id);

int insert(PwbhJlJycs record);

int insertSelective(PwbhJlJycs record);

PwbhJlJycs selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(PwbhJlJycs record);

int updateByPrimaryKey(PwbhJlJycs record);

List<PwbhJlJycs> selectByAll(PwbhJlJycs pwbhJlJycs);

int updateBatch(List<PwbhJlJycs> list);

int updateBatchSelective(List<PwbhJlJycs> list);

int batchInsert(List<PwbhJlJycs> list);

}
