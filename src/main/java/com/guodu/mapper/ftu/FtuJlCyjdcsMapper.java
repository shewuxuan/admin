package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJlCyjdcs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: FtuJlCyjdcsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:04 下午
 */
@Mapper
public interface FtuJlCyjdcsMapper {
    int deleteByPrimaryKey(String id);

    int insert(FtuJlCyjdcs record);

    int insertOrUpdate(FtuJlCyjdcs record);

    int insertOrUpdateSelective(FtuJlCyjdcs record);

    int insertSelective(FtuJlCyjdcs record);

    FtuJlCyjdcs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuJlCyjdcs record);

    int updateByPrimaryKey(FtuJlCyjdcs record);

    List<FtuJlCyjdcs> selectByAll(FtuJlCyjdcs ftuJlCyjdcs);

    int updateBatch(List<FtuJlCyjdcs> list);

    int updateBatchSelective(List<FtuJlCyjdcs> list);

    int batchInsert(@Param("list") List<FtuJlCyjdcs> list);
}