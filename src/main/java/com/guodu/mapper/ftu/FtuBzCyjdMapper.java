package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuBzCyjd;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: FtuBzCyjdMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:17 下午
 */
@Mapper
public interface FtuBzCyjdMapper {
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
    int insert(FtuBzCyjd record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(FtuBzCyjd record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    FtuBzCyjd selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FtuBzCyjd record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FtuBzCyjd record);

    List<FtuBzCyjd> selectByAll(FtuBzCyjd ftuBzCyjd);

    int updateBatch(List<FtuBzCyjd> list);

    int batchInsert(@Param("list") List<FtuBzCyjd> list);

    List<FtuBzCyjd> selectByPage(FtuBzCyjd record);
}