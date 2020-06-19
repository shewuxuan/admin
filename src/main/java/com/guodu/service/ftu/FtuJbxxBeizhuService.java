package com.guodu.service.ftu;

import com.guodu.pojo.ftu.FtuJbxxBeizhu;

import java.util.List;

/**
* @ClassName: FtuJbxxBeizhuService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/5/14 10:46 上午
*/
public interface FtuJbxxBeizhuService {


int deleteByPrimaryKey(String tsid);

int insert(FtuJbxxBeizhu record);

int insertOrUpdate(FtuJbxxBeizhu record);

int insertOrUpdateSelective(FtuJbxxBeizhu record);

int insertSelective(FtuJbxxBeizhu record);

FtuJbxxBeizhu selectByPrimaryKey(String tsid);

int updateByPrimaryKeySelective(FtuJbxxBeizhu record);

int updateByPrimaryKey(FtuJbxxBeizhu record);

int updateBatch(List<FtuJbxxBeizhu> list);

int updateBatchSelective(List<FtuJbxxBeizhu> list);

int batchInsert(List<FtuJbxxBeizhu> list);

}
