package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JlDyxn;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JlDyxnMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/20 1:26 下午
 */
@Mapper
public interface JlDyxnMapper {
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
    int insert(JlDyxn record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JlDyxn record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JlDyxn selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JlDyxn record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JlDyxn record);

    List<JlDyxn> selectByAll(JlDyxn jlDyxn);

    int updateBatch(List<JlDyxn> list);

    int batchInsert(@Param("list") List<JlDyxn> list);

    int deleteByTsid(@Param("tsid")String tsid);


}