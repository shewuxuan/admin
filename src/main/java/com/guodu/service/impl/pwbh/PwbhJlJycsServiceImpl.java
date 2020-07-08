package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlJycsMapper;
import com.guodu.pojo.pwbh.PwbhJlJycs;
import com.guodu.service.pwbh.PwbhJlJycsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlJycsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:03 下午
 */
@Service
public class PwbhJlJycsServiceImpl implements PwbhJlJycsService{

    @Resource
    private PwbhJlJycsMapper pwbhJlJycsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlJycsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlJycs record) {
        return pwbhJlJycsMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlJycs record) {
        return pwbhJlJycsMapper.insertSelective(record);
    }

    @Override
    public PwbhJlJycs selectByPrimaryKey(String id) {
        return pwbhJlJycsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlJycs record) {
        return pwbhJlJycsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlJycs record) {
        return pwbhJlJycsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhJlJycs> selectByAll(PwbhJlJycs pwbhJlJycs) {
        return pwbhJlJycsMapper.selectByAll(pwbhJlJycs);
    }

    @Override
    public int updateBatch(List<PwbhJlJycs> list) {
        return pwbhJlJycsMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlJycs> list) {
        return pwbhJlJycsMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlJycs> list) {
        return pwbhJlJycsMapper.batchInsert(list);
    }

}
