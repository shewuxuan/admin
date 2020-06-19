package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJlLpjyMapper;
import com.guodu.pojo.ftu.FtuJlLpjy;
import com.guodu.service.ftu.FtuJlLpjyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJlLpjyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:07 下午
 */
@Service
public class FtuJlLpjyServiceImpl implements FtuJlLpjyService {

    @Resource
    private FtuJlLpjyMapper ftuJlLpjyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuJlLpjyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuJlLpjy record) {
        return ftuJlLpjyMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(FtuJlLpjy record) {
        return ftuJlLpjyMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(FtuJlLpjy record) {
        return ftuJlLpjyMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(FtuJlLpjy record) {
        return ftuJlLpjyMapper.insertSelective(record);
    }

    @Override
    public FtuJlLpjy selectByPrimaryKey(String id) {
        return ftuJlLpjyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJlLpjy record) {
        return ftuJlLpjyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJlLpjy record) {
        return ftuJlLpjyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJlLpjy> selectByAll(FtuJlLpjy ftuJlLpjy) {
        return ftuJlLpjyMapper.selectByAll(ftuJlLpjy);
    }

    @Override
    public int updateBatch(List<FtuJlLpjy> list) {
        return ftuJlLpjyMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJlLpjy> list) {
        return ftuJlLpjyMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJlLpjy> list) {
        return ftuJlLpjyMapper.batchInsert(list);
    }

}
