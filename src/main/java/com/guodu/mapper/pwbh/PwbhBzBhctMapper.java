package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhBzBhct;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhBzBhctMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:57 下午
 */
@Mapper
public interface PwbhBzBhctMapper {
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
    int insert(PwbhBzBhct record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhBzBhct record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhBzBhct selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhBzBhct record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhBzBhct record);

    List<PwbhBzBhct> selectByAll(PwbhBzBhct pwbhBzBhct);

    int updateBatch(List<PwbhBzBhct> list);

    int batchInsert(@Param("list") List<PwbhBzBhct> list);

    List<PwbhBzBhct> selectByPage(PwbhBzBhct pwbhBzBhct);
}