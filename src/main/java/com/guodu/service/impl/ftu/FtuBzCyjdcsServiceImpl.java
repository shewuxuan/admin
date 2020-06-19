package com.guodu.service.impl.ftu;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.guodu.mapper.ftu.FtuBzCyjdcsMapper;
import java.util.List;
import com.guodu.pojo.ftu.FtuBzCyjdcs;
import com.guodu.service.ftu.FtuBzCyjdcsService;
/**
 * @ClassName: FtuBzCyjdcsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:20 下午
 */
@Service
public class FtuBzCyjdcsServiceImpl implements FtuBzCyjdcsService{

    @Resource
    private FtuBzCyjdcsMapper ftuBzCyjdcsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuBzCyjdcsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuBzCyjdcs record) {
        return ftuBzCyjdcsMapper.insert(record);
    }

    @Override
    public int insertSelective(FtuBzCyjdcs record) {
        return ftuBzCyjdcsMapper.insertSelective(record);
    }

    @Override
    public FtuBzCyjdcs selectByPrimaryKey(String id) {
        return ftuBzCyjdcsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuBzCyjdcs record) {
        return ftuBzCyjdcsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuBzCyjdcs record) {
        return ftuBzCyjdcsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuBzCyjdcs> selectByAll(FtuBzCyjdcs ftuBzCyjdcs) {
        return ftuBzCyjdcsMapper.selectByAll(ftuBzCyjdcs);
    }

    @Override
    public int updateBatch(List<FtuBzCyjdcs> list) {
        return ftuBzCyjdcsMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<FtuBzCyjdcs> list) {
        return ftuBzCyjdcsMapper.batchInsert(list);
    }

    @Override
    public List<FtuBzCyjdcs> selectByPage(FtuBzCyjdcs record) {
        return ftuBzCyjdcsMapper.selectByPage(record);
    }

}
