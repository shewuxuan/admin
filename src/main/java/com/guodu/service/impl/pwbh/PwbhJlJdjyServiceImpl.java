package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlJdjyMapper;
import com.guodu.pojo.pwbh.PwbhJlJdjy;
import com.guodu.service.pwbh.PwbhJlJdjyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlJdjyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:03 下午
 */
@Service
public class PwbhJlJdjyServiceImpl implements PwbhJlJdjyService{

    @Resource
    private PwbhJlJdjyMapper pwbhJlJdjyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlJdjyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlJdjy record) {
        return pwbhJlJdjyMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlJdjy record) {
        return pwbhJlJdjyMapper.insertSelective(record);
    }

    @Override
    public PwbhJlJdjy selectByPrimaryKey(String id) {
        return pwbhJlJdjyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlJdjy record) {
        return pwbhJlJdjyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlJdjy record) {
        return pwbhJlJdjyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhJlJdjy> selectByAll(PwbhJlJdjy pwbhJlJdjy) {
        return pwbhJlJdjyMapper.selectByAll(pwbhJlJdjy);
    }

    @Override
    public int updateBatch(List<PwbhJlJdjy> list) {
        return pwbhJlJdjyMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlJdjy> list) {
        return pwbhJlJdjyMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlJdjy> list) {
        return pwbhJlJdjyMapper.batchInsert(list);
    }

}
