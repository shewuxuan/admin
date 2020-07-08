package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJlWgjc;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhJlWgjcMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:29 下午
 */
@Mapper
public interface PwbhJlWgjcMapper {
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
    int insert(PwbhJlWgjc record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJlWgjc record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    PwbhJlWgjc selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJlWgjc record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJlWgjc record);

    List<PwbhJlWgjc> selectByAll(PwbhJlWgjc pwbhJlWgjc);

    int updateBatch(List<PwbhJlWgjc> list);

    int updateBatchSelective(List<PwbhJlWgjc> list);

    int batchInsert(@Param("list") List<PwbhJlWgjc> list);
}