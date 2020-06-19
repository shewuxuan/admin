package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJlHbdy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: FtuJlHbdyMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:06 下午
 */
@Mapper
public interface FtuJlHbdyMapper {
    int deleteByPrimaryKey(String id);

    int insert(FtuJlHbdy record);

    int insertOrUpdate(FtuJlHbdy record);

    int insertOrUpdateSelective(FtuJlHbdy record);

    int insertSelective(FtuJlHbdy record);

    FtuJlHbdy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuJlHbdy record);

    int updateByPrimaryKey(FtuJlHbdy record);

    List<FtuJlHbdy> selectByAll(FtuJlHbdy ftuJlHbdy);

    int updateBatch(List<FtuJlHbdy> list);

    int updateBatchSelective(List<FtuJlHbdy> list);

    int batchInsert(@Param("list") List<FtuJlHbdy> list);
}