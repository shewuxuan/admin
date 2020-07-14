package com.guodu.service.ftu;

import com.guodu.pojo.ftu.FtuJlGjdz;

import java.util.List;

/**
* @ClassName: FtuJlGjdzService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/5/12 2:05 下午
*/
public interface FtuJlGjdzService{


int deleteByPrimaryKey(String id);

int insert(FtuJlGjdz record);

int insertSelective(FtuJlGjdz record);

FtuJlGjdz selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(FtuJlGjdz record);

int updateByPrimaryKey(FtuJlGjdz record);

List<FtuJlGjdz> selectByAll(FtuJlGjdz ftuJlGjdz);

int updateBatch(List<FtuJlGjdz> list);

int updateBatchSelective(List<FtuJlGjdz> list);

int batchInsert(List<FtuJlGjdz> list);

}
