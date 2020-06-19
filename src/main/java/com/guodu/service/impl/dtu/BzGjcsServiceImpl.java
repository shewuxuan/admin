package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.mapper.dtu.BzGjcsMapper;
import com.guodu.pojo.dtu.BzGjcs;
import com.guodu.service.dtu.BzGjcsService;

/**
 * @ClassName: BzGjcsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:38 上午
 */
@Service
public class BzGjcsServiceImpl implements BzGjcsService {

    @Resource
    private BzGjcsMapper bzGjcsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzGjcsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzGjcs record) {
        return bzGjcsMapper.insert(record);
    }

    @Override
    public int insertSelective(BzGjcs record) {
        return bzGjcsMapper.insertSelective(record);
    }

    @Override
    public BzGjcs selectByPrimaryKey(String id) {
        return bzGjcsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzGjcs record) {
        return bzGjcsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzGjcs record) {
        return bzGjcsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzGjcs> selectByAll(BzGjcs bzGjcs) {
        return bzGjcsMapper.selectByAll(bzGjcs);
    }

    @Override
    public int updateBatch(List<BzGjcs> list) {
        return bzGjcsMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzGjcs> list) {
        return bzGjcsMapper.batchInsert(list);
    }

    @Override
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzGjcs> bzGjcss = bzGjcsMapper.selectByPage((BzGjcs) map.get("bzGjcs"));

        PageInfo<BzGjcs> pageInfo = new PageInfo<>(bzGjcss);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }

}
