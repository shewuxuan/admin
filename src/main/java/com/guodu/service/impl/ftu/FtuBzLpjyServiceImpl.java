package com.guodu.service.impl.ftu;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.guodu.mapper.ftu.FtuBzLpjyMapper;
import com.guodu.pojo.ftu.FtuBzLpjy;
import com.guodu.service.ftu.FtuBzLpjyService;
/**
 * @ClassName: FtuBzLpjyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:22 下午
 */
@Service
public class FtuBzLpjyServiceImpl implements FtuBzLpjyService{

    @Resource
    private FtuBzLpjyMapper ftuBzLpjyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuBzLpjyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuBzLpjy record) {
        return ftuBzLpjyMapper.insert(record);
    }

    @Override
    public int insertSelective(FtuBzLpjy record) {
        return ftuBzLpjyMapper.insertSelective(record);
    }

    @Override
    public FtuBzLpjy selectByPrimaryKey(String id) {
        return ftuBzLpjyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuBzLpjy record) {
        return ftuBzLpjyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuBzLpjy record) {
        return ftuBzLpjyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuBzLpjy> selectByAll(FtuBzLpjy ftuBzLpjy) {
        return ftuBzLpjyMapper.selectByAll(ftuBzLpjy);
    }

    @Override
    public int updateBatch(List<FtuBzLpjy> list) {
        return ftuBzLpjyMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<FtuBzLpjy> list) {
        return ftuBzLpjyMapper.batchInsert(list);
    }

    @Override
    public List<FtuBzLpjy> selectByPage(FtuBzLpjy record) {
        return ftuBzLpjyMapper.selectByPage(record);
    }

}
