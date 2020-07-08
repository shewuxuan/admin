package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlJxdxMapper;
import com.guodu.pojo.pwbh.PwbhJlJxdx;
import com.guodu.service.pwbh.PwbhJlJxdxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlJxdxServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:03 下午
 */
@Service
public class PwbhJlJxdxServiceImpl implements PwbhJlJxdxService{

    @Resource
    private PwbhJlJxdxMapper pwbhJlJxdxMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlJxdxMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlJxdx record) {
        return pwbhJlJxdxMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlJxdx record) {
        return pwbhJlJxdxMapper.insertSelective(record);
    }

    @Override
    public PwbhJlJxdx selectByPrimaryKey(String id) {
        return pwbhJlJxdxMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlJxdx record) {
        return pwbhJlJxdxMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlJxdx record) {
        return pwbhJlJxdxMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhJlJxdx> selectByAll(PwbhJlJxdx pwbhJlJxdx) {
        return pwbhJlJxdxMapper.selectByAll(pwbhJlJxdx);
    }

    @Override
    public int updateBatch(List<PwbhJlJxdx> list) {
        return pwbhJlJxdxMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlJxdx> list) {
        return pwbhJlJxdxMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlJxdx> list) {
        return pwbhJlJxdxMapper.batchInsert(list);
    }

}
