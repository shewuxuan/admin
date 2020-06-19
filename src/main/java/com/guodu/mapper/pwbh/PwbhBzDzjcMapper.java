package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhBzDzjc;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhBzDzjcMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:58 下午
 */
@Mapper
public interface PwbhBzDzjcMapper {
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
    int insert(PwbhBzDzjc record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhBzDzjc record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhBzDzjc selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhBzDzjc record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhBzDzjc record);

    List<PwbhBzDzjc> selectByAll(PwbhBzDzjc pwbhBzDzjc);

    int updateBatch(List<PwbhBzDzjc> list);

    int batchInsert(@Param("list") List<PwbhBzDzjc> list);

    List<PwbhBzDzjc> selectByPage(PwbhBzDzjc record);
}