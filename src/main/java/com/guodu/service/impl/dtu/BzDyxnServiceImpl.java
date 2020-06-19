package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.mapper.dtu.BzDyxnMapper;
import com.guodu.pojo.dtu.BzDyxn;
import com.guodu.service.dtu.BzDyxnService;

/**
 * @ClassName: BzDyxnServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:38 上午
 */
@Service
public class BzDyxnServiceImpl implements BzDyxnService {

    @Resource
    private BzDyxnMapper bzDyxnMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzDyxnMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzDyxn record) {
        return bzDyxnMapper.insert(record);
    }

    @Override
    public int insertSelective(BzDyxn record) {
        return bzDyxnMapper.insertSelective(record);
    }

    @Override
    public BzDyxn selectByPrimaryKey(String id) {
        return bzDyxnMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzDyxn record) {
        return bzDyxnMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzDyxn record) {
        return bzDyxnMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzDyxn> selectByAll(BzDyxn bzDyxn) {
        return bzDyxnMapper.selectByAll(bzDyxn);
    }

    @Override
    public int updateBatch(List<BzDyxn> list) {
        return bzDyxnMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzDyxn> list) {
        return bzDyxnMapper.batchInsert(list);
    }

    @Override
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzDyxn> bzDyxns = bzDyxnMapper.selectByPage((BzDyxn) map.get("bzDyxn"));
        PageInfo<BzDyxn> pageInfo = new PageInfo<>(bzDyxns);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }

}
