package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJlGjdz;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: FtuJlGjdzMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/7/14 3:35 下午
 */
@Mapper
public interface FtuJlGjdzMapper {
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
    int insert(FtuJlGjdz record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(FtuJlGjdz record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    FtuJlGjdz selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FtuJlGjdz record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FtuJlGjdz record);

    List<FtuJlGjdz> selectByAll(FtuJlGjdz ftuJlGjdz);

    int updateBatch(List<FtuJlGjdz> list);

    int updateBatchSelective(List<FtuJlGjdz> list);

    int batchInsert(@Param("list") List<FtuJlGjdz> list);
}