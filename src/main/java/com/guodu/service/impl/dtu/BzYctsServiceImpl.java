package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.mapper.dtu.BzYctsMapper;
import com.guodu.pojo.dtu.BzYcts;
import com.guodu.service.dtu.BzYctsService;

/**
 * @ClassName: BzYctsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:41 上午
 */
@Service
public class BzYctsServiceImpl implements BzYctsService {

    @Resource
    private BzYctsMapper bzYctsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzYctsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzYcts record) {
        return bzYctsMapper.insert(record);
    }

    @Override
    public int insertSelective(BzYcts record) {
        return bzYctsMapper.insertSelective(record);
    }

    @Override
    public BzYcts selectByPrimaryKey(String id) {
        return bzYctsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzYcts record) {
        return bzYctsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzYcts record) {
        return bzYctsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzYcts> selectByAll(BzYcts bzYcts) {
        return bzYctsMapper.selectByAll(bzYcts);
    }

    @Override
    public int updateBatch(List<BzYcts> list) {
        return bzYctsMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzYcts> list) {
        return bzYctsMapper.batchInsert(list);
    }

    @Override
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzYcts> bzYctss = bzYctsMapper.selectByPage((BzYcts) map.get("bzYcts"));
        PageInfo<BzYcts> pageInfo = new PageInfo<>(bzYctss);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }

}
