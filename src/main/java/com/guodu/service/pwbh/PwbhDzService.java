package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhDz;

import java.util.List;

/**
 * @ClassName: PwbhDzService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/29 1:09 下午
 */
public interface PwbhDzService {


    int deleteByPrimaryKey(String tsid);

    int insert(PwbhDz record);

    int insertSelective(PwbhDz record);

    PwbhDz selectByPrimaryKey(String tsid);

    int updateByPrimaryKeySelective(PwbhDz record);

    int updateByPrimaryKey(PwbhDz record);

    List<PwbhDz> selectByAll(PwbhDz pwbhDz);

    int updateBatch(List<PwbhDz> list);

    int updateBatchSelective(List<PwbhDz> list);

    int batchInsert(List<PwbhDz> list);
}


