package com.guodu.service.impl.pwbh;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.guodu.pojo.pwbh.PwbhBzJxdx;
import java.util.List;
import com.guodu.mapper.pwbh.PwbhBzJxdxMapper;
import com.guodu.service.pwbh.PwbhBzJxdxService;
/**
 * @ClassName: PwbhBzJxdxServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:59 下午
 */
@Service
public class PwbhBzJxdxServiceImpl implements PwbhBzJxdxService{

    @Resource
    private PwbhBzJxdxMapper pwbhBzJxdxMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhBzJxdxMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhBzJxdx record) {
        return pwbhBzJxdxMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhBzJxdx record) {
        return pwbhBzJxdxMapper.insertSelective(record);
    }

    @Override
    public PwbhBzJxdx selectByPrimaryKey(String id) {
        return pwbhBzJxdxMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhBzJxdx record) {
        return pwbhBzJxdxMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhBzJxdx record) {
        return pwbhBzJxdxMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhBzJxdx> selectByAll(PwbhBzJxdx pwbhBzJxdx) {
        return pwbhBzJxdxMapper.selectByAll(pwbhBzJxdx);
    }

    @Override
    public int updateBatch(List<PwbhBzJxdx> list) {
        return pwbhBzJxdxMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<PwbhBzJxdx> list) {
        return pwbhBzJxdxMapper.batchInsert(list);
    }

    @Override
    public List<PwbhBzJxdx> selectByPage(PwbhBzJxdx record) {
        return pwbhBzJxdxMapper.selectByPage(record);
    }

}
