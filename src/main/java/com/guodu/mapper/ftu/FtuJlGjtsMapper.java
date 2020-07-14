package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJlGjts;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: FtuJlGjtsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/7/14 3:36 下午
 */
@Mapper
public interface FtuJlGjtsMapper {
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
    int insert(FtuJlGjts record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(FtuJlGjts record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    FtuJlGjts selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FtuJlGjts record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FtuJlGjts record);

    List<FtuJlGjts> selectByAll(FtuJlGjts ftuJlGjts);

    int updateBatch(List<FtuJlGjts> list);

    int updateBatchSelective(List<FtuJlGjts> list);

    int batchInsert(@Param("list") List<FtuJlGjts> list);
}