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

import com.guodu.pojo.dtu.BzDlhl;
import com.guodu.mapper.dtu.BzDlhlMapper;
import com.guodu.service.dtu.BzDlhlService;

/**
 * @ClassName: BzDlhlServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:36 上午
 */
@Service
public class BzDlhlServiceImpl implements BzDlhlService {

    @Resource
    private BzDlhlMapper bzDlhlMapper;
    @Autowired
    private SysDbMapper sysDbMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzDlhlMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzDlhl record) {
        return bzDlhlMapper.insert(record);
    }

    @Override
    public int insertSelective(BzDlhl record) {
        return bzDlhlMapper.insertSelective(record);
    }

    @Override
    public BzDlhl selectByPrimaryKey(String id) {
        return bzDlhlMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzDlhl record) {
        return bzDlhlMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzDlhl record) {
        return bzDlhlMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzDlhl> selectByAll(BzDlhl bzDlhl) {
        return bzDlhlMapper.selectByAll(bzDlhl);
    }

    @Override
    public int updateBatch(List<BzDlhl> list) {
        return bzDlhlMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzDlhl> list) {
        return bzDlhlMapper.batchInsert(list);
    }

    @Override
    public List<BzDlhl> selectByPage(BzDlhl record) {
        List<BzDlhl> bzDlhls = bzDlhlMapper.selectByPage(record);
        // 查询装置类型名
        for (BzDlhl bzdlhl : bzDlhls) {
            List<String> zzlxname = new ArrayList<>();
            String[] split = bzdlhl.getZzlx().split(",");
            for (String s : split) {
                SysDb sysDb = new SysDb();
                sysDb.setKeycode("zz_type");
                sysDb.setKeyvalue(s);
                sysDb = sysDbMapper.selectByKeycodeAndKeyValue(sysDb);
                zzlxname.add(sysDb.getKeymemo());
            }
            bzdlhl.setZzlxname(zzlxname.toString());
        }
        return bzDlhls;
    }

}

