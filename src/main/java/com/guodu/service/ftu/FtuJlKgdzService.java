package com.guodu.service.ftu;

import com.guodu.pojo.ftu.FtuJlKgdz;

import java.util.List;

/**
* @ClassName: FtuJlKgdzService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/5/12 2:07 下午
*/
public interface FtuJlKgdzService{


int deleteByPrimaryKey(String id);

int insert(FtuJlKgdz record);

int insertOrUpdate(FtuJlKgdz record);

int insertOrUpdateSelective(FtuJlKgdz record);

int insertSelective(FtuJlKgdz record);

FtuJlKgdz selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(FtuJlKgdz record);

int updateByPrimaryKey(FtuJlKgdz record);

List<FtuJlKgdz> selectByAll(FtuJlKgdz ftuJlKgdz);

int updateBatch(List<FtuJlKgdz> list);

int updateBatchSelective(List<FtuJlKgdz> list);

int batchInsert(List<FtuJlKgdz> list);

}
