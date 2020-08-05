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

import com.guodu.pojo.dtu.BzKgg;
import com.guodu.mapper.dtu.BzKggMapper;
import com.guodu.service.dtu.BzKggService;

/**
 * @ClassName: BzKggServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:39 上午
 */
@Service
public class BzKggServiceImpl implements BzKggService {

    @Resource
    private BzKggMapper bzKggMapper;
    @Autowired
    private SysDbMapper sysDbMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzKggMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzKgg record) {
        return bzKggMapper.insert(record);
    }

    @Override
    public int insertSelective(BzKgg record) {
        return bzKggMapper.insertSelective(record);
    }

    @Override
    public BzKgg selectByPrimaryKey(String id) {
        return bzKggMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzKgg record) {
        return bzKggMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzKgg record) {
        return bzKggMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzKgg> selectByAll(BzKgg bzKgg) {
        return bzKggMapper.selectByAll(bzKgg);
    }

    @Override
    public int updateBatch(List<BzKgg> list) {
        return bzKggMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzKgg> list) {
        return bzKggMapper.batchInsert(list);
    }

    @Override
    public List<BzKgg> selectByPage(BzKgg record) {
        List<BzKgg> bzKggs = bzKggMapper.selectByPage(record);
        // 查询装置类型名
        for (BzKgg bzkgg : bzKggs) {
            List<String> zzlxname = new ArrayList<>();
            String[] split = bzkgg.getZzlx().split(",");
            for (String s : split) {
                SysDb sysDb = new SysDb();
                sysDb.setKeycode("zz_type");
                sysDb.setKeyvalue(s);
                sysDb = sysDbMapper.selectByKeycodeAndKeyValue(sysDb);
                zzlxname.add(sysDb.getKeymemo());
            }
            bzkgg.setZzlxname(zzlxname.toString());
        }
        return bzKggs;
    }

}
