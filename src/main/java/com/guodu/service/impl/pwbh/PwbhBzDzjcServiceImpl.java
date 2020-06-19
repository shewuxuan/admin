package com.guodu.service.impl.pwbh;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.guodu.pojo.pwbh.PwbhBzDzjc;
import com.guodu.mapper.pwbh.PwbhBzDzjcMapper;
import com.guodu.service.pwbh.PwbhBzDzjcService;
/**
 * @ClassName: PwbhBzDzjcServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:58 下午
 */
@Service
public class PwbhBzDzjcServiceImpl implements PwbhBzDzjcService{

    @Resource
    private PwbhBzDzjcMapper pwbhBzDzjcMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhBzDzjcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhBzDzjc record) {
        return pwbhBzDzjcMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhBzDzjc record) {
        return pwbhBzDzjcMapper.insertSelective(record);
    }

    @Override
    public PwbhBzDzjc selectByPrimaryKey(String id) {
        return pwbhBzDzjcMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhBzDzjc record) {
        return pwbhBzDzjcMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhBzDzjc record) {
        return pwbhBzDzjcMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhBzDzjc> selectByAll(PwbhBzDzjc pwbhBzDzjc) {
        return pwbhBzDzjcMapper.selectByAll(pwbhBzDzjc);
    }

    @Override
    public int updateBatch(List<PwbhBzDzjc> list) {
        return pwbhBzDzjcMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<PwbhBzDzjc> list) {
        return pwbhBzDzjcMapper.batchInsert(list);
    }

    @Override
    public List<PwbhBzDzjc> selectByPage(PwbhBzDzjc record) {
        return pwbhBzDzjcMapper.selectByPage(record);
    }

}
