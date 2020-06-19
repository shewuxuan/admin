package com.guodu.service.ftu;

import com.guodu.pojo.ftu.FtuJlTyjc;

import java.util.List;

/**
* @ClassName: FtuJlTyjcService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/5/12 2:07 下午
*/
public interface FtuJlTyjcService{


int deleteByPrimaryKey(String id);

int insert(FtuJlTyjc record);

int insertOrUpdate(FtuJlTyjc record);

int insertOrUpdateSelective(FtuJlTyjc record);

int insertSelective(FtuJlTyjc record);

FtuJlTyjc selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(FtuJlTyjc record);

int updateByPrimaryKey(FtuJlTyjc record);

List<FtuJlTyjc> selectByAll(FtuJlTyjc ftuJlTyjc);

int updateBatch(List<FtuJlTyjc> list);

int updateBatchSelective(List<FtuJlTyjc> list);

int batchInsert(List<FtuJlTyjc> list);

}
