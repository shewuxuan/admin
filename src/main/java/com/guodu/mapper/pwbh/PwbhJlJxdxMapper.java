package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJlJxdx;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhJlJxdxMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:03 下午
 */
@Mapper
public interface PwbhJlJxdxMapper {
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
    int insert(PwbhJlJxdx record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJlJxdx record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhJlJxdx selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJlJxdx record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJlJxdx record);

    List<PwbhJlJxdx> selectByAll(PwbhJlJxdx pwbhJlJxdx);

    int updateBatch(List<PwbhJlJxdx> list);

    int updateBatchSelective(List<PwbhJlJxdx> list);

    int batchInsert(@Param("list") List<PwbhJlJxdx> list);
}