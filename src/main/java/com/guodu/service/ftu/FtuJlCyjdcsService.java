package com.guodu.service.ftu;

import com.guodu.pojo.ftu.FtuJlCyjdcs;

import java.util.List;

/**
* @ClassName: FtuJlCyjdcsService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/5/12 2:04 下午
*/
public interface FtuJlCyjdcsService{


int deleteByPrimaryKey(String id);

int insert(FtuJlCyjdcs record);

int insertOrUpdate(FtuJlCyjdcs record);

int insertOrUpdateSelective(FtuJlCyjdcs record);

int insertSelective(FtuJlCyjdcs record);

FtuJlCyjdcs selectByPrimaryKey(String id);

int updateByPrimaryKeySelective(FtuJlCyjdcs record);

int updateByPrimaryKey(FtuJlCyjdcs record);

List<FtuJlCyjdcs> selectByAll(FtuJlCyjdcs ftuJlCyjdcs);

int updateBatch(List<FtuJlCyjdcs> list);

int updateBatchSelective(List<FtuJlCyjdcs> list);

int batchInsert(List<FtuJlCyjdcs> list);

}
