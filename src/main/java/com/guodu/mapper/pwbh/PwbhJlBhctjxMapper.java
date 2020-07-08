package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJlBhctjx;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhJlBhctjxMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:02 下午
 */
@Mapper
public interface PwbhJlBhctjxMapper {
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
    int insert(PwbhJlBhctjx record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJlBhctjx record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhJlBhctjx selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJlBhctjx record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJlBhctjx record);

    List<PwbhJlBhctjx> selectByAll(PwbhJlBhctjx pwbhJlBhctjx);

    int updateBatch(List<PwbhJlBhctjx> list);

    int updateBatchSelective(List<PwbhJlBhctjx> list);

    int batchInsert(@Param("list") List<PwbhJlBhctjx> list);
}