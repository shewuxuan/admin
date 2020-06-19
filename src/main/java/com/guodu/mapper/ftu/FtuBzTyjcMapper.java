package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuBzTyjc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: FtuBzTyjcMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:22 下午
 */
@Mapper
public interface FtuBzTyjcMapper {
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
    int insert(FtuBzTyjc record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(FtuBzTyjc record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    FtuBzTyjc selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FtuBzTyjc record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FtuBzTyjc record);

    List<FtuBzTyjc> selectByAll(FtuBzTyjc ftuBzTyjc);

    int updateBatch(List<FtuBzTyjc> list);

    int batchInsert(@Param("list") List<FtuBzTyjc> list);

    List<FtuBzTyjc> selectByPage(FtuBzTyjc record);

}