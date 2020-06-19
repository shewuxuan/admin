package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JlGncs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JlGncsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:33 上午
 */
@Mapper
public interface JlGncsMapper {
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
    int insert(JlGncs record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JlGncs record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JlGncs selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JlGncs record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JlGncs record);

    List<JlGncs> selectByAll(JlGncs jlGncs);

    int updateBatch(List<JlGncs> list);

    int batchInsert(@Param("list") List<JlGncs> list);

    int deleteByTsid(@Param("tsid")String tsid);


}