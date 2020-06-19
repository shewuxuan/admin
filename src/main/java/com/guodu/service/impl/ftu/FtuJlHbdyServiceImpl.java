package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJlHbdyMapper;
import com.guodu.pojo.ftu.FtuJlHbdy;
import com.guodu.service.ftu.FtuJlHbdyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJlHbdyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:06 下午
 */
@Service
public class FtuJlHbdyServiceImpl implements FtuJlHbdyService {

    @Resource
    private FtuJlHbdyMapper ftuJlHbdyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuJlHbdyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuJlHbdy record) {
        return ftuJlHbdyMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(FtuJlHbdy record) {
        return ftuJlHbdyMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(FtuJlHbdy record) {
        return ftuJlHbdyMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(FtuJlHbdy record) {
        return ftuJlHbdyMapper.insertSelective(record);
    }

    @Override
    public FtuJlHbdy selectByPrimaryKey(String id) {
        return ftuJlHbdyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJlHbdy record) {
        return ftuJlHbdyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJlHbdy record) {
        return ftuJlHbdyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJlHbdy> selectByAll(FtuJlHbdy ftuJlHbdy) {
        return ftuJlHbdyMapper.selectByAll(ftuJlHbdy);
    }

    @Override
    public int updateBatch(List<FtuJlHbdy> list) {
        return ftuJlHbdyMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJlHbdy> list) {
        return ftuJlHbdyMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJlHbdy> list) {
        return ftuJlHbdyMapper.batchInsert(list);
    }

}
