package com.guodu.service.impl.pwbh;

import com.guodu.mapper.pwbh.PwbhJbxxBeizhuMapper;
import com.guodu.pojo.pwbh.PwbhJbxxBeizhu;
import com.guodu.service.pwbh.PwbhJbxxBeizhuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: PwbhJbxxBeizhuServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/11 4:01 下午
 */
@Service
public class PwbhJbxxBeizhuServiceImpl implements PwbhJbxxBeizhuService{

    @Resource
    private PwbhJbxxBeizhuMapper pwbhJbxxBeizhuMapper;

    @Override
    public int deleteByPrimaryKey(String tsid) {
        return pwbhJbxxBeizhuMapper.deleteByPrimaryKey(tsid);
    }

    @Override
    public int insert(PwbhJbxxBeizhu record) {
        return pwbhJbxxBeizhuMapper.insert(record);
    }

    @Override
    public int insertSelective(PwbhJbxxBeizhu record) {
        return pwbhJbxxBeizhuMapper.insertSelective(record);
    }

    @Override
    public PwbhJbxxBeizhu selectByPrimaryKey(String tsid) {
        return pwbhJbxxBeizhuMapper.selectByPrimaryKey(tsid);
    }

    @Override
    public int updateByPrimaryKeySelective(PwbhJbxxBeizhu record) {
        return pwbhJbxxBeizhuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PwbhJbxxBeizhu record) {
        return pwbhJbxxBeizhuMapper.updateByPrimaryKey(record);
    }

}
