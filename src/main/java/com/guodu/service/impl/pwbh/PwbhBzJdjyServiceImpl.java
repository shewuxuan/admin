package com.guodu.service.impl.pwbh;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.guodu.mapper.pwbh.PwbhBzJdjyMapper;
import com.guodu.pojo.pwbh.PwbhBzJdjy;
import com.guodu.service.pwbh.PwbhBzJdjyService;
/**
 * @ClassName: PwbhBzJdjyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:58 下午
 */
@Service
public class PwbhBzJdjyServiceImpl implements PwbhBzJdjyService{

    @Resource
    private PwbhBzJdjyMapper pwbhBzJdjyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhBzJdjyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhBzJdjy record) {
        return pwbhBzJdjyMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhBzJdjy record) {
        return pwbhBzJdjyMapper.insertSelective(record);
    }

    @Override
    public PwbhBzJdjy selectByPrimaryKey(String id) {
        return pwbhBzJdjyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhBzJdjy record) {
        return pwbhBzJdjyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhBzJdjy record) {
        return pwbhBzJdjyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhBzJdjy> selectByAll(PwbhBzJdjy pwbhBzJdjy) {
        return pwbhBzJdjyMapper.selectByAll(pwbhBzJdjy);
    }

    @Override
    public int updateBatch(List<PwbhBzJdjy> list) {
        return pwbhBzJdjyMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<PwbhBzJdjy> list) {
        return pwbhBzJdjyMapper.batchInsert(list);
    }

    @Override
    public List<PwbhBzJdjy> selectByPage(PwbhBzJdjy record) {
        return pwbhBzJdjyMapper.selectByPage(record);
    }

}
