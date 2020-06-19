package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.guodu.pojo.dtu.BzGncs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.mapper.dtu.BzGncsMapper;
import com.guodu.service.dtu.BzGncsService;

/**
 * @ClassName: BzGncsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:38 上午
 */
@Service
public class BzGncsServiceImpl implements BzGncsService {

    @Resource
    private BzGncsMapper bzGncsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzGncsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzGncs record) {
        return bzGncsMapper.insert(record);
    }

    @Override
    public int insertSelective(BzGncs record) {
        return bzGncsMapper.insertSelective(record);
    }

    @Override
    public BzGncs selectByPrimaryKey(String id) {
        return bzGncsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzGncs record) {
        return bzGncsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzGncs record) {
        return bzGncsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzGncs> selectByAll(BzGncs bzGncs) {
        return bzGncsMapper.selectByAll(bzGncs);
    }

    @Override
    public int updateBatch(List<BzGncs> list) {
        return bzGncsMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzGncs> list) {
        return bzGncsMapper.batchInsert(list);
    }

    @Override
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzGncs> bzGncss = bzGncsMapper.selectByPage((BzGncs) map.get("bzGncs"));
        PageInfo<BzGncs> pageInfo = new PageInfo<>(bzGncss);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }

}
