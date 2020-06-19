package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJlGncsMapper;
import com.guodu.pojo.ftu.FtuJlGncs;
import com.guodu.service.ftu.FtuJlGncsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJlGncsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:06 下午
 */
@Service
public class FtuJlGncsServiceImpl implements FtuJlGncsService {

    @Resource
    private FtuJlGncsMapper ftuJlGncsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuJlGncsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuJlGncs record) {
        return ftuJlGncsMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(FtuJlGncs record) {
        return ftuJlGncsMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(FtuJlGncs record) {
        return ftuJlGncsMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(FtuJlGncs record) {
        return ftuJlGncsMapper.insertSelective(record);
    }

    @Override
    public FtuJlGncs selectByPrimaryKey(String id) {
        return ftuJlGncsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJlGncs record) {
        return ftuJlGncsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJlGncs record) {
        return ftuJlGncsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJlGncs> selectByAll(FtuJlGncs ftuJlGncs) {
        return ftuJlGncsMapper.selectByAll(ftuJlGncs);
    }

    @Override
    public int updateBatch(List<FtuJlGncs> list) {
        return ftuJlGncsMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJlGncs> list) {
        return ftuJlGncsMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJlGncs> list) {
        return ftuJlGncsMapper.batchInsert(list);
    }

}
