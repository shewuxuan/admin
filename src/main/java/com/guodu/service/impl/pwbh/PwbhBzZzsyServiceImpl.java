package com.guodu.service.impl.pwbh;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.guodu.mapper.pwbh.PwbhBzZzsyMapper;
import com.guodu.pojo.pwbh.PwbhBzZzsy;
import com.guodu.service.pwbh.PwbhBzZzsyService;
/**
 * @ClassName: PwbhBzZzsyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/16 9:51 上午
 */
@Service
public class PwbhBzZzsyServiceImpl implements PwbhBzZzsyService{

    @Resource
    private PwbhBzZzsyMapper pwbhBzZzsyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pwbhBzZzsyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PwbhBzZzsy record) {
        return pwbhBzZzsyMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhBzZzsy record) {
        return pwbhBzZzsyMapper.insertSelective(record);
    }

    @Override
    public PwbhBzZzsy selectByPrimaryKey(String id) {
        return pwbhBzZzsyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhBzZzsy record) {
        return pwbhBzZzsyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhBzZzsy record) {
        return pwbhBzZzsyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PwbhBzZzsy> selectByAll(PwbhBzZzsy pwbhBzZzsy) {
        return pwbhBzZzsyMapper.selectByAll(pwbhBzZzsy);
    }

    @Override
    public int updateBatch(List<PwbhBzZzsy> list) {
        return pwbhBzZzsyMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<PwbhBzZzsy> list) {
        return pwbhBzZzsyMapper.batchInsert(list);
    }

    @Override
    public List<PwbhBzZzsy> selectByPage(PwbhBzZzsy record) {
        return pwbhBzZzsyMapper.selectByPage(record);
    }

}
