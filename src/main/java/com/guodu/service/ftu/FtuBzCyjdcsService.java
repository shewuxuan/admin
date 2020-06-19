package com.guodu.service.ftu;

import java.util.List;

import com.guodu.pojo.ftu.FtuBzCyjdcs;

/**
 * @ClassName: FtuBzCyjdcsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:20 下午
 */
public interface FtuBzCyjdcsService {


    int deleteByPrimaryKey(String id);

    int insert(FtuBzCyjdcs record);

    int insertSelective(FtuBzCyjdcs record);

    FtuBzCyjdcs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuBzCyjdcs record);

    int updateByPrimaryKey(FtuBzCyjdcs record);

    List<FtuBzCyjdcs> selectByAll(FtuBzCyjdcs ftuBzCyjdcs);

    int updateBatch(List<FtuBzCyjdcs> list);

    int batchInsert(List<FtuBzCyjdcs> list);

    List<FtuBzCyjdcs> selectByPage(FtuBzCyjdcs record);

}
