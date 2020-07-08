package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlDzjc;

import java.util.List;

/**
 * @ClassName: PwbhJlDzjcService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:03 下午
 */
public interface PwbhJlDzjcService {


    int deleteByPrimaryKey(String id);

    int insert(PwbhJlDzjc record);

    int insertSelective(PwbhJlDzjc record);

    PwbhJlDzjc selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhJlDzjc record);

    int updateByPrimaryKey(PwbhJlDzjc record);

    List<PwbhJlDzjc> selectByAll(PwbhJlDzjc pwbhJlDzjc);

    int updateBatch(List<PwbhJlDzjc> list);

    int updateBatchSelective(List<PwbhJlDzjc> list);

    int batchInsert(List<PwbhJlDzjc> list);

}


