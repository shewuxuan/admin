package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.BzGjcs;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: BzGjcsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/22 4:22 下午
 */
@Mapper
public interface BzGjcsMapper {
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
    int insert(BzGjcs record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BzGjcs record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    BzGjcs selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BzGjcs record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BzGjcs record);

    List<BzGjcs> selectByAll(BzGjcs bzGjcs);

    int updateBatch(List<BzGjcs> list);

    int batchInsert(@Param("list") List<BzGjcs> list);

    List<BzGjcs> selectByPage(BzGjcs bzGjcs);
}