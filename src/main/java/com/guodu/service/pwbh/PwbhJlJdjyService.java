package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlJdjy;

import java.util.List;

/**
* @ClassName: PwbhJlJdjyService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/6/11 4:03 下午
*/
public interface PwbhJlJdjyService{


int deleteByPrimaryKey(String id);

int insert(PwbhJlJdjy record);

int insertSelective(PwbhJlJdjy record);

PwbhJlJdjy selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(PwbhJlJdjy record);

int updateByPrimaryKey(PwbhJlJdjy record);

List<PwbhJlJdjy> selectByAll(PwbhJlJdjy pwbhJlJdjy);

int updateBatch(List<PwbhJlJdjy> list);

int updateBatchSelective(List<PwbhJlJdjy> list);

int batchInsert(List<PwbhJlJdjy> list);

}
