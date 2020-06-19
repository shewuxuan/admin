package com.guodu.service.impl.dtu;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guodu.mapper.sys.SysDbMapper;
import com.guodu.pojo.sys.SysDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.guodu.pojo.dtu.BzHldz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.mapper.dtu.BzHldzMapper;
import com.guodu.service.dtu.BzHldzService;

/**
 * @ClassName: BzHldzServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:39 上午
 */
@Service
public class BzHldzServiceImpl implements BzHldzService {

    @Resource
    private BzHldzMapper bzHldzMapper;

    @Autowired
    private SysDbMapper sysDbMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzHldzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzHldz record) {
        return bzHldzMapper.insert(record);
    }

    @Override
    public int insertSelective(BzHldz record) {
        return bzHldzMapper.insertSelective(record);
    }

    @Override
    public BzHldz selectByPrimaryKey(String id) {
        return bzHldzMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzHldz record) {
        return bzHldzMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzHldz record) {
        return bzHldzMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzHldz> selectByAll(BzHldz bzHldz) {
        return bzHldzMapper.selectByAll(bzHldz);
    }

    @Override
    public int updateBatch(List<BzHldz> list) {
        return bzHldzMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzHldz> list) {
        return bzHldzMapper.batchInsert(list);
    }

    @Override
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzHldz> bzHldzs = bzHldzMapper.selectByPage((BzHldz) map.get("bzHldz"));

        // 封装zzlxname
        for (BzHldz record : bzHldzs) {
            List<String> zzlxname = new ArrayList<>();
            // 以,分割  取出zzlx
            String[] zzlxs = StrUtil.split(record.getZzlx(), ",");
            // 查询zzlxname
            for (String zzlx : zzlxs) {
                SysDb sysDb = new SysDb();
                sysDb.setKeycode("zz_type");
                sysDb.setKeyvalue(zzlx);
                sysDb = sysDbMapper.selectByKeycodeAndKeyValue(sysDb);
                // 将查询出来的keymemo(装置类型名)放入zzlxname
                zzlxname.add(sysDb.getKeymemo());
            }
            record.setZzlxname(zzlxname.toString());
        }
        PageInfo<BzHldz> pageInfo = new PageInfo<>(bzHldzs);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }

}

