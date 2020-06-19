package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuBzGncs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: FtuBzGncsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:21 下午
 */
@Mapper
public interface FtuBzGncsMapper {
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
    int insert(FtuBzGncs record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(FtuBzGncs record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    FtuBzGncs selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FtuBzGncs record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FtuBzGncs record);

    List<FtuBzGncs> selectByAll(FtuBzGncs ftuBzGncs);

    int updateBatch(List<FtuBzGncs> list);

    int batchInsert(@Param("list") List<FtuBzGncs> list);

    List<FtuBzGncs> selectByPage(FtuBzGncs record);

}