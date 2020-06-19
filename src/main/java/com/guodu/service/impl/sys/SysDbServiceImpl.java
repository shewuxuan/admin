package com.guodu.service.impl.sys;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.guodu.pojo.sys.SysDb;
import com.guodu.mapper.sys.SysDbMapper;

import java.util.List;

import com.guodu.service.sys.SysDbService;

/**
 * @ClassName: SysDbServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/15 5:07 下午
 */
@Service
public class SysDbServiceImpl implements SysDbService {

    @Resource
    private SysDbMapper sysDbMapper;

    @Override
    public int insert(SysDb record) {
        return sysDbMapper.insert(record);
    }

    @Override
    public int insertSelective(SysDb record) {
        return sysDbMapper.insertSelective(record);
    }

    @Override
    public List<SysDb> selectByAll(SysDb sysDb) {
        return sysDbMapper.selectByAll(sysDb);
    }

    @Override
    public int batchInsert(List<SysDb> list) {
        return sysDbMapper.batchInsert(list);
    }

}



