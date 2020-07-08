package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJlSgjc;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhJlSgjcMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:29 下午
 */
@Mapper
public interface PwbhJlSgjcMapper {
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
    int insert(PwbhJlSgjc record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJlSgjc record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    PwbhJlSgjc selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJlSgjc record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJlSgjc record);

    List<PwbhJlSgjc> selectByAll(PwbhJlSgjc pwbhJlSgjc);

    int updateBatch(List<PwbhJlSgjc> list);

    int updateBatchSelective(List<PwbhJlSgjc> list);

    int batchInsert(@Param("list") List<PwbhJlSgjc> list);
}