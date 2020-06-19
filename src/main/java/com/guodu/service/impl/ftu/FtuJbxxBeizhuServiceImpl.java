package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJbxxBeizhuMapper;
import com.guodu.pojo.ftu.FtuJbxxBeizhu;
import com.guodu.service.ftu.FtuJbxxBeizhuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJbxxBeizhuServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/14 10:46 上午
 */
@Service
public class FtuJbxxBeizhuServiceImpl implements FtuJbxxBeizhuService {

    @Resource
    private FtuJbxxBeizhuMapper ftuJbxxBeizhuMapper;

    @Override
    public int deleteByPrimaryKey(String tsid) {
        return ftuJbxxBeizhuMapper.deleteByPrimaryKey(tsid);
    }

    @Override
    public int insert(FtuJbxxBeizhu record) {
        return ftuJbxxBeizhuMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(FtuJbxxBeizhu record) {
        return ftuJbxxBeizhuMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(FtuJbxxBeizhu record) {
        return ftuJbxxBeizhuMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(FtuJbxxBeizhu record) {
        return ftuJbxxBeizhuMapper.insertSelective(record);
    }

    @Override
    public FtuJbxxBeizhu selectByPrimaryKey(String tsid) {
        return ftuJbxxBeizhuMapper.selectByPrimaryKey(tsid);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJbxxBeizhu record) {
        return ftuJbxxBeizhuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJbxxBeizhu record) {
        return ftuJbxxBeizhuMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<FtuJbxxBeizhu> list) {
        return ftuJbxxBeizhuMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJbxxBeizhu> list) {
        return ftuJbxxBeizhuMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJbxxBeizhu> list) {
        return ftuJbxxBeizhuMapper.batchInsert(list);
    }

}
