package com.guodu.service.impl.pwbh;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.guodu.pojo.pwbh.PwbhBzWgjc;
import com.guodu.mapper.pwbh.PwbhBzWgjcMapper;
import com.guodu.service.pwbh.PwbhBzWgjcService;
/**
 * @ClassName: PwbhBzWgjcServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 3:00 下午
 */
@Service
public class PwbhBzWgjcServiceImpl implements PwbhBzWgjcService{

    @Resource
    private PwbhBzWgjcMapper pwbhBzWgjcMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhBzWgjcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhBzWgjc record) {
        return pwbhBzWgjcMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhBzWgjc record) {
        return pwbhBzWgjcMapper.insertSelective(record);
    }

    @Override
    public PwbhBzWgjc selectByPrimaryKey(String id) {
        return pwbhBzWgjcMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhBzWgjc record) {
        return pwbhBzWgjcMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhBzWgjc record) {
        return pwbhBzWgjcMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhBzWgjc> selectByAll(PwbhBzWgjc pwbhBzWgjc) {
        return pwbhBzWgjcMapper.selectByAll(pwbhBzWgjc);
    }

    @Override
    public int updateBatch(List<PwbhBzWgjc> list) {
        return pwbhBzWgjcMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<PwbhBzWgjc> list) {
        return pwbhBzWgjcMapper.batchInsert(list);
    }

    @Override
    public List<PwbhBzWgjc> selectByPage(PwbhBzWgjc record) {
        return pwbhBzWgjcMapper.selectByPage(record);
    }

}
