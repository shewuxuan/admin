package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guodu.mapper.sys.SysDbMapper;
import com.guodu.pojo.sys.SysDb;
import com.guodu.service.sys.SysDbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.mapper.dtu.BzLpjyMapper;
import com.guodu.pojo.dtu.BzLpjy;
import com.guodu.service.dtu.BzLpjyService;

/**
 * @ClassName: BzLpjyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:40 上午
 */
@Service
public class BzLpjyServiceImpl implements BzLpjyService {

    @Resource
    private BzLpjyMapper bzLpjyMapper;
    @Resource
    private SysDbMapper sysDbMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzLpjyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzLpjy record) {
        return bzLpjyMapper.insert(record);
    }

    @Override
    public int insertSelective(BzLpjy record) {
        return bzLpjyMapper.insertSelective(record);
    }

    @Override
    public BzLpjy selectByPrimaryKey(String id) {
        return bzLpjyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzLpjy record) {
        return bzLpjyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzLpjy record) {
        return bzLpjyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzLpjy> selectByAll(BzLpjy bzLpjy) {
        return bzLpjyMapper.selectByAll(bzLpjy);
    }

    @Override
    public int updateBatch(List<BzLpjy> list) {
        return bzLpjyMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzLpjy> list) {
        return bzLpjyMapper.batchInsert(list);
    }

    @Override
    public List<BzLpjy> selectByPage(BzLpjy record) {
        List<BzLpjy> bzLpjys = bzLpjyMapper.selectByPage(record);
        // 查询装置类型名
        for (BzLpjy bzLpjy : bzLpjys) {
            List<String> zzlxname = new ArrayList<>();
            String[] split = bzLpjy.getZzlx().split(",");
            for (String s : split) {
                SysDb sysDb = new SysDb();
                sysDb.setKeycode("zz_type");
                sysDb.setKeyvalue(s);
                sysDb = sysDbMapper.selectByKeycodeAndKeyValue(sysDb);
                zzlxname.add(sysDb.getKeymemo());
            }
            bzLpjy.setZzlxname(zzlxname.toString());
        }
        return bzLpjys;
    }

}
