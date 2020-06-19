package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.mapper.dtu.BzWgpzMapper;
import com.guodu.pojo.dtu.BzWgpz;
import com.guodu.service.dtu.BzWgpzService;

/**
 * @ClassName: BzWgpzServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:41 上午
 */
@Service
public class BzWgpzServiceImpl implements BzWgpzService {

    @Resource
    private BzWgpzMapper bzWgpzMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzWgpzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzWgpz record) {
        return bzWgpzMapper.insert(record);
    }

    @Override
    public int insertSelective(BzWgpz record) {
        return bzWgpzMapper.insertSelective(record);
    }

    @Override
    public BzWgpz selectByPrimaryKey(String id) {
        return bzWgpzMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzWgpz record) {
        return bzWgpzMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzWgpz record) {
        return bzWgpzMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzWgpz> selectByAll(BzWgpz bzWgpz) {
        return bzWgpzMapper.selectByAll(bzWgpz);
    }

    @Override
    public int updateBatch(List<BzWgpz> list) {
        return bzWgpzMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzWgpz> list) {
        return bzWgpzMapper.batchInsert(list);
    }

    @Override
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzWgpz> bzWgpzs = bzWgpzMapper.selectByPage((BzWgpz) map.get("bzWgpz"));

        PageInfo<BzWgpz> pageInfo = new PageInfo<>(bzWgpzs);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }

}
