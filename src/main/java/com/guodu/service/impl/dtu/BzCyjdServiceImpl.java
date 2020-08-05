package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guodu.mapper.sys.SysDbMapper;
import com.guodu.pojo.dtu.BzHldz;
import com.guodu.pojo.sys.SysDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.mapper.dtu.BzCyjdMapper;
import com.guodu.pojo.dtu.BzCyjd;
import com.guodu.service.dtu.BzCyjdService;

/**
 * @ClassName: BzCyjdServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:22 上午
 */
@Service
public class BzCyjdServiceImpl implements BzCyjdService {

    @Resource
    private BzCyjdMapper bzCyjdMapper;
    @Autowired
    private SysDbMapper sysDbMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzCyjdMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzCyjd record) {
        return bzCyjdMapper.insert(record);
    }

    @Override
    public int insertSelective(BzCyjd record) {
        return bzCyjdMapper.insertSelective(record);
    }

    @Override
    public BzCyjd selectByPrimaryKey(String id) {
        return bzCyjdMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzCyjd record) {
        return bzCyjdMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzCyjd record) {
        return bzCyjdMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzCyjd> selectByAll(BzCyjd bzCyjd) {
        return bzCyjdMapper.selectByAll(bzCyjd);
    }

    @Override
    public int updateBatch(List<BzCyjd> list) {
        return bzCyjdMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzCyjd> list) {
        return bzCyjdMapper.batchInsert(list);
    }

    @Override
    public int updateBatchSelective(List<BzCyjd> list) {
        return bzCyjdMapper.updateBatchSelective(list);
    }

    @Override
    public List<BzCyjd> selectByPage(BzCyjd record) {
        List<BzCyjd> bzCyjds = bzCyjdMapper.selectByPage(record);
        // 查询装置类型名
        for (BzCyjd bzcyjd : bzCyjds) {
            List<String> zzlxname = new ArrayList<>();
            String[] split = bzcyjd.getZzlx().split(",");
            for (String s : split) {
                SysDb sysDb = new SysDb();
                sysDb.setKeycode("zz_type");
                sysDb.setKeyvalue(s);
                sysDb = sysDbMapper.selectByKeycodeAndKeyValue(sysDb);
                zzlxname.add(sysDb.getKeymemo());
            }
            bzcyjd.setZzlxname(zzlxname.toString());
        }
        return bzCyjds;
    }
}

