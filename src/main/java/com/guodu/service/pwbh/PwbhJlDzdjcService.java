package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlDzdjc;

import java.util.List;

/**
* @ClassName: PwbhJlDzdjcService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/6/11 4:02 下午
*/
public interface PwbhJlDzdjcService{


int deleteByPrimaryKey(String id);

int insert(PwbhJlDzdjc record);

int insertSelective(PwbhJlDzdjc record);

PwbhJlDzdjc selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(PwbhJlDzdjc record);

int updateByPrimaryKey(PwbhJlDzdjc record);

List<PwbhJlDzdjc> selectByAll(PwbhJlDzdjc pwbhJlDzdjc);

int updateBatch(List<PwbhJlDzdjc> list);

int updateBatchSelective(List<PwbhJlDzdjc> list);

int batchInsert(List<PwbhJlDzdjc> list);

}
