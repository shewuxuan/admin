package com.guodu.mapper.sys;

import com.guodu.pojo.sys.SysDb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: SysDbMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/15 5:14 下午
 */
@Mapper
public interface SysDbMapper {
    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SysDb record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysDb record);

    List<SysDb> selectByAll(SysDb sysDb);

    int batchInsert(@Param("list") List<SysDb> list);

    SysDb selectByKeycodeAndKeyValue(SysDb sysDb);
}