package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJlDzjc;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhJlDzjcMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/30 1:38 下午
 */
@Mapper
public interface PwbhJlDzjcMapper {
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
    int insert(PwbhJlDzjc record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJlDzjc record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    PwbhJlDzjc selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJlDzjc record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJlDzjc record);

    List<PwbhJlDzjc> selectByAll(PwbhJlDzjc pwbhJlDzjc);

    int updateBatch(List<PwbhJlDzjc> list);

    int updateBatchSelective(List<PwbhJlDzjc> list);

    int batchInsert(@Param("list") List<PwbhJlDzjc> list);
}