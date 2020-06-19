package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuBzLpjy;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: FtuBzLpjyMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:22 下午
 */
@Mapper
public interface FtuBzLpjyMapper {
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
    int insert(FtuBzLpjy record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(FtuBzLpjy record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    FtuBzLpjy selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FtuBzLpjy record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FtuBzLpjy record);

    List<FtuBzLpjy> selectByAll(FtuBzLpjy ftuBzLpjy);

    int updateBatch(List<FtuBzLpjy> list);

    int batchInsert(@Param("list") List<FtuBzLpjy> list);

    List<FtuBzLpjy> selectByPage(FtuBzLpjy record);

}