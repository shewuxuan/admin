package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlBhctbhMapper;
import com.guodu.pojo.pwbh.PwbhJlBhctbh;
import com.guodu.service.pwbh.PwbhJlBhctbhService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlBhctbhServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:02 下午
 */
@Service
public class PwbhJlBhctbhServiceImpl implements PwbhJlBhctbhService{

    @Resource
    private PwbhJlBhctbhMapper pwbhJlBhctbhMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlBhctbhMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlBhctbh record) {
        return pwbhJlBhctbhMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlBhctbh record) {
        return pwbhJlBhctbhMapper.insertSelective(record);
    }

    @Override
    public PwbhJlBhctbh selectByPrimaryKey(String id) {
        return pwbhJlBhctbhMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlBhctbh record) {
        return pwbhJlBhctbhMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlBhctbh record) {
        return pwbhJlBhctbhMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhJlBhctbh> selectByAll(PwbhJlBhctbh pwbhJlBhctbh) {
        return pwbhJlBhctbhMapper.selectByAll(pwbhJlBhctbh);
    }

    @Override
    public int updateBatch(List<PwbhJlBhctbh> list) {
        return pwbhJlBhctbhMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlBhctbh> list) {
        return pwbhJlBhctbhMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlBhctbh> list) {
        return pwbhJlBhctbhMapper.batchInsert(list);
    }

}
