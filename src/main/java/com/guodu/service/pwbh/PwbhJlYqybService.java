package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJlYqyb;

import java.util.List;

/**
 * @ClassName: PwbhJlYqybService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:04 下午
 */
public interface PwbhJlYqybService {


    int deleteByPrimaryKey(String id);

    int insert(PwbhJlYqyb record);

    int insertSelective(PwbhJlYqyb record);

    PwbhJlYqyb selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhJlYqyb record);

    int updateByPrimaryKey(PwbhJlYqyb record);

    int updateBatch(List<PwbhJlYqyb> list);

    int updateBatchSelective(List<PwbhJlYqyb> list);

    int batchInsert(List<PwbhJlYqyb> list);

    List<PwbhJlYqyb> selectByAll(PwbhJlYqyb pwbhJlYqyb);
}

