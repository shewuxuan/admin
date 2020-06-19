package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJlYkcdMapper;
import com.guodu.pojo.ftu.FtuJlYkcd;
import com.guodu.service.ftu.FtuJlYkcdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJlYkcdServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:08 下午
 */
@Service
public class FtuJlYkcdServiceImpl implements FtuJlYkcdService {

    @Resource
    private FtuJlYkcdMapper ftuJlYkcdMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuJlYkcdMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuJlYkcd record) {
        return ftuJlYkcdMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(FtuJlYkcd record) {
        return ftuJlYkcdMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(FtuJlYkcd record) {
        return ftuJlYkcdMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(FtuJlYkcd record) {
        return ftuJlYkcdMapper.insertSelective(record);
    }

    @Override
    public FtuJlYkcd selectByPrimaryKey(String id) {
        return ftuJlYkcdMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJlYkcd record) {
        return ftuJlYkcdMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJlYkcd record) {
        return ftuJlYkcdMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJlYkcd> selectByAll(FtuJlYkcd ftuJlYkcd) {
        return ftuJlYkcdMapper.selectByAll(ftuJlYkcd);
    }

    @Override
    public int updateBatch(List<FtuJlYkcd> list) {
        return ftuJlYkcdMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJlYkcd> list) {
        return ftuJlYkcdMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJlYkcd> list) {
        return ftuJlYkcdMapper.batchInsert(list);
    }

}
