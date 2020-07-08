package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlJxdx;

import java.util.List;

/**
* @ClassName: PwbhJlJxdxService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/6/11 4:03 下午
*/
public interface PwbhJlJxdxService{


int deleteByPrimaryKey(String id);

int insert(PwbhJlJxdx record);

int insertSelective(PwbhJlJxdx record);

PwbhJlJxdx selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(PwbhJlJxdx record);

int updateByPrimaryKey(PwbhJlJxdx record);

List<PwbhJlJxdx> selectByAll(PwbhJlJxdx pwbhJlJxdx);

int updateBatch(List<PwbhJlJxdx> list);

int updateBatchSelective(List<PwbhJlJxdx> list);

int batchInsert(List<PwbhJlJxdx> list);

}
