package com.guodu.service.ftu;

import com.guodu.pojo.ftu.FtuJlYkcd;

import java.util.List;

/**
* @ClassName: FtuJlYkcdService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/5/12 2:08 下午
*/
public interface FtuJlYkcdService{


int deleteByPrimaryKey(String id);

int insert(FtuJlYkcd record);

int insertOrUpdate(FtuJlYkcd record);

int insertOrUpdateSelective(FtuJlYkcd record);

int insertSelective(FtuJlYkcd record);

FtuJlYkcd selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(FtuJlYkcd record);

int updateByPrimaryKey(FtuJlYkcd record);

List<FtuJlYkcd> selectByAll(FtuJlYkcd ftuJlYkcd);

int updateBatch(List<FtuJlYkcd> list);

int updateBatchSelective(List<FtuJlYkcd> list);

int batchInsert(List<FtuJlYkcd> list);

}
