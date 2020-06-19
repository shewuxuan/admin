package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJlKgdzMapper;
import com.guodu.pojo.ftu.FtuJlKgdz;
import com.guodu.service.ftu.FtuJlKgdzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJlKgdzServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:07 下午
 */
@Service
public class FtuJlKgdzServiceImpl implements FtuJlKgdzService {

    @Resource
    private FtuJlKgdzMapper ftuJlKgdzMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuJlKgdzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuJlKgdz record) {
        return ftuJlKgdzMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(FtuJlKgdz record) {
        return ftuJlKgdzMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(FtuJlKgdz record) {
        return ftuJlKgdzMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(FtuJlKgdz record) {
        return ftuJlKgdzMapper.insertSelective(record);
    }

    @Override
    public FtuJlKgdz selectByPrimaryKey(String id) {
        return ftuJlKgdzMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJlKgdz record) {
        return ftuJlKgdzMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJlKgdz record) {
        return ftuJlKgdzMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJlKgdz> selectByAll(FtuJlKgdz ftuJlKgdz) {
        return ftuJlKgdzMapper.selectByAll(ftuJlKgdz);
    }

    @Override
    public int updateBatch(List<FtuJlKgdz> list) {
        return ftuJlKgdzMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJlKgdz> list) {
        return ftuJlKgdzMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJlKgdz> list) {
        return ftuJlKgdzMapper.batchInsert(list);
    }

}
