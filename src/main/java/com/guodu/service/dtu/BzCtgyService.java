package com.guodu.service.dtu;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzCtgy;

/**
 * ClassName: BzCtgyService
 * Function:  TODO
 * Date:      2020/1/17 4:21 下午
 * author     2Uli
 */
public interface BzCtgyService {


    int deleteByPrimaryKey(String id);

    int insert(BzCtgy record);

    int insertSelective(BzCtgy record);

    BzCtgy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzCtgy record);

    int updateByPrimaryKey(BzCtgy record);

    List<BzCtgy> selectByAll(BzCtgy bzCtgy);

    int updateBatch(List<BzCtgy> list);

    int batchInsert(List<BzCtgy> list);

    String selectByPage(Map<String, Object> map);
}

