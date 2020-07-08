package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlSgjcMapper;
import com.guodu.pojo.pwbh.PwbhJlSgjc;
import com.guodu.service.pwbh.PwbhJlSgjcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlSgjcServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:04 下午
 */
@Service
public class PwbhJlSgjcServiceImpl implements PwbhJlSgjcService {

    @Resource
    private PwbhJlSgjcMapper pwbhJlSgjcMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlSgjcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlSgjc record) {
        return pwbhJlSgjcMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlSgjc record) {
        return pwbhJlSgjcMapper.insertSelective(record);
    }

    @Override
    public PwbhJlSgjc selectByPrimaryKey(String id) {
        return pwbhJlSgjcMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlSgjc record) {
        return pwbhJlSgjcMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlSgjc record) {
        return pwbhJlSgjcMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<PwbhJlSgjc> list) {
        return pwbhJlSgjcMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlSgjc> list) {
        return pwbhJlSgjcMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlSgjc> list) {
        return pwbhJlSgjcMapper.batchInsert(list);
    }

    @Override
    public List<PwbhJlSgjc> selectByAll(PwbhJlSgjc pwbhJlSgjc) {
        return pwbhJlSgjcMapper.selectByAll(pwbhJlSgjc);
    }
}

