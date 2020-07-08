package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJlZzsy;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhJlZzsyMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/15 4:20 下午
 */
@Mapper
public interface PwbhJlZzsyMapper {
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
    int insert(PwbhJlZzsy record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJlZzsy record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhJlZzsy selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJlZzsy record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJlZzsy record);

    List<PwbhJlZzsy> selectByAll(PwbhJlZzsy pwbhJlZzsy);

    int updateBatch(List<PwbhJlZzsy> list);

    int updateBatchSelective(List<PwbhJlZzsy> list);

    int batchInsert(@Param("list") List<PwbhJlZzsy> list);
}