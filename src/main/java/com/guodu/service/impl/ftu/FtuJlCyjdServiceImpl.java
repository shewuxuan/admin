package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJlCyjdMapper;
import com.guodu.pojo.ftu.FtuJlCyjd;
import com.guodu.service.ftu.FtuJlCyjdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJlCyjdServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:03 下午
 */
@Service
public class FtuJlCyjdServiceImpl implements FtuJlCyjdService {

    @Resource
    private FtuJlCyjdMapper ftuJlCyjdMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuJlCyjdMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuJlCyjd record) {
        return ftuJlCyjdMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(FtuJlCyjd record) {
        return ftuJlCyjdMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(FtuJlCyjd record) {
        return ftuJlCyjdMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(FtuJlCyjd record) {
        return ftuJlCyjdMapper.insertSelective(record);
    }

    @Override
    public FtuJlCyjd selectByPrimaryKey(String id) {
        return ftuJlCyjdMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJlCyjd record) {
        return ftuJlCyjdMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJlCyjd record) {
        return ftuJlCyjdMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJlCyjd> selectByAll(FtuJlCyjd ftuJlCyjd) {
        return ftuJlCyjdMapper.selectByAll(ftuJlCyjd);
    }

    @Override
    public int updateBatch(List<FtuJlCyjd> list) {
        return ftuJlCyjdMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJlCyjd> list) {
        return ftuJlCyjdMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJlCyjd> list) {
        return ftuJlCyjdMapper.batchInsert(list);
    }

}
