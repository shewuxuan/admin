package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJlYkcd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: FtuJlYkcdMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:08 下午
 */
@Mapper
public interface FtuJlYkcdMapper {
    int deleteByPrimaryKey(String id);

    int insert(FtuJlYkcd record);

    int insertOrUpdate(FtuJlYkcd record);

    int insertOrUpdateSelective(FtuJlYkcd record);

    int insertSelective(FtuJlYkcd record);

    FtuJlYkcd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuJlYkcd record);

    int updateByPrimaryKey(FtuJlYkcd record);

    List<FtuJlYkcd> selectByAll(FtuJlYkcd ftuJlYkcd);

    int updateBatch(List<FtuJlYkcd> list);

    int updateBatchSelective(List<FtuJlYkcd> list);

    int batchInsert(@Param("list") List<FtuJlYkcd> list);
}