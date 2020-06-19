package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.BzWgpz;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: BzWgpzMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:41 上午
 */
@Mapper
public interface BzWgpzMapper {
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
    int insert(BzWgpz record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BzWgpz record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    BzWgpz selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BzWgpz record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BzWgpz record);

    List<BzWgpz> selectByAll(BzWgpz bzWgpz);

    int updateBatch(List<BzWgpz> list);

    int batchInsert(@Param("list") List<BzWgpz> list);

    List<BzWgpz> selectByPage(BzWgpz bzWgpz);
}