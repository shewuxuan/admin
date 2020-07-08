package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJlJdjy;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhJlJdjyMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:03 下午
 */
@Mapper
public interface PwbhJlJdjyMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(PwbhJlJdjy record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJlJdjy record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhJlJdjy selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJlJdjy record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJlJdjy record);

    List<PwbhJlJdjy> selectByAll(PwbhJlJdjy pwbhJlJdjy);

    int updateBatch(List<PwbhJlJdjy> list);

    int updateBatchSelective(List<PwbhJlJdjy> list);

    int batchInsert(@Param("list") List<PwbhJlJdjy> list);
}