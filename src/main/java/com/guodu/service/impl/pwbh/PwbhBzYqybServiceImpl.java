package com.guodu.service.impl.pwbh;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.guodu.mapper.pwbh.PwbhBzYqybMapper;
import java.util.List;
import com.guodu.pojo.pwbh.PwbhBzYqyb;
import com.guodu.service.pwbh.PwbhBzYqybService;
/**
 * @ClassName: PwbhBzYqybServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 3:00 下午
 */
@Service
public class PwbhBzYqybServiceImpl implements PwbhBzYqybService{

    @Resource
    private PwbhBzYqybMapper pwbhBzYqybMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhBzYqybMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhBzYqyb record) {
        return pwbhBzYqybMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhBzYqyb record) {
        return pwbhBzYqybMapper.insertSelective(record);
    }

    @Override
    public PwbhBzYqyb selectByPrimaryKey(String id) {
        return pwbhBzYqybMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhBzYqyb record) {
        return pwbhBzYqybMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhBzYqyb record) {
        return pwbhBzYqybMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhBzYqyb> selectByAll(PwbhBzYqyb pwbhBzYqyb) {
        return pwbhBzYqybMapper.selectByAll(pwbhBzYqyb);
    }

    @Override
    public int updateBatch(List<PwbhBzYqyb> list) {
        return pwbhBzYqybMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<PwbhBzYqyb> list) {
        return pwbhBzYqybMapper.batchInsert(list);
    }

    @Override
    public List<PwbhBzYqyb> selectByPage(PwbhBzYqyb record) {
        return pwbhBzYqybMapper.selectByPage(record);
    }

}
