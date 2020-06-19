package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JlCyjd;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JlCyjdMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/19 3:17 下午
 */
@Mapper
public interface JlCyjdMapper {
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
    int insert(JlCyjd record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JlCyjd record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JlCyjd selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JlCyjd record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JlCyjd record);

    List<JlCyjd> selectByAll(JlCyjd jlCyjd);

    int updateBatch(List<JlCyjd> list);

    int batchInsert(@Param("list") List<JlCyjd> list);

    int deleteByTsid(@Param("tsid")String tsid);


}