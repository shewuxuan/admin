package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.guodu.mapper.dtu.BzYktsMapper;

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
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzYkts> bzYktss = bzYktsMapper.selectByPage((BzYkts) map.get("bzYkts"));

        PageInfo<BzYkts> pageInfo = new PageInfo<>(bzYktss);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }

}
