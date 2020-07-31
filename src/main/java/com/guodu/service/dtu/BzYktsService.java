package com.guodu.service.dtu;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzYkts;

/**
 * @ClassName: BzYktsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:41 上午
 */
public interface BzYktsService {


    int deleteByPrimaryKey(String id);

    int insert(BzYkts record);

    int insertSelective(BzYkts record);

    BzYkts selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzYkts record);

    int updateByPrimaryKey(BzYkts record);

    List<BzYkts> selectByAll(BzYkts bzYkts);

    int updateBatch(List<BzYkts> list);

    int batchInsert(List<BzYkts> list);

    List<BzYkts> selectByPage(BzYkts record);
}
