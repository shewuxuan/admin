package com.guodu.mapper.pwbh;

import com.guodu.pojo.pwbh.PwbhJbxxBeizhu;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: PwbhJbxxBeizhuMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:01 下午
 */
@Mapper
public interface PwbhJbxxBeizhuMapper {
    /**
     * delete by primary key
     * @param tsid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String tsid);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(PwbhJbxxBeizhu record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PwbhJbxxBeizhu record);

    /**
     * select by primary key
     * @param tsid primary key
     * @return object by primary key
     */
    PwbhJbxxBeizhu selectByPrimaryKey(String tsid);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PwbhJbxxBeizhu record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PwbhJbxxBeizhu record);
}