package com.guodu.service.impl.ftu;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.guodu.mapper.ftu.FtuBzTyjcMapper;
import com.guodu.pojo.ftu.FtuBzTyjc;
import com.guodu.service.ftu.FtuBzTyjcService;
/**
 * @ClassName: FtuBzTyjcServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:22 下午
 */
@Service
public class FtuBzTyjcServiceImpl implements FtuBzTyjcService{

    @Resource
    private FtuBzTyjcMapper ftuBzTyjcMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuBzTyjcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuBzTyjc record) {
        return ftuBzTyjcMapper.insert(record);
    }

    @Override
    public int insertSelective(FtuBzTyjc record) {
        return ftuBzTyjcMapper.insertSelective(record);
    }

    @Override
    public FtuBzTyjc selectByPrimaryKey(String id) {
        return ftuBzTyjcMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuBzTyjc record) {
        return ftuBzTyjcMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuBzTyjc record) {
        return ftuBzTyjcMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuBzTyjc> selectByAll(FtuBzTyjc ftuBzTyjc) {
        return ftuBzTyjcMapper.selectByAll(ftuBzTyjc);
    }

    @Override
    public int updateBatch(List<FtuBzTyjc> list) {
        return ftuBzTyjcMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<FtuBzTyjc> list) {
        return ftuBzTyjcMapper.batchInsert(list);
    }

    @Override
    public List<FtuBzTyjc> selectByPage(FtuBzTyjc record) {
        return ftuBzTyjcMapper.selectByPage(record);
    }

}
