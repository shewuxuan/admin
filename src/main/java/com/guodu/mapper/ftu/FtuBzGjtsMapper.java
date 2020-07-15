package com.guodu.mapper.ftu;

import com.guodu.pojo.ftu.FtuBzGjts;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: FtuBzGjtsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/7/15 5:09 下午
 */
@Mapper
public interface FtuBzGjtsMapper {
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
    int insert(FtuBzGjts record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(FtuBzGjts record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    FtuBzGjts selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FtuBzGjts record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FtuBzGjts record);

    List<FtuBzGjts> selectByAll(FtuBzGjts ftuBzGjts);

    int updateBatch(List<FtuBzGjts> list);

    int updateBatchSelective(List<FtuBzGjts> list);

    int batchInsert(@Param("list") List<FtuBzGjts> list);

    List<FtuBzGjts> selectByPage(FtuBzGjts record);
}