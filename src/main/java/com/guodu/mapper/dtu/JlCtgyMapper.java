package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JlCtgy;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JlCtgyMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:48 上午
 */
@Mapper
public interface JlCtgyMapper {
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
    int insert(JlCtgy record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JlCtgy record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JlCtgy selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JlCtgy record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JlCtgy record);

    List<JlCtgy> selectByAll(JlCtgy jlCtgy);

    int updateBatch(List<JlCtgy> list);

    int batchInsert(@Param("list") List<JlCtgy> list);

    int deleteByTsid(@Param("tsid")String tsid);


}