package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzCtgy;
import com.guodu.mapper.dtu.BzCtgyMapper;
import com.guodu.service.dtu.BzCtgyService;

/**
 * ClassName: BzCtgyServiceImpl
 * Function:  TODO
 * Date:      2020/1/17 4:21 下午
 * author     2Uli
 */
@Service
public class BzCtgyServiceImpl implements BzCtgyService {

    @Resource
    private BzCtgyMapper bzCtgyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzCtgyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzCtgy record) {
        return bzCtgyMapper.insert(record);
    }

    @Override
    public int insertSelective(BzCtgy record) {
        return bzCtgyMapper.insertSelective(record);
    }

    @Override
    public BzCtgy selectByPrimaryKey(String id) {
        return bzCtgyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzCtgy record) {
        return bzCtgyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzCtgy record) {
        return bzCtgyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzCtgy> selectByAll(BzCtgy bzCtgy) {
        return bzCtgyMapper.selectByAll(bzCtgy);
    }

    @Override
    public int updateBatch(List<BzCtgy> list) {
        return bzCtgyMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzCtgy> list) {
        return bzCtgyMapper.batchInsert(list);
    }

    @Override
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzCtgy> bzCtgys = bzCtgyMapper.selectByPage((BzCtgy) map.get("bzCtgy"));
        PageInfo<BzCtgy> pageInfo = new PageInfo<>(bzCtgys);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }

}

