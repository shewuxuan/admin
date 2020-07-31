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

import com.guodu.mapper.dtu.BzYktsMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzYkts;
import com.guodu.service.dtu.BzYktsService;

/**
 * @ClassName: BzYktsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:41 上午
 */
@Service
public class BzYktsServiceImpl implements BzYktsService {

    @Resource
    private BzYktsMapper bzYktsMapper;
    @Autowired
    private SysDbMapper sysDbMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzYktsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzYkts record) {
        return bzYktsMapper.insert(record);
    }

    @Override
    public int insertSelective(BzYkts record) {
        return bzYktsMapper.insertSelective(record);
    }

    @Override
    public BzYkts selectByPrimaryKey(String id) {
        return bzYktsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzYkts record) {
        return bzYktsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzYkts record) {
        return bzYktsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzYkts> selectByAll(BzYkts bzYkts) {
        return bzYktsMapper.selectByAll(bzYkts);
    }

    @Override
    public int updateBatch(List<BzYkts> list) {
        return bzYktsMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzYkts> list) {
        return bzYktsMapper.batchInsert(list);
    }

    @Override
    public List<BzYkts> selectByPage(BzYkts record) {
        List<BzYkts> bzYktss = bzYktsMapper.selectByPage(record);
        // 查询装置类型名
        for (BzYkts bzykts : bzYktss) {
            List<String> zzlxname = new ArrayList<>();
            String[] split = bzykts.getZzlx().split(",");
            for (String s : split) {
                SysDb sysDb = new SysDb();
                sysDb.setKeycode("zz_type");
                sysDb.setKeyvalue(s);
                sysDb = sysDbMapper.selectByKeycodeAndKeyValue(sysDb);
                zzlxname.add(sysDb.getKeymemo());
            }
            bzykts.setZzlxname(zzlxname.toString());
        }
        return bzYktss;
    }

}
