package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJlDzjcMapper;
import com.guodu.pojo.pwbh.PwbhJlDzjc;
import com.guodu.service.pwbh.PwbhJlDzjcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PwbhJlDzjcServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:03 下午
 */
@Service
public class PwbhJlDzjcServiceImpl implements PwbhJlDzjcService {

    @Resource
    private PwbhJlDzjcMapper pwbhJlDzjcMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhJlDzjcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhJlDzjc record) {
        return pwbhJlDzjcMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJlDzjc record) {
        return pwbhJlDzjcMapper.insertSelective(record);
    }

    @Override
    public PwbhJlDzjc selectByPrimaryKey(String id) {
        return pwbhJlDzjcMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJlDzjc record) {
        return pwbhJlDzjcMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJlDzjc record) {
        return pwbhJlDzjcMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhJlDzjc> selectByAll(PwbhJlDzjc pwbhJlDzjc) {
        return pwbhJlDzjcMapper.selectByAll(pwbhJlDzjc);
    }

    @Override
    public int updateBatch(List<PwbhJlDzjc> list) {
        return pwbhJlDzjcMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PwbhJlDzjc> list) {
        return pwbhJlDzjcMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PwbhJlDzjc> list) {
        return pwbhJlDzjcMapper.batchInsert(list);
    }

}


