package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJlTyjcMapper;
import com.guodu.pojo.ftu.FtuJlTyjc;
import com.guodu.service.ftu.FtuJlTyjcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJlTyjcServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:07 下午
 */
@Service
public class FtuJlTyjcServiceImpl implements FtuJlTyjcService {

    @Resource
    private FtuJlTyjcMapper ftuJlTyjcMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuJlTyjcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuJlTyjc record) {
        return ftuJlTyjcMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(FtuJlTyjc record) {
        return ftuJlTyjcMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(FtuJlTyjc record) {
        return ftuJlTyjcMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(FtuJlTyjc record) {
        return ftuJlTyjcMapper.insertSelective(record);
    }

    @Override
    public FtuJlTyjc selectByPrimaryKey(String id) {
        return ftuJlTyjcMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJlTyjc record) {
        return ftuJlTyjcMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJlTyjc record) {
        return ftuJlTyjcMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJlTyjc> selectByAll(FtuJlTyjc ftuJlTyjc) {
        return ftuJlTyjcMapper.selectByAll(ftuJlTyjc);
    }

    @Override
    public int updateBatch(List<FtuJlTyjc> list) {
        return ftuJlTyjcMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJlTyjc> list) {
        return ftuJlTyjcMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJlTyjc> list) {
        return ftuJlTyjcMapper.batchInsert(list);
    }

}
