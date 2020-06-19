package com.guodu.service.impl.dtu;

import com.guodu.mapper.dtu.JbxxBeizhuMapper;
import com.guodu.pojo.dtu.JbxxBeizhu;
import com.guodu.service.dtu.JbxxBeizhuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: JbxxBeizhuServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/29 9:46 上午
 */
@Service
public class JbxxBeizhuServiceImpl implements JbxxBeizhuService {

    @Resource
    private JbxxBeizhuMapper jbxxBeizhuMapper;

    @Override
    public int insert(JbxxBeizhu record) {
        return jbxxBeizhuMapper.insert(record);
    }

    @Override
    public int insertSelective(JbxxBeizhu record) {
        return jbxxBeizhuMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String tsid) {
        return jbxxBeizhuMapper.deleteByPrimaryKey(tsid);
    }

    @Override
    public JbxxBeizhu selectByPrimaryKey(String tsid) {
        return jbxxBeizhuMapper.selectByPrimaryKey(tsid);
    }

    @Override
    public int updateByPrimaryKeySelective(JbxxBeizhu record) {
        return jbxxBeizhuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JbxxBeizhu record) {
        return jbxxBeizhuMapper.updateByPrimaryKey(record);
    }
}

