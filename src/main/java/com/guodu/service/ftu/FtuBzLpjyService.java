package com.guodu.service.ftu;

import java.util.List;

import com.guodu.pojo.ftu.FtuBzLpjy;

/**
 * @ClassName: FtuBzLpjyService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:22 下午
 */
public interface FtuBzLpjyService {


    int deleteByPrimaryKey(String id);

    int insert(FtuBzLpjy record);

    int insertSelective(FtuBzLpjy record);

    FtuBzLpjy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuBzLpjy record);

    int updateByPrimaryKey(FtuBzLpjy record);

    List<FtuBzLpjy> selectByAll(FtuBzLpjy ftuBzLpjy);

    int updateBatch(List<FtuBzLpjy> list);

    int batchInsert(List<FtuBzLpjy> list);

    List<FtuBzLpjy> selectByPage(FtuBzLpjy record);

}
