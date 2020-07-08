package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlBhcthlMapper;
import com.guodu.pojo.pwbh.PwbhJlBhcthl;
import com.guodu.service.pwbh.PwbhJlBhcthlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlBhcthlServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:02 下午
 */
@Service
public class PwbhJlBhcthlServiceImpl implements PwbhJlBhcthlService{

    @Resource
    private PwbhJlBhcthlMapper pwbhJlBhcthlMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlBhcthlMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlBhcthl record) {
        return pwbhJlBhcthlMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlBhcthl record) {
        return pwbhJlBhcthlMapper.insertSelective(record);
    }

    @Override
    public PwbhJlBhcthl selectByPrimaryKey(String id) {
        return pwbhJlBhcthlMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlBhcthl record) {
        return pwbhJlBhcthlMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlBhcthl record) {
        return pwbhJlBhcthlMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhJlBhcthl> selectByAll(PwbhJlBhcthl pwbhJlBhcthl) {
        return pwbhJlBhcthlMapper.selectByAll(pwbhJlBhcthl);
    }

    @Override
    public int updateBatch(List<PwbhJlBhcthl> list) {
        return pwbhJlBhcthlMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlBhcthl> list) {
        return pwbhJlBhcthlMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlBhcthl> list) {
        return pwbhJlBhcthlMapper.batchInsert(list);
    }

}
