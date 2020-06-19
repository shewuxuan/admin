package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJlTzyb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: FtuJlTzybMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:07 下午
 */
@Mapper
public interface FtuJlTzybMapper {
    int deleteByPrimaryKey(String id);

    int insert(FtuJlTzyb record);

    int insertOrUpdate(FtuJlTzyb record);

    int insertOrUpdateSelective(FtuJlTzyb record);

    int insertSelective(FtuJlTzyb record);

    FtuJlTzyb selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FtuJlTzyb record);

    int updateByPrimaryKey(FtuJlTzyb record);

    List<FtuJlTzyb> selectByAll(FtuJlTzyb ftuJlTzyb);

    int updateBatch(List<FtuJlTzyb> list);

    int updateBatchSelective(List<FtuJlTzyb> list);

    int batchInsert(@Param("list") List<FtuJlTzyb> list);
}