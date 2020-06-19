package com.guodu.service.impl.ftu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.pojo.ftu.FtuBzCyjd;
import com.guodu.mapper.ftu.FtuBzCyjdMapper;
import com.guodu.service.ftu.FtuBzCyjdService;

/**
 * @ClassName: FtuBzCyjdServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:16 下午
 */
@Service
public class FtuBzCyjdServiceImpl implements FtuBzCyjdService {

    @Resource
    private FtuBzCyjdMapper ftuBzCyjdMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuBzCyjdMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuBzCyjd record) {
        return ftuBzCyjdMapper.insert(record);
    }

    @Override
    public int insertSelective(FtuBzCyjd record) {
        return ftuBzCyjdMapper.insertSelective(record);
    }

    @Override
    public FtuBzCyjd selectByPrimaryKey(String id) {
        return ftuBzCyjdMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuBzCyjd record) {
        return ftuBzCyjdMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuBzCyjd record) {
        return ftuBzCyjdMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuBzCyjd> selectByAll(FtuBzCyjd ftuBzCyjd) {
        return ftuBzCyjdMapper.selectByAll(ftuBzCyjd);
    }

    @Override
    public int updateBatch(List<FtuBzCyjd> list) {
        return ftuBzCyjdMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<FtuBzCyjd> list) {
        return ftuBzCyjdMapper.batchInsert(list);
    }

    @Override
    public List<FtuBzCyjd> selectByPage(FtuBzCyjd record) {
        return ftuBzCyjdMapper.selectByPage(record);
    }

}

