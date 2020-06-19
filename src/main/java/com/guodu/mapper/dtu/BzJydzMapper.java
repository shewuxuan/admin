package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.BzJydz;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: BzJydzMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:39 上午
 */
@Mapper
public interface BzJydzMapper {
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
    int insert(BzJydz record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BzJydz record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    BzJydz selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BzJydz record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BzJydz record);

    List<BzJydz> selectByAll(BzJydz bzJydz);

    int updateBatch(List<BzJydz> list);

    int batchInsert(@Param("list") List<BzJydz> list);

    List<BzJydz> selectByPage(BzJydz bzJydz);
}