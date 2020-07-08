package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlYqybMapper;
import com.guodu.pojo.pwbh.PwbhJlYqyb;
import com.guodu.service.pwbh.PwbhJlYqybService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlYqybServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:04 下午
 */
@Service
public class PwbhJlYqybServiceImpl implements PwbhJlYqybService {

    @Resource
    private PwbhJlYqybMapper pwbhJlYqybMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlYqybMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlYqyb record) {
        return pwbhJlYqybMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlYqyb record) {
        return pwbhJlYqybMapper.insertSelective(record);
    }

    @Override
    public PwbhJlYqyb selectByPrimaryKey(String id) {
        return pwbhJlYqybMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlYqyb record) {
        return pwbhJlYqybMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlYqyb record) {
        return pwbhJlYqybMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<PwbhJlYqyb> list) {
        return pwbhJlYqybMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlYqyb> list) {
        return pwbhJlYqybMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlYqyb> list) {
        return pwbhJlYqybMapper.batchInsert(list);
    }

    @Override
    public List<PwbhJlYqyb> selectByAll(PwbhJlYqyb pwbhJlYqyb) {
        return pwbhJlYqybMapper.selectByAll(pwbhJlYqyb);
    }
}

