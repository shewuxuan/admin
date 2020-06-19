package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.BzYcts;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: BzYctsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:41 上午
 */
@Mapper
public interface BzYctsMapper {
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
    int insert(BzYcts record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BzYcts record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    BzYcts selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BzYcts record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BzYcts record);

    List<BzYcts> selectByAll(BzYcts bzYcts);

    int updateBatch(List<BzYcts> list);

    int batchInsert(@Param("list") List<BzYcts> list);

    List<BzYcts> selectByPage(BzYcts bzYcts);
}