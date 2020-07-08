package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJlBhctbh;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhJlBhctbhMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:02 下午
 */
@Mapper
public interface PwbhJlBhctbhMapper {
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
    int insert(PwbhJlBhctbh record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJlBhctbh record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhJlBhctbh selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJlBhctbh record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJlBhctbh record);

    List<PwbhJlBhctbh> selectByAll(PwbhJlBhctbh pwbhJlBhctbh);

    int updateBatch(List<PwbhJlBhctbh> list);

    int updateBatchSelective(List<PwbhJlBhctbh> list);

    int batchInsert(@Param("list") List<PwbhJlBhctbh> list);
}