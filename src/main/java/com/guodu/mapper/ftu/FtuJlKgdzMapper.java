package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJlKgdz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: FtuJlKgdzMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:07 下午
 */
@Mapper
public interface FtuJlKgdzMapper {
    int deleteByPrimaryKey(String id);

    int insert(FtuJlKgdz record);

    int insertOrUpdate(FtuJlKgdz record);

    int insertOrUpdateSelective(FtuJlKgdz record);

    int insertSelective(FtuJlKgdz record);

    FtuJlKgdz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuJlKgdz record);

    int updateByPrimaryKey(FtuJlKgdz record);

    List<FtuJlKgdz> selectByAll(FtuJlKgdz ftuJlKgdz);

    int updateBatch(List<FtuJlKgdz> list);

    int updateBatchSelective(List<FtuJlKgdz> list);

    int batchInsert(@Param("list") List<FtuJlKgdz> list);
}