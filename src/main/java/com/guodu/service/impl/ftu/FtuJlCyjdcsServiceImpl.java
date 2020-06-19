package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJlCyjdcsMapper;
import com.guodu.pojo.ftu.FtuJlCyjdcs;
import com.guodu.service.ftu.FtuJlCyjdcsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJlCyjdcsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:04 下午
 */
@Service
public class FtuJlCyjdcsServiceImpl implements FtuJlCyjdcsService {

    @Resource
    private FtuJlCyjdcsMapper ftuJlCyjdcsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuJlCyjdcsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuJlCyjdcs record) {
        return ftuJlCyjdcsMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(FtuJlCyjdcs record) {
        return ftuJlCyjdcsMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(FtuJlCyjdcs record) {
        return ftuJlCyjdcsMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(FtuJlCyjdcs record) {
        return ftuJlCyjdcsMapper.insertSelective(record);
    }

    @Override
    public FtuJlCyjdcs selectByPrimaryKey(String id) {
        return ftuJlCyjdcsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJlCyjdcs record) {
        return ftuJlCyjdcsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJlCyjdcs record) {
        return ftuJlCyjdcsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJlCyjdcs> selectByAll(FtuJlCyjdcs ftuJlCyjdcs) {
        return ftuJlCyjdcsMapper.selectByAll(ftuJlCyjdcs);
    }

    @Override
    public int updateBatch(List<FtuJlCyjdcs> list) {
        return ftuJlCyjdcsMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJlCyjdcs> list) {
        return ftuJlCyjdcsMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJlCyjdcs> list) {
        return ftuJlCyjdcsMapper.batchInsert(list);
    }

}
