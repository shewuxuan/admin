package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuJbxx;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: FtuJbxxMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/19 2:31 下午
 */
@Mapper
public interface FtuJbxxMapper {
    /**
     * delete by primary key
     *
     * @param tsid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String tsid);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(FtuJbxx record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(FtuJbxx record);

    /**
     * select by primary key
     *
     * @param tsid primary key
     * @return object by primary key
     */
    FtuJbxx selectByPrimaryKey(String tsid);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FtuJbxx record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FtuJbxx record);

    List<FtuJbxx> selectByAll(FtuJbxx ftuJbxx);

    int updateBatch(List<FtuJbxx> list);

    int batchInsert(@Param("list") List<FtuJbxx> list);
}