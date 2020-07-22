package com.guodu.service.cq;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.cq.CqRecord;

/**
 * @ClassName: CqRecordService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/3/19 3:17 下午
 */
public interface CqRecordService {


    int deleteByPrimaryKey(String cqid);

    int insert(CqRecord record);

    int insertSelective(CqRecord record);

    CqRecord selectByPrimaryKey(String cqid);

    int updateByPrimaryKeySelective(CqRecord record);

    int updateByPrimaryKey(CqRecord record);

    List<CqRecord> selectByAll(CqRecord cqRecord);

    int updateBatch(List<CqRecord> list);

    int batchInsert(List<CqRecord> list);

    List<CqRecord> selectByPage(CqRecord record);

    Map<String, Object> selectPageCqCount(Map<String, Object> vo);

    List<Map<String,Object>>  getCqRecords(String[] idArr);
}


