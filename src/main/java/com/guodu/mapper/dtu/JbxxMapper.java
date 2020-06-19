package com.guodu.mapper.dtu;

import com.github.pagehelper.Page;
import com.guodu.pojo.dtu.Jbxx;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: JbxxMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/3/6 6:02 下午
 */
@Mapper
public interface JbxxMapper {
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
    int insert(Jbxx record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Jbxx record);

    /**
     * select by primary key
     *
     * @param tsid primary key
     * @return object by primary key
     */
    Jbxx selectByPrimaryKey(String tsid);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Jbxx record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Jbxx record);

    List<Jbxx> selectByAll(Jbxx jbxx);

    int updateBatch(List<Jbxx> list);

    int batchInsert(@Param("list") List<Jbxx> list);

    List<Jbxx> selectByPage(Map<String, Object> map);

    Page<?> selectPage(Map<String, Object> map);
}