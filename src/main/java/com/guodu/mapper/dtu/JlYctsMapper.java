package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JlYcts;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JlYctsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:34 上午
 */
@Mapper
public interface JlYctsMapper {
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
    int insert(JlYcts record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JlYcts record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JlYcts selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JlYcts record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JlYcts record);

    List<JlYcts> selectByAll(JlYcts jlYcts);

    int updateBatch(List<JlYcts> list);

    int batchInsert(@Param("list") List<JlYcts> list);

    int deleteByTsid(@Param("tsid")String tsid);


}