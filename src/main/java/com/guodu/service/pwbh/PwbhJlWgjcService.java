package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlWgjc;

import java.util.List;

/**
 * @ClassName: PwbhJlWgjcService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:04 下午
 */
public interface PwbhJlWgjcService {


    int deleteByPrimaryKey(String id);

    int insert(PwbhJlWgjc record);

    int insertSelective(PwbhJlWgjc record);

    PwbhJlWgjc selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhJlWgjc record);

    int updateByPrimaryKey(PwbhJlWgjc record);

    int updateBatch(List<PwbhJlWgjc> list);

    int updateBatchSelective(List<PwbhJlWgjc> list);

    int batchInsert(List<PwbhJlWgjc> list);

    List<PwbhJlWgjc> selectByAll(PwbhJlWgjc pwbhJlWgjc);
}

