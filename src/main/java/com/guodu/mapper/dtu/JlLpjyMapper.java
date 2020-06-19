package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JlLpjy;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JlLpjyMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:34 上午
 */
@Mapper
public interface JlLpjyMapper {
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
    int insert(JlLpjy record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JlLpjy record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JlLpjy selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JlLpjy record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JlLpjy record);

    List<JlLpjy> selectByAll(JlLpjy jlLpjy);

    int updateBatch(List<JlLpjy> list);

    int batchInsert(@Param("list") List<JlLpjy> list);

    int deleteByTsid(@Param("tsid")String tsid);


}