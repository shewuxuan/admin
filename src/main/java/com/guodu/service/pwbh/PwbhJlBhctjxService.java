package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlBhctjx;

import java.util.List;

/**
* @ClassName: PwbhJlBhctjxService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/6/11 4:02 下午
*/
public interface PwbhJlBhctjxService{


int deleteByPrimaryKey(String id);

int insert(PwbhJlBhctjx record);

int insertSelective(PwbhJlBhctjx record);

PwbhJlBhctjx selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(PwbhJlBhctjx record);

int updateByPrimaryKey(PwbhJlBhctjx record);

List<PwbhJlBhctjx> selectByAll(PwbhJlBhctjx pwbhJlBhctjx);

int updateBatch(List<PwbhJlBhctjx> list);

int updateBatchSelective(List<PwbhJlBhctjx> list);

int batchInsert(List<PwbhJlBhctjx> list);

}
