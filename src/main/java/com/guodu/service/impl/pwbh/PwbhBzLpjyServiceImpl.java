package com.guodu.service.impl.pwbh;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.guodu.mapper.pwbh.PwbhBzLpjyMapper;
import com.guodu.pojo.pwbh.PwbhBzLpjy;
import com.guodu.service.pwbh.PwbhBzLpjyService;
/**
 * @ClassName: PwbhBzLpjyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 3:00 下午
 */
@Service
public class PwbhBzLpjyServiceImpl implements PwbhBzLpjyService{

    @Resource
    private PwbhBzLpjyMapper pwbhBzLpjyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhBzLpjyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhBzLpjy record) {
        return pwbhBzLpjyMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhBzLpjy record) {
        return pwbhBzLpjyMapper.insertSelective(record);
    }

    @Override
    public PwbhBzLpjy selectByPrimaryKey(String id) {
        return pwbhBzLpjyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhBzLpjy record) {
        return pwbhBzLpjyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhBzLpjy record) {
        return pwbhBzLpjyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhBzLpjy> selectByAll(PwbhBzLpjy pwbhBzLpjy) {
        return pwbhBzLpjyMapper.selectByAll(pwbhBzLpjy);
    }

    @Override
    public int updateBatch(List<PwbhBzLpjy> list) {
        return pwbhBzLpjyMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<PwbhBzLpjy> list) {
        return pwbhBzLpjyMapper.batchInsert(list);
    }

    @Override
    public List<PwbhBzLpjy> selectByPage(PwbhBzLpjy record) {
        return pwbhBzLpjyMapper.selectByPage(record);
    }

}
