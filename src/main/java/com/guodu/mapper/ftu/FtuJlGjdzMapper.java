package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJlGjdz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: FtuJlGjdzMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:05 下午
 */
@Mapper
public interface FtuJlGjdzMapper {
    int deleteByPrimaryKey(String id);

    int insert(FtuJlGjdz record);

    int insertOrUpdate(FtuJlGjdz record);

    int insertOrUpdateSelective(FtuJlGjdz record);

    int insertSelective(FtuJlGjdz record);

    FtuJlGjdz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuJlGjdz record);

    int updateByPrimaryKey(FtuJlGjdz record);

    List<FtuJlGjdz> selectByAll(FtuJlGjdz ftuJlGjdz);

    int updateBatch(List<FtuJlGjdz> list);

    int updateBatchSelective(List<FtuJlGjdz> list);

    int batchInsert(@Param("list") List<FtuJlGjdz> list);
}