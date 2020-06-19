package com.guodu.service.impl.ftu;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.guodu.mapper.ftu.FtuBzGncsMapper;
import com.guodu.pojo.ftu.FtuBzGncs;
import com.guodu.service.ftu.FtuBzGncsService;
/**
 * @ClassName: FtuBzGncsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:21 下午
 */
@Service
public class FtuBzGncsServiceImpl implements FtuBzGncsService{

    @Resource
    private FtuBzGncsMapper ftuBzGncsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuBzGncsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuBzGncs record) {
        return ftuBzGncsMapper.insert(record);
    }

    @Override
    public int insertSelective(FtuBzGncs record) {
        return ftuBzGncsMapper.insertSelective(record);
    }

    @Override
    public FtuBzGncs selectByPrimaryKey(String id) {
        return ftuBzGncsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuBzGncs record) {
        return ftuBzGncsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuBzGncs record) {
        return ftuBzGncsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuBzGncs> selectByAll(FtuBzGncs ftuBzGncs) {
        return ftuBzGncsMapper.selectByAll(ftuBzGncs);
    }

    @Override
    public int updateBatch(List<FtuBzGncs> list) {
        return ftuBzGncsMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<FtuBzGncs> list) {
        return ftuBzGncsMapper.batchInsert(list);
    }

    @Override
    public List<FtuBzGncs> selectByPage(FtuBzGncs record) {
        return ftuBzGncsMapper.selectByPage(record);
    }

}
