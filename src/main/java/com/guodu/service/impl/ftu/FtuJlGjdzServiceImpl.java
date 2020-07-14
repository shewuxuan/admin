package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJlGjdzMapper;
import com.guodu.pojo.ftu.FtuJlGjdz;
import com.guodu.service.ftu.FtuJlGjdzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJlGjdzServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:05 下午
 */
@Service
public class FtuJlGjdzServiceImpl implements FtuJlGjdzService {

    @Resource
    private FtuJlGjdzMapper ftuJlGjdzMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuJlGjdzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuJlGjdz record) {
        return ftuJlGjdzMapper.insert(record);
    }

    @Override
    public int insertSelective(FtuJlGjdz record) {
        return ftuJlGjdzMapper.insertSelective(record);
    }

    @Override
    public FtuJlGjdz selectByPrimaryKey(String id) {
        return ftuJlGjdzMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJlGjdz record) {
        return ftuJlGjdzMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJlGjdz record) {
        return ftuJlGjdzMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJlGjdz> selectByAll(FtuJlGjdz ftuJlGjdz) {
        return ftuJlGjdzMapper.selectByAll(ftuJlGjdz);
    }

    @Override
    public int updateBatch(List<FtuJlGjdz> list) {
        return ftuJlGjdzMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJlGjdz> list) {
        return ftuJlGjdzMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJlGjdz> list) {
        return ftuJlGjdzMapper.batchInsert(list);
    }

}
