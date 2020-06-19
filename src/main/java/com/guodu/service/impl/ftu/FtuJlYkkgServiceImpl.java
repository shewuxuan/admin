package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJlYkkgMapper;
import com.guodu.pojo.ftu.FtuJlYkkg;
import com.guodu.service.ftu.FtuJlYkkgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJlYkkgServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:08 下午
 */
@Service
public class FtuJlYkkgServiceImpl implements FtuJlYkkgService {

    @Resource
    private FtuJlYkkgMapper ftuJlYkkgMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuJlYkkgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuJlYkkg record) {
        return ftuJlYkkgMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(FtuJlYkkg record) {
        return ftuJlYkkgMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(FtuJlYkkg record) {
        return ftuJlYkkgMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(FtuJlYkkg record) {
        return ftuJlYkkgMapper.insertSelective(record);
    }

    @Override
    public FtuJlYkkg selectByPrimaryKey(String id) {
        return ftuJlYkkgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJlYkkg record) {
        return ftuJlYkkgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJlYkkg record) {
        return ftuJlYkkgMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJlYkkg> selectByAll(FtuJlYkkg ftuJlYkkg) {
        return ftuJlYkkgMapper.selectByAll(ftuJlYkkg);
    }

    @Override
    public int updateBatch(List<FtuJlYkkg> list) {
        return ftuJlYkkgMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJlYkkg> list) {
        return ftuJlYkkgMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJlYkkg> list) {
        return ftuJlYkkgMapper.batchInsert(list);
    }

}
