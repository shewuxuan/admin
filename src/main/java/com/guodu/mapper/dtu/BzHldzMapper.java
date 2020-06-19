package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.BzHldz;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: BzHldzMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:39 上午
 */
@Mapper
public interface BzHldzMapper {
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
    int insert(BzHldz record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BzHldz record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    BzHldz selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BzHldz record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BzHldz record);

    List<BzHldz> selectByAll(BzHldz bzHldz);

    int updateBatch(List<BzHldz> list);

    int batchInsert(@Param("list") List<BzHldz> list);

    List<BzHldz> selectByPage(BzHldz bzhldz);
}