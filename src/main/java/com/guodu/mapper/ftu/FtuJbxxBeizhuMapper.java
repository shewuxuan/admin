package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJbxxBeizhu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: FtuJbxxBeizhuMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/14 10:46 上午
 */
@Mapper
public interface FtuJbxxBeizhuMapper {
    /**
     * delete by primary key
     * @param tsid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String tsid);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(FtuJbxxBeizhu record);

    int insertOrUpdate(FtuJbxxBeizhu record);

    int insertOrUpdateSelective(FtuJbxxBeizhu record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(FtuJbxxBeizhu record);

    /**
     * select by primary key
     * @param tsid primary key
     * @return object by primary key
     */
    FtuJbxxBeizhu selectByPrimaryKey(String tsid);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FtuJbxxBeizhu record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FtuJbxxBeizhu record);

    int updateBatch(List<FtuJbxxBeizhu> list);

    int updateBatchSelective(List<FtuJbxxBeizhu> list);

    int batchInsert(@Param("list") List<FtuJbxxBeizhu> list);
}