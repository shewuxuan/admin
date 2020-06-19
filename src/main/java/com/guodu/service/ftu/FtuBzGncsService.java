package com.guodu.service.ftu;

import java.util.List;

import com.guodu.pojo.ftu.FtuBzGncs;

/**
 * @ClassName: FtuBzGncsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:21 下午
 */
public interface FtuBzGncsService {


    int deleteByPrimaryKey(String id);

    int insert(FtuBzGncs record);

    int insertSelective(FtuBzGncs record);

    FtuBzGncs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuBzGncs record);

    int updateByPrimaryKey(FtuBzGncs record);

    List<FtuBzGncs> selectByAll(FtuBzGncs ftuBzGncs);

    int updateBatch(List<FtuBzGncs> list);

    int batchInsert(List<FtuBzGncs> list);

    List<FtuBzGncs> selectByPage(FtuBzGncs record);

}
