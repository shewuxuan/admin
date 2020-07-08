package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlWgjcMapper;
import com.guodu.pojo.pwbh.PwbhJlWgjc;
import com.guodu.service.pwbh.PwbhJlWgjcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlWgjcServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:04 下午
 */
@Service
public class PwbhJlWgjcServiceImpl implements PwbhJlWgjcService {

    @Resource
    private PwbhJlWgjcMapper pwbhJlWgjcMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlWgjcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlWgjc record) {
        return pwbhJlWgjcMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlWgjc record) {
        return pwbhJlWgjcMapper.insertSelective(record);
    }

    @Override
    public PwbhJlWgjc selectByPrimaryKey(String id) {
        return pwbhJlWgjcMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlWgjc record) {
        return pwbhJlWgjcMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlWgjc record) {
        return pwbhJlWgjcMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<PwbhJlWgjc> list) {
        return pwbhJlWgjcMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlWgjc> list) {
        return pwbhJlWgjcMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlWgjc> list) {
        return pwbhJlWgjcMapper.batchInsert(list);
    }

    @Override
    public List<PwbhJlWgjc> selectByAll(PwbhJlWgjc pwbhJlWgjc) {
        return pwbhJlWgjcMapper.selectByAll(pwbhJlWgjc);
    }
}

