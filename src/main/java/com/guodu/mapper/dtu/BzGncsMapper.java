package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.BzGncs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: BzGncsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:38 上午
 */
@Mapper
public interface BzGncsMapper {
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
    int insert(BzGncs record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BzGncs record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    BzGncs selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BzGncs record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BzGncs record);

    List<BzGncs> selectByAll(BzGncs bzGncs);

    int updateBatch(List<BzGncs> list);

    int batchInsert(@Param("list") List<BzGncs> list);

    List<BzGncs> selectByPage(BzGncs bzGncs);
}