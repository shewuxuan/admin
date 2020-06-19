package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JlGjcs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JlGjcsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/21 4:45 下午
 */
@Mapper
public interface JlGjcsMapper {
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
    int insert(JlGjcs record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JlGjcs record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JlGjcs selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JlGjcs record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JlGjcs record);

    List<JlGjcs> selectByAll(JlGjcs jlGjcs);

    int updateBatch(List<JlGjcs> list);

    int batchInsert(@Param("list") List<JlGjcs> list);

    int deleteByTsid(@Param("tsid")String tsid);


}