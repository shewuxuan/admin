package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.BzYkts;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: BzYktsMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/22 4:14 下午
 */
@Mapper
public interface BzYktsMapper {
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
    int insert(BzYkts record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BzYkts record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    BzYkts selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BzYkts record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BzYkts record);

    List<BzYkts> selectByAll(BzYkts bzYkts);

    int updateBatch(List<BzYkts> list);

    int batchInsert(@Param("list") List<BzYkts> list);

    List<BzYkts> selectByPage(BzYkts bzYkts);
}