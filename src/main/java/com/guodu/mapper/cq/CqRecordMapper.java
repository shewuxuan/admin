package com.guodu.mapper.cq;

import com.github.pagehelper.Page;
import com.guodu.pojo.cq.CqRecord;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: CqRecordMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/22 4:50 下午
 */
@Mapper
public interface CqRecordMapper {
    /**
     * delete by primary key
     *
     * @param cqid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String cqid);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(CqRecord record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(CqRecord record);

    /**
     * select by primary key
     *
     * @param cqid primary key
     * @return object by primary key
     */
    CqRecord selectByPrimaryKey(String cqid);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CqRecord record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CqRecord record);

    List<CqRecord> selectByAll(CqRecord cqRecord);

    int updateBatch(List<CqRecord> list);

    int batchInsert(@Param("list") List<CqRecord> list);

    List<CqRecord> selectByPage(CqRecord cqRecord);

    Page<?> selectPageCqCount(Map<String, Object> map);

    List<Map<String, Object>> getCqQxflGroupConut(Map<String, Object> map);

    List<Map<String,Object>>  getCqRecords(@Param("ids") String[] ids);
}