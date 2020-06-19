package com.guodu.service.impl.ftu;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.guodu.mapper.ftu.FtuBzHbdyMapper;
import java.util.List;
import com.guodu.pojo.ftu.FtuBzHbdy;
import com.guodu.service.ftu.FtuBzHbdyService;
/**
 * @ClassName: FtuBzHbdyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:21 下午
 */
@Service
public class FtuBzHbdyServiceImpl implements FtuBzHbdyService{

    @Resource
    private FtuBzHbdyMapper ftuBzHbdyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuBzHbdyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuBzHbdy record) {
        return ftuBzHbdyMapper.insert(record);
    }

    @Override
    public int insertSelective(FtuBzHbdy record) {
        return ftuBzHbdyMapper.insertSelective(record);
    }

    @Override
    public FtuBzHbdy selectByPrimaryKey(String id) {
        return ftuBzHbdyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuBzHbdy record) {
        return ftuBzHbdyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuBzHbdy record) {
        return ftuBzHbdyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuBzHbdy> selectByAll(FtuBzHbdy ftuBzHbdy) {
        return ftuBzHbdyMapper.selectByAll(ftuBzHbdy);
    }

    @Override
    public int updateBatch(List<FtuBzHbdy> list) {
        return ftuBzHbdyMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<FtuBzHbdy> list) {
        return ftuBzHbdyMapper.batchInsert(list);
    }

    @Override
    public List<FtuBzHbdy> selectByPage(FtuBzHbdy record) {
        return ftuBzHbdyMapper.selectByPage(record);
    }

}
