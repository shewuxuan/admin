package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhDzMapper;
import com.guodu.pojo.pwbh.PwbhDz;
import com.guodu.service.pwbh.PwbhDzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhDzServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/29 1:09 下午
 */
@Service
public class PwbhDzServiceImpl implements PwbhDzService {

    @Resource
    private PwbhDzMapper pwbhDzMapper;

    @Override
    public int deleteByPrimaryKey(String tsid) {
        return pwbhDzMapper.deleteByPrimaryKey(tsid);
    }

    @Override
    public int insert(PwbhDz record) {
        return pwbhDzMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhDz record) {
        return pwbhDzMapper.insertSelective(record);
    }

    @Override
    public PwbhDz selectByPrimaryKey(String tsid) {
        return pwbhDzMapper.selectByPrimaryKey(tsid);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhDz record) {
        return pwbhDzMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhDz record) {
        return pwbhDzMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhDz> selectByAll(PwbhDz pwbhDz) {
        return pwbhDzMapper.selectByAll(pwbhDz);
    }

    @Override
    public int updateBatch(List<PwbhDz> list) {
        return pwbhDzMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhDz> list) {
        return pwbhDzMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhDz> list) {
        return pwbhDzMapper.batchInsert(list);
    }
}


