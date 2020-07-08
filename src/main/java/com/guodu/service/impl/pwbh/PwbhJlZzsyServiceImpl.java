package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlZzsyMapper;
import com.guodu.pojo.pwbh.PwbhJlZzsy;
import com.guodu.service.pwbh.PwbhJlZzsyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlZzsyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/15 4:20 下午
 */
@Service
public class PwbhJlZzsyServiceImpl implements PwbhJlZzsyService{

    @Resource
    private PwbhJlZzsyMapper pwbhJlZzsyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlZzsyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlZzsy record) {
        return pwbhJlZzsyMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlZzsy record) {
        return pwbhJlZzsyMapper.insertSelective(record);
    }

    @Override
    public PwbhJlZzsy selectByPrimaryKey(String id) {
        return pwbhJlZzsyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlZzsy record) {
        return pwbhJlZzsyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlZzsy record) {
        return pwbhJlZzsyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhJlZzsy> selectByAll(PwbhJlZzsy pwbhJlZzsy) {
        return pwbhJlZzsyMapper.selectByAll(pwbhJlZzsy);
    }

    @Override
    public int updateBatch(List<PwbhJlZzsy> list) {
        return pwbhJlZzsyMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlZzsy> list) {
        return pwbhJlZzsyMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlZzsy> list) {
        return pwbhJlZzsyMapper.batchInsert(list);
    }

}
