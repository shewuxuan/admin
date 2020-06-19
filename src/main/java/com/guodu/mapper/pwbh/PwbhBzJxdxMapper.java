package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhBzJxdx;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhBzJxdxMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:59 下午
 */
@Mapper
public interface PwbhBzJxdxMapper {
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
    int insert(PwbhBzJxdx record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhBzJxdx record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhBzJxdx selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhBzJxdx record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhBzJxdx record);

    List<PwbhBzJxdx> selectByAll(PwbhBzJxdx pwbhBzJxdx);

    int updateBatch(List<PwbhBzJxdx> list);

    int batchInsert(@Param("list") List<PwbhBzJxdx> list);

    List<PwbhBzJxdx> selectByPage(PwbhBzJxdx record);
}