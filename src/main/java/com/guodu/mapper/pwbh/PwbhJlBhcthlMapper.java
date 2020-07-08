package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJlBhcthl;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhJlBhcthlMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:02 下午
 */
@Mapper
public interface PwbhJlBhcthlMapper {
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
    int insert(PwbhJlBhcthl record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJlBhcthl record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhJlBhcthl selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJlBhcthl record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJlBhcthl record);

    List<PwbhJlBhcthl> selectByAll(PwbhJlBhcthl pwbhJlBhcthl);

    int updateBatch(List<PwbhJlBhcthl> list);

    int updateBatchSelective(List<PwbhJlBhcthl> list);

    int batchInsert(@Param("list") List<PwbhJlBhcthl> list);
}