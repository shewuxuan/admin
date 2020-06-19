package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhBzJycs;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhBzJycsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/18 1:47 下午
 */
@Mapper
public interface PwbhBzJycsMapper {
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
    int insert(PwbhBzJycs record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhBzJycs record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    PwbhBzJycs selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhBzJycs record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhBzJycs record);

    List<PwbhBzJycs> selectByAll(PwbhBzJycs pwbhBzJycs);

    int updateBatch(List<PwbhBzJycs> list);

    int updateBatchSelective(List<PwbhBzJycs> list);

    int batchInsert(@Param("list") List<PwbhBzJycs> list);

    List<PwbhBzJycs> selectByPage(PwbhBzJycs record);
}