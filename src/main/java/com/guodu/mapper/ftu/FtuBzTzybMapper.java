package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuBzTzyb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: FtuBzTzybMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:22 下午
 */
@Mapper
public interface FtuBzTzybMapper {
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
    int insert(FtuBzTzyb record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(FtuBzTzyb record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    FtuBzTzyb selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FtuBzTzyb record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FtuBzTzyb record);

    List<FtuBzTzyb> selectByAll(FtuBzTzyb ftuBzTzyb);

    int updateBatch(List<FtuBzTzyb> list);

    int batchInsert(@Param("list") List<FtuBzTzyb> list);

    List<FtuBzTzyb> selectByPage(FtuBzTzyb record);

}