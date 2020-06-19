package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJlYkkg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: FtuJlYkkgMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:08 下午
 */
@Mapper
public interface FtuJlYkkgMapper {
    int deleteByPrimaryKey(String id);

    int insert(FtuJlYkkg record);

    int insertOrUpdate(FtuJlYkkg record);

    int insertOrUpdateSelective(FtuJlYkkg record);

    int insertSelective(FtuJlYkkg record);

    FtuJlYkkg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuJlYkkg record);

    int updateByPrimaryKey(FtuJlYkkg record);

    List<FtuJlYkkg> selectByAll(FtuJlYkkg ftuJlYkkg);

    int updateBatch(List<FtuJlYkkg> list);

    int updateBatchSelective(List<FtuJlYkkg> list);

    int batchInsert(@Param("list") List<FtuJlYkkg> list);
}