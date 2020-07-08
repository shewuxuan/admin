package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlSgjc;

import java.util.List;

/**
 * @ClassName: PwbhJlSgjcService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:04 下午
 */
public interface PwbhJlSgjcService {


    int deleteByPrimaryKey(String id);

    int insert(PwbhJlSgjc record);

    int insertSelective(PwbhJlSgjc record);

    PwbhJlSgjc selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhJlSgjc record);

    int updateByPrimaryKey(PwbhJlSgjc record);

    int updateBatch(List<PwbhJlSgjc> list);

    int updateBatchSelective(List<PwbhJlSgjc> list);

    int batchInsert(List<PwbhJlSgjc> list);

    List<PwbhJlSgjc> selectByAll(PwbhJlSgjc pwbhJlSgjc);
}

