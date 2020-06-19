package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJlGncs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: FtuJlGncsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:06 下午
 */
@Mapper
public interface FtuJlGncsMapper {
    int deleteByPrimaryKey(String id);

    int insert(FtuJlGncs record);

    int insertOrUpdate(FtuJlGncs record);

    int insertOrUpdateSelective(FtuJlGncs record);

    int insertSelective(FtuJlGncs record);

    FtuJlGncs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuJlGncs record);

    int updateByPrimaryKey(FtuJlGncs record);

    List<FtuJlGncs> selectByAll(FtuJlGncs ftuJlGncs);

    int updateBatch(List<FtuJlGncs> list);

    int updateBatchSelective(List<FtuJlGncs> list);

    int batchInsert(@Param("list") List<FtuJlGncs> list);
}