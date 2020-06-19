package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhBzWgjc;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhBzWgjcMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 3:00 下午
 */
@Mapper
public interface PwbhBzWgjcMapper {
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
    int insert(PwbhBzWgjc record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhBzWgjc record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhBzWgjc selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhBzWgjc record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhBzWgjc record);

    List<PwbhBzWgjc> selectByAll(PwbhBzWgjc pwbhBzWgjc);

    int updateBatch(List<PwbhBzWgjc> list);

    int batchInsert(@Param("list") List<PwbhBzWgjc> list);

    List<PwbhBzWgjc> selectByPage(PwbhBzWgjc record);
}