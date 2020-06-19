package com.guodu.service.ftu;

import java.util.List;

import com.guodu.pojo.ftu.FtuBzTzyb;

/**
 * @ClassName: FtuBzTzybService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:22 下午
 */
public interface FtuBzTzybService {


    int deleteByPrimaryKey(String id);

    int insert(FtuBzTzyb record);

    int insertSelective(FtuBzTzyb record);

    FtuBzTzyb selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuBzTzyb record);

    int updateByPrimaryKey(FtuBzTzyb record);

    List<FtuBzTzyb> selectByAll(FtuBzTzyb ftuBzTzyb);

    int updateBatch(List<FtuBzTzyb> list);

    int batchInsert(List<FtuBzTzyb> list);

    List<FtuBzTzyb> selectByPage(FtuBzTzyb record);

}
