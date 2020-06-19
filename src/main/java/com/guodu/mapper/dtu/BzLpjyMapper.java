package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.BzLpjy;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: BzLpjyMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/22 3:11 下午
 */
@Mapper
public interface BzLpjyMapper {
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
    int insert(BzLpjy record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BzLpjy record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    BzLpjy selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BzLpjy record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BzLpjy record);

    List<BzLpjy> selectByAll(BzLpjy bzLpjy);

    int updateBatch(List<BzLpjy> list);

    int batchInsert(@Param("list") List<BzLpjy> list);

    List<BzLpjy> selectByPage(BzLpjy bzLpjy);
}