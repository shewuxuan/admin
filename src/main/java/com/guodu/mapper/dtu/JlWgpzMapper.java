package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JlWgpz;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JlWgpzMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/19 3:17 下午
 */
@Mapper
public interface JlWgpzMapper {
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
    int insert(JlWgpz record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JlWgpz record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JlWgpz selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JlWgpz record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JlWgpz record);

    List<JlWgpz> selectByAll(JlWgpz jlWgpz);

    int updateBatch(List<JlWgpz> list);

    int batchInsert(@Param("list") List<JlWgpz> list);

    int deleteByTsid(@Param("tsid")String tsid);


}