package com.guodu.service.dtu;

import com.guodu.pojo.dtu.BzGncs;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzGncsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:38 上午
 */
public interface BzGncsService {


    int deleteByPrimaryKey(String id);

    int insert(BzGncs record);

    int insertSelective(BzGncs record);

    BzGncs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzGncs record);

    int updateByPrimaryKey(BzGncs record);

    List<BzGncs> selectByAll(BzGncs bzGncs);

    int updateBatch(List<BzGncs> list);

    int batchInsert(List<BzGncs> list);

    String selectByPage(Map<String, Object> map);
}
