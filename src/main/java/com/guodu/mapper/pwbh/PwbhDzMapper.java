package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhDz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: PwbhDzMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/30 1:39 下午
 */
@Mapper
public interface PwbhDzMapper {
    /**
     * delete by primary key
     *
     * @param tsid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String tsid);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(PwbhDz record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhDz record);

    /**
     * select by primary key
     *
     * @param tsid primary key
     * @return object by primary key
     */
    PwbhDz selectByPrimaryKey(String tsid);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhDz record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhDz record);

    List<PwbhDz> selectByAll(PwbhDz pwbhDz);

    int updateBatch(List<PwbhDz> list);

    int updateBatchSelective(List<PwbhDz> list);

    int batchInsert(@Param("list") List<PwbhDz> list);
}