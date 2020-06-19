package com.guodu.service.impl.ftu;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.guodu.pojo.ftu.FtuBzGjts;
import com.guodu.mapper.ftu.FtuBzGjtsMapper;
import com.guodu.service.ftu.FtuBzGjtsService;
/**
 * @ClassName: FtuBzGjtsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:20 下午
 */
@Service
public class FtuBzGjtsServiceImpl implements FtuBzGjtsService{

    @Resource
    private FtuBzGjtsMapper ftuBzGjtsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuBzGjtsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuBzGjts record) {
        return ftuBzGjtsMapper.insert(record);
    }

    @Override
    public int insertSelective(FtuBzGjts record) {
        return ftuBzGjtsMapper.insertSelective(record);
    }

    @Override
    public FtuBzGjts selectByPrimaryKey(String id) {
        return ftuBzGjtsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuBzGjts record) {
        return ftuBzGjtsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuBzGjts record) {
        return ftuBzGjtsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuBzGjts> selectByAll(FtuBzGjts ftuBzGjts) {
        return ftuBzGjtsMapper.selectByAll(ftuBzGjts);
    }

    @Override
    public int updateBatch(List<FtuBzGjts> list) {
        return ftuBzGjtsMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<FtuBzGjts> list) {
        return ftuBzGjtsMapper.batchInsert(list);
    }

    @Override
    public List<FtuBzGjts> selectByPage(FtuBzGjts record) {
        return ftuBzGjtsMapper.selectByPage(record);
    }

}
