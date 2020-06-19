package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JlYkts;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JlYktsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:35 上午
 */
@Mapper
public interface JlYktsMapper {
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
    int insert(JlYkts record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JlYkts record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JlYkts selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JlYkts record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JlYkts record);

    List<JlYkts> selectByAll(JlYkts jlYkts);

    int updateBatch(List<JlYkts> list);

    int batchInsert(@Param("list") List<JlYkts> list);

    int deleteByTsid(@Param("tsid")String tsid);


}