package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJlJycs;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhJlJycsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/18 2:52 下午
 */
@Mapper
public interface PwbhJlJycsMapper {
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
    int insert(PwbhJlJycs record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJlJycs record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    PwbhJlJycs selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJlJycs record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJlJycs record);

    List<PwbhJlJycs> selectByAll(PwbhJlJycs pwbhJlJycs);

    int updateBatch(List<PwbhJlJycs> list);

    int updateBatchSelective(List<PwbhJlJycs> list);

    int batchInsert(@Param("list") List<PwbhJlJycs> list);
}