package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JlDlhl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JlDlhlMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:32 上午
 */
@Mapper
public interface JlDlhlMapper {
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
    int insert(JlDlhl record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JlDlhl record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JlDlhl selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JlDlhl record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JlDlhl record);

    List<JlDlhl> selectByAll(JlDlhl jlDlhl);

    int updateBatch(List<JlDlhl> list);

    int batchInsert(@Param("list") List<JlDlhl> list);

    int deleteByTsid(@Param("tsid")String tsid);


}