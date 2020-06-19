package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhBzZzsy;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhBzZzsyMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/16 9:52 上午
 */
@Mapper
public interface PwbhBzZzsyMapper {
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
    int insert(PwbhBzZzsy record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhBzZzsy record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhBzZzsy selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhBzZzsy record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhBzZzsy record);

    List<PwbhBzZzsy> selectByAll(PwbhBzZzsy pwbhBzZzsy);

    int updateBatch(List<PwbhBzZzsy> list);

    int updateBatchSelective(List<PwbhBzZzsy> list);

    int batchInsert(@Param("list") List<PwbhBzZzsy> list);

    List<PwbhBzZzsy> selectByPage(PwbhBzZzsy pwbhBzZzsy);
}