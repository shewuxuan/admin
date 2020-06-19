package com.guodu.service.ftu;

import com.guodu.pojo.ftu.FtuJlHbdy;

import java.util.List;

/**
* @ClassName: FtuJlHbdyService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/5/12 2:06 下午
*/
public interface FtuJlHbdyService{


int deleteByPrimaryKey(String id);

int insert(FtuJlHbdy record);

int insertOrUpdate(FtuJlHbdy record);

int insertOrUpdateSelective(FtuJlHbdy record);

int insertSelective(FtuJlHbdy record);

FtuJlHbdy selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(FtuJlHbdy record);

int updateByPrimaryKey(FtuJlHbdy record);

List<FtuJlHbdy> selectByAll(FtuJlHbdy ftuJlHbdy);

int updateBatch(List<FtuJlHbdy> list);

int updateBatchSelective(List<FtuJlHbdy> list);

int batchInsert(List<FtuJlHbdy> list);

}
