package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.BzCyjd;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: BzCyjdMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/22 3:45 下午
 */
@Mapper
public interface BzCyjdMapper {
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
    int insert(BzCyjd record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BzCyjd record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    BzCyjd selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BzCyjd record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BzCyjd record);

    List<BzCyjd> selectByAll(BzCyjd bzCyjd);

    int updateBatch(List<BzCyjd> list);

    int batchInsert(@Param("list") List<BzCyjd> list);

    int updateBatchSelective(List<BzCyjd> list);

    List<BzCyjd> selectByPage(BzCyjd bzCyjd);
}