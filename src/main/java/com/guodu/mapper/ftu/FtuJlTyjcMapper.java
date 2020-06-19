package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJlTyjc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: FtuJlTyjcMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:07 下午
 */
@Mapper
public interface FtuJlTyjcMapper {
    int deleteByPrimaryKey(String id);

    int insert(FtuJlTyjc record);

    int insertOrUpdate(FtuJlTyjc record);

    int insertOrUpdateSelective(FtuJlTyjc record);

    int insertSelective(FtuJlTyjc record);

    FtuJlTyjc selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuJlTyjc record);

    int updateByPrimaryKey(FtuJlTyjc record);

    List<FtuJlTyjc> selectByAll(FtuJlTyjc ftuJlTyjc);

    int updateBatch(List<FtuJlTyjc> list);

    int updateBatchSelective(List<FtuJlTyjc> list);

    int batchInsert(@Param("list") List<FtuJlTyjc> list);
}