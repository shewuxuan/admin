package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlBhctjxMapper;
import com.guodu.pojo.pwbh.PwbhJlBhctjx;
import com.guodu.service.pwbh.PwbhJlBhctjxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlBhctjxServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:02 下午
 */
@Service
public class PwbhJlBhctjxServiceImpl implements PwbhJlBhctjxService{

    @Resource
    private PwbhJlBhctjxMapper pwbhJlBhctjxMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlBhctjxMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlBhctjx record) {
        return pwbhJlBhctjxMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlBhctjx record) {
        return pwbhJlBhctjxMapper.insertSelective(record);
    }

    @Override
    public PwbhJlBhctjx selectByPrimaryKey(String id) {
        return pwbhJlBhctjxMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlBhctjx record) {
        return pwbhJlBhctjxMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlBhctjx record) {
        return pwbhJlBhctjxMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhJlBhctjx> selectByAll(PwbhJlBhctjx pwbhJlBhctjx) {
        return pwbhJlBhctjxMapper.selectByAll(pwbhJlBhctjx);
    }

    @Override
    public int updateBatch(List<PwbhJlBhctjx> list) {
        return pwbhJlBhctjxMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlBhctjx> list) {
        return pwbhJlBhctjxMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlBhctjx> list) {
        return pwbhJlBhctjxMapper.batchInsert(list);
    }

}
