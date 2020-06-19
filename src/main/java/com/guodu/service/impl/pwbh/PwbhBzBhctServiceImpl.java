package com.guodu.service.impl.pwbh;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.guodu.mapper.pwbh.PwbhBzBhctMapper;
import java.util.List;
import com.guodu.pojo.pwbh.PwbhBzBhct;
import com.guodu.service.pwbh.PwbhBzBhctService;
/**
 * @ClassName: PwbhBzBhctServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:57 下午
 */
@Service
public class PwbhBzBhctServiceImpl implements PwbhBzBhctService{

    @Resource
    private PwbhBzBhctMapper pwbhBzBhctMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhBzBhctMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhBzBhct record) {
        return pwbhBzBhctMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhBzBhct record) {
        return pwbhBzBhctMapper.insertSelective(record);
    }

    @Override
    public PwbhBzBhct selectByPrimaryKey(String id) {
        return pwbhBzBhctMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhBzBhct record) {
        return pwbhBzBhctMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhBzBhct record) {
        return pwbhBzBhctMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhBzBhct> selectByAll(PwbhBzBhct pwbhBzBhct) {
        return pwbhBzBhctMapper.selectByAll(pwbhBzBhct);
    }

    @Override
    public int updateBatch(List<PwbhBzBhct> list) {
        return pwbhBzBhctMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<PwbhBzBhct> list) {
        return pwbhBzBhctMapper.batchInsert(list);
    }

    @Override
    public List<PwbhBzBhct> selectByPage(PwbhBzBhct record) {
        return pwbhBzBhctMapper.selectByPage(record);
    }

}
