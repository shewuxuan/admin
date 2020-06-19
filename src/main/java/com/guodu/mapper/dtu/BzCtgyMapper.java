package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.BzCtgy;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: BzCtgyMapper
 * Function:  TODO
 * Date:      2020/1/17 4:22 下午
 * author     2Uli
 */
@Mapper
public interface BzCtgyMapper {
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
    int insert(BzCtgy record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BzCtgy record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    BzCtgy selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BzCtgy record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BzCtgy record);

    List<BzCtgy> selectByAll(BzCtgy bzCtgy);

    int updateBatch(List<BzCtgy> list);

    int batchInsert(@Param("list") List<BzCtgy> list);

    List<BzCtgy> selectByPage(BzCtgy bzCtgy);
}