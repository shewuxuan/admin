package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlLpjy;

import java.util.List;

/**
 * @ClassName: PwbhJlLpjyService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:03 下午
 */
public interface PwbhJlLpjyService {


    int deleteByPrimaryKey(String id);

    int insert(PwbhJlLpjy record);

    int insertSelective(PwbhJlLpjy record);

    PwbhJlLpjy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhJlLpjy record);

    int updateByPrimaryKey(PwbhJlLpjy record);

    int updateBatch(List<PwbhJlLpjy> list);

    int updateBatchSelective(List<PwbhJlLpjy> list);

    int batchInsert(List<PwbhJlLpjy> list);

    List<PwbhJlLpjy> selectByAll(PwbhJlLpjy pwbhJlLpjy);
}

