package com.guodu.service.impl.pwbh;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.guodu.mapper.pwbh.PwbhBzSgjcMapper;
import com.guodu.pojo.pwbh.PwbhBzSgjc;
import com.guodu.service.pwbh.PwbhBzSgjcService;
/**
 * @ClassName: PwbhBzSgjcServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 3:00 下午
 */
@Service
public class PwbhBzSgjcServiceImpl implements PwbhBzSgjcService{

    @Resource
    private PwbhBzSgjcMapper pwbhBzSgjcMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhBzSgjcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhBzSgjc record) {
        return pwbhBzSgjcMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhBzSgjc record) {
        return pwbhBzSgjcMapper.insertSelective(record);
    }

    @Override
    public PwbhBzSgjc selectByPrimaryKey(String id) {
        return pwbhBzSgjcMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhBzSgjc record) {
        return pwbhBzSgjcMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhBzSgjc record) {
        return pwbhBzSgjcMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhBzSgjc> selectByAll(PwbhBzSgjc pwbhBzSgjc) {
        return pwbhBzSgjcMapper.selectByAll(pwbhBzSgjc);
    }

    @Override
    public int updateBatch(List<PwbhBzSgjc> list) {
        return pwbhBzSgjcMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<PwbhBzSgjc> list) {
        return pwbhBzSgjcMapper.batchInsert(list);
    }

    @Override
    public List<PwbhBzSgjc> selectByPage(PwbhBzSgjc record) {
        return pwbhBzSgjcMapper.selectByPage(record);
    }

}
