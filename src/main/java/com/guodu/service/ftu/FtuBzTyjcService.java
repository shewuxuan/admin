package com.guodu.service.ftu;

import java.util.List;

import com.guodu.pojo.ftu.FtuBzTyjc;

/**
 * @ClassName: FtuBzTyjcService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:22 下午
 */
public interface FtuBzTyjcService {


    int deleteByPrimaryKey(String id);

    int insert(FtuBzTyjc record);

    int insertSelective(FtuBzTyjc record);

    FtuBzTyjc selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuBzTyjc record);

    int updateByPrimaryKey(FtuBzTyjc record);

    List<FtuBzTyjc> selectByAll(FtuBzTyjc ftuBzTyjc);

    int updateBatch(List<FtuBzTyjc> list);

    int batchInsert(List<FtuBzTyjc> list);

    List<FtuBzTyjc> selectByPage(FtuBzTyjc record);

}
