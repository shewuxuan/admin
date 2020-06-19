package com.guodu.service.impl.pwbh;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.guodu.pojo.pwbh.PwbhBzJycs;
import java.util.List;
import com.guodu.mapper.pwbh.PwbhBzJycsMapper;
import com.guodu.service.pwbh.PwbhBzJycsService;
/**
 * @ClassName: PwbhBzJycsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:59 下午
 */
@Service
public class PwbhBzJycsServiceImpl implements PwbhBzJycsService{

    @Resource
    private PwbhBzJycsMapper pwbhBzJycsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhBzJycsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhBzJycs record) {
        return pwbhBzJycsMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhBzJycs record) {
        return pwbhBzJycsMapper.insertSelective(record);
    }

    @Override
    public PwbhBzJycs selectByPrimaryKey(String id) {
        return pwbhBzJycsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhBzJycs record) {
        return pwbhBzJycsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhBzJycs record) {
        return pwbhBzJycsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhBzJycs> selectByAll(PwbhBzJycs pwbhBzJycs) {
        return pwbhBzJycsMapper.selectByAll(pwbhBzJycs);
    }

    @Override
    public int updateBatch(List<PwbhBzJycs> list) {
        return pwbhBzJycsMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<PwbhBzJycs> list) {
        return pwbhBzJycsMapper.batchInsert(list);
    }

    @Override
    public List<PwbhBzJycs> selectByPage(PwbhBzJycs record) {
        return pwbhBzJycsMapper.selectByPage(record);
    }

}
