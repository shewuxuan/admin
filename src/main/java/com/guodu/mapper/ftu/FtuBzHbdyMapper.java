package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuBzHbdy;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: FtuBzHbdyMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:21 下午
 */
@Mapper
public interface FtuBzHbdyMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(FtuBzHbdy record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(FtuBzHbdy record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    FtuBzHbdy selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FtuBzHbdy record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FtuBzHbdy record);

    List<FtuBzHbdy> selectByAll(FtuBzHbdy ftuBzHbdy);

    int updateBatch(List<FtuBzHbdy> list);

    int batchInsert(@Param("list") List<FtuBzHbdy> list);

    List<FtuBzHbdy> selectByPage(FtuBzHbdy record);

}