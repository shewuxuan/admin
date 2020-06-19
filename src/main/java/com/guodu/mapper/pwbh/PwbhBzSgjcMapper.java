package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhBzSgjc;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhBzSgjcMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 3:00 下午
 */
@Mapper
public interface PwbhBzSgjcMapper {
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
    int insert(PwbhBzSgjc record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhBzSgjc record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhBzSgjc selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhBzSgjc record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhBzSgjc record);

    List<PwbhBzSgjc> selectByAll(PwbhBzSgjc pwbhBzSgjc);

    int updateBatch(List<PwbhBzSgjc> list);

    int batchInsert(@Param("list") List<PwbhBzSgjc> list);

    List<PwbhBzSgjc> selectByPage(PwbhBzSgjc record);
}