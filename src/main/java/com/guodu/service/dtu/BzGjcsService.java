package com.guodu.service.dtu;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzGjcs;

/**
 * @ClassName: BzGjcsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:38 上午
 */
public interface BzGjcsService {


    int deleteByPrimaryKey(String id);

    int insert(BzGjcs record);

    int insertSelective(BzGjcs record);

    BzGjcs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzGjcs record);

    int updateByPrimaryKey(BzGjcs record);

    List<BzGjcs> selectByAll(BzGjcs bzGjcs);

    int updateBatch(List<BzGjcs> list);

    int batchInsert(List<BzGjcs> list);

    String selectByPage(Map<String, Object> map);
}
