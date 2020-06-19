package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.BzKgg;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: BzKggMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/22 4:06 下午
 */
@Mapper
public interface BzKggMapper {
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
    int insert(BzKgg record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BzKgg record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    BzKgg selectByPrimaryKey(String id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BzKgg record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BzKgg record);

    List<BzKgg> selectByAll(BzKgg bzKgg);

    int updateBatch(List<BzKgg> list);

    int batchInsert(@Param("list") List<BzKgg> list);

    List<BzKgg> selectByPage(BzKgg bzKgg);
}