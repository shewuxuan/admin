package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JlJydz;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JlJydzMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:33 上午
 */
@Mapper
public interface JlJydzMapper {
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
    int insert(JlJydz record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JlJydz record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JlJydz selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JlJydz record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JlJydz record);

    List<JlJydz> selectByAll(JlJydz jlJydz);

    int updateBatch(List<JlJydz> list);

    int batchInsert(@Param("list") List<JlJydz> list);

    int deleteByTsid(@Param("tsid")String tsid);


}