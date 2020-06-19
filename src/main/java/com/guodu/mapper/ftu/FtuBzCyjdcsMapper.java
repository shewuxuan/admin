package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuBzCyjdcs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: FtuBzCyjdcsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:20 下午
 */
@Mapper
public interface FtuBzCyjdcsMapper {
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
    int insert(FtuBzCyjdcs record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(FtuBzCyjdcs record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    FtuBzCyjdcs selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FtuBzCyjdcs record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FtuBzCyjdcs record);

    List<FtuBzCyjdcs> selectByAll(FtuBzCyjdcs ftuBzCyjdcs);

    int updateBatch(List<FtuBzCyjdcs> list);

    int batchInsert(@Param("list") List<FtuBzCyjdcs> list);

    List<FtuBzCyjdcs> selectByPage(FtuBzCyjdcs record);

}