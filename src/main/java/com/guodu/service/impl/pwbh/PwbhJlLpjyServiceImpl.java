package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlLpjyMapper;
import com.guodu.pojo.pwbh.PwbhJlLpjy;
import com.guodu.service.pwbh.PwbhJlLpjyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlLpjyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:03 下午
 */
@Service
public class PwbhJlLpjyServiceImpl implements PwbhJlLpjyService {

    @Resource
    private PwbhJlLpjyMapper pwbhJlLpjyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlLpjyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlLpjy record) {
        return pwbhJlLpjyMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlLpjy record) {
        return pwbhJlLpjyMapper.insertSelective(record);
    }

    @Override
    public PwbhJlLpjy selectByPrimaryKey(String id) {
        return pwbhJlLpjyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlLpjy record) {
        return pwbhJlLpjyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlLpjy record) {
        return pwbhJlLpjyMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<PwbhJlLpjy> list) {
        return pwbhJlLpjyMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlLpjy> list) {
        return pwbhJlLpjyMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlLpjy> list) {
        return pwbhJlLpjyMapper.batchInsert(list);
    }

    @Override
    public List<PwbhJlLpjy> selectByAll(PwbhJlLpjy pwbhJlLpjy) {
        return pwbhJlLpjyMapper.selectByAll(pwbhJlLpjy);
    }
}

