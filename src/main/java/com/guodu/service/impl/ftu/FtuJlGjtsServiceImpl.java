package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJlGjtsMapper;
import com.guodu.pojo.ftu.FtuJlGjts;
import com.guodu.service.ftu.FtuJlGjtsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJlGjtsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:05 下午
 */
@Service
public class FtuJlGjtsServiceImpl implements FtuJlGjtsService {

    @Resource
    private FtuJlGjtsMapper ftuJlGjtsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuJlGjtsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuJlGjts record) {
        return ftuJlGjtsMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(FtuJlGjts record) {
        return ftuJlGjtsMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(FtuJlGjts record) {
        return ftuJlGjtsMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(FtuJlGjts record) {
        return ftuJlGjtsMapper.insertSelective(record);
    }

    @Override
    public FtuJlGjts selectByPrimaryKey(String id) {
        return ftuJlGjtsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJlGjts record) {
        return ftuJlGjtsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJlGjts record) {
        return ftuJlGjtsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJlGjts> selectByAll(FtuJlGjts ftuJlGjts) {
        return ftuJlGjtsMapper.selectByAll(ftuJlGjts);
    }

    @Override
    public int updateBatch(List<FtuJlGjts> list) {
        return ftuJlGjtsMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJlGjts> list) {
        return ftuJlGjtsMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJlGjts> list) {
        return ftuJlGjtsMapper.batchInsert(list);
    }

}

