package com.guodu.service.dtu;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzYcts;

/**
 * @ClassName: BzYctsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:41 上午
 */
public interface BzYctsService {


    int deleteByPrimaryKey(String id);

    int insert(BzYcts record);

    int insertSelective(BzYcts record);

    BzYcts selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzYcts record);

    int updateByPrimaryKey(BzYcts record);

    List<BzYcts> selectByAll(BzYcts bzYcts);

    int updateBatch(List<BzYcts> list);

    int batchInsert(List<BzYcts> list);

    String selectByPage(Map<String, Object> map);
}
