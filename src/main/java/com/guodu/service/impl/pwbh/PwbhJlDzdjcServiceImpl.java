package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlDzdjcMapper;
import com.guodu.pojo.pwbh.PwbhJlDzdjc;
import com.guodu.service.pwbh.PwbhJlDzdjcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlDzdjcServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:02 下午
 */
@Service
public class PwbhJlDzdjcServiceImpl implements PwbhJlDzdjcService{

    @Resource
    private PwbhJlDzdjcMapper pwbhJlDzdjcMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlDzdjcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlDzdjc record) {
        return pwbhJlDzdjcMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlDzdjc record) {
        return pwbhJlDzdjcMapper.insertSelective(record);
    }

    @Override
    public PwbhJlDzdjc selectByPrimaryKey(String id) {
        return pwbhJlDzdjcMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlDzdjc record) {
        return pwbhJlDzdjcMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlDzdjc record) {
        return pwbhJlDzdjcMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhJlDzdjc> selectByAll(PwbhJlDzdjc pwbhJlDzdjc) {
        return pwbhJlDzdjcMapper.selectByAll(pwbhJlDzdjc);
    }

    @Override
    public int updateBatch(List<PwbhJlDzdjc> list) {
        return pwbhJlDzdjcMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlDzdjc> list) {
        return pwbhJlDzdjcMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlDzdjc> list) {
        return pwbhJlDzdjcMapper.batchInsert(list);
    }

}
