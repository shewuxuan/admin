package com.guodu.service.impl.cq;

import com.guodu.mapper.cq.CqRecordMapper;
import com.guodu.mapper.equip.EquipInfoMapper;
import com.guodu.pojo.cq.CqRecord;
import com.guodu.service.cq.CqRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: CqRecordServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/3/19 3:17 下午
 */
@Service
public class CqRecordServiceImpl implements CqRecordService {

    @Resource
    private CqRecordMapper cqRecordMapper;
    @Resource
    private EquipInfoMapper equipInfoMapper;

    @Override
    public int deleteByPrimaryKey(String cqid) {
        return cqRecordMapper.deleteByPrimaryKey(cqid);
    }

    @Override
    public int insert(CqRecord record) {
        return cqRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(CqRecord record) {
        return cqRecordMapper.insertSelective(record);
    }

    @Override
    public CqRecord selectByPrimaryKey(String cqid) {
        return cqRecordMapper.selectByPrimaryKey(cqid);
    }

    @Override
    public int updateByPrimaryKeySelective(CqRecord record) {
        return cqRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CqRecord record) {
        return cqRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CqRecord> selectByAll(CqRecord cqRecord) {
        return cqRecordMapper.selectByAll(cqRecord);
    }

    @Override
    public int updateBatch(List<CqRecord> list) {
        return cqRecordMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<CqRecord> list) {
        return cqRecordMapper.batchInsert(list);
    }

    @Override
    public List<CqRecord> selectByPage(CqRecord record) {
        return cqRecordMapper.selectByPage(record);


    }

}


