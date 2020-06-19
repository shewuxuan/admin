package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhBzLpjy;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhBzLpjyMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 3:00 下午
 */
@Mapper
public interface PwbhBzLpjyMapper {
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
    int insert(PwbhBzLpjy record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhBzLpjy record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhBzLpjy selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhBzLpjy record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhBzLpjy record);

    List<PwbhBzLpjy> selectByAll(PwbhBzLpjy pwbhBzLpjy);

    int updateBatch(List<PwbhBzLpjy> list);

    int batchInsert(@Param("list") List<PwbhBzLpjy> list);

    List<PwbhBzLpjy> selectByPage(PwbhBzLpjy record);
}