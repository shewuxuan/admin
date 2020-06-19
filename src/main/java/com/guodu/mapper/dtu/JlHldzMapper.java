package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JlHldz;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JlHldzMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:33 上午
 */
@Mapper
public interface JlHldzMapper {
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
    int insert(JlHldz record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JlHldz record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JlHldz selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JlHldz record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JlHldz record);

    List<JlHldz> selectByAll(JlHldz jlHldz);

    int updateBatch(List<JlHldz> list);

    int batchInsert(@Param("list") List<JlHldz> list);

    int deleteByTsid(@Param("tsid")String tsid);


}