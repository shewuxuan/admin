package com.guodu.service.ftu;

import com.guodu.pojo.ftu.FtuJlYkkg;

import java.util.List;

/**
* @ClassName: FtuJlYkkgService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/5/12 2:08 下午
*/
public interface FtuJlYkkgService{


int deleteByPrimaryKey(String id);

int insert(FtuJlYkkg record);

int insertOrUpdate(FtuJlYkkg record);

int insertOrUpdateSelective(FtuJlYkkg record);

int insertSelective(FtuJlYkkg record);

FtuJlYkkg selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(FtuJlYkkg record);

int updateByPrimaryKey(FtuJlYkkg record);

List<FtuJlYkkg> selectByAll(FtuJlYkkg ftuJlYkkg);

int updateBatch(List<FtuJlYkkg> list);

int updateBatchSelective(List<FtuJlYkkg> list);

int batchInsert(List<FtuJlYkkg> list);

}
