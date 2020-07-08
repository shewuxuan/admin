package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJlYqyb;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhJlYqybMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:29 下午
 */
@Mapper
public interface PwbhJlYqybMapper {
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
    int insert(PwbhJlYqyb record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJlYqyb record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    PwbhJlYqyb selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJlYqyb record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJlYqyb record);

    List<PwbhJlYqyb> selectByAll(PwbhJlYqyb pwbhJlYqyb);

    int updateBatch(List<PwbhJlYqyb> list);

    int updateBatchSelective(List<PwbhJlYqyb> list);

    int batchInsert(@Param("list") List<PwbhJlYqyb> list);
}