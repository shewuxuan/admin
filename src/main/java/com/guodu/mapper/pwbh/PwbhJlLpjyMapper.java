package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJlLpjy;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhJlLpjyMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:26 下午
 */
@Mapper
public interface PwbhJlLpjyMapper {
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
    int insert(PwbhJlLpjy record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJlLpjy record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    PwbhJlLpjy selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJlLpjy record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJlLpjy record);

    List<PwbhJlLpjy> selectByAll(PwbhJlLpjy pwbhJlLpjy);

    int updateBatch(List<PwbhJlLpjy> list);

    int updateBatchSelective(List<PwbhJlLpjy> list);

    int batchInsert(@Param("list") List<PwbhJlLpjy> list);
}