package com.guodu.service.ftu;

import java.util.List;

import com.guodu.pojo.ftu.FtuBzGjts;

/**
 * @ClassName: FtuBzGjtsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:20 下午
 */
public interface FtuBzGjtsService {


    int deleteByPrimaryKey(String id);

    int insert(FtuBzGjts record);

    int insertSelective(FtuBzGjts record);

    FtuBzGjts selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuBzGjts record);

    int updateByPrimaryKey(FtuBzGjts record);

    List<FtuBzGjts> selectByAll(FtuBzGjts ftuBzGjts);

    int updateBatch(List<FtuBzGjts> list);

    int batchInsert(List<FtuBzGjts> list);

    List<FtuBzGjts> selectByPage(FtuBzGjts record);


}
