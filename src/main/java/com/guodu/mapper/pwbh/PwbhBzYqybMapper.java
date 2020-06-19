package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhBzYqyb;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PwbhBzYqybMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 3:00 下午
 */
@Mapper
public interface PwbhBzYqybMapper {
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
    int insert(PwbhBzYqyb record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhBzYqyb record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PwbhBzYqyb selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhBzYqyb record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhBzYqyb record);

    List<PwbhBzYqyb> selectByAll(PwbhBzYqyb pwbhBzYqyb);

    int updateBatch(List<PwbhBzYqyb> list);

    int batchInsert(@Param("list") List<PwbhBzYqyb> list);

    List<PwbhBzYqyb> selectByPage(PwbhBzYqyb record);
}