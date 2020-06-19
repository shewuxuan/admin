package com.guodu.service.ftu;

import java.util.List;

import com.guodu.pojo.ftu.FtuBzHbdy;

/**
 * @ClassName: FtuBzHbdyService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:21 下午
 */
public interface FtuBzHbdyService {


    int deleteByPrimaryKey(String id);

    int insert(FtuBzHbdy record);

    int insertSelective(FtuBzHbdy record);

    FtuBzHbdy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuBzHbdy record);

    int updateByPrimaryKey(FtuBzHbdy record);

    List<FtuBzHbdy> selectByAll(FtuBzHbdy ftuBzHbdy);

    int updateBatch(List<FtuBzHbdy> list);

    int batchInsert(List<FtuBzHbdy> list);

    List<FtuBzHbdy> selectByPage(FtuBzHbdy record);


}
