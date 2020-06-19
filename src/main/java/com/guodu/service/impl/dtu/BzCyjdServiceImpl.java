package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.mapper.dtu.BzCyjdMapper;
import com.guodu.pojo.dtu.BzCyjd;
import com.guodu.service.dtu.BzCyjdService;

/**
 * @ClassName: BzCyjdServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:22 上午
 */
@Service
public class BzCyjdServiceImpl implements BzCyjdService {

    @Resource
    private BzCyjdMapper bzCyjdMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzCyjdMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzCyjd record) {
        return bzCyjdMapper.insert(record);
    }

    @Override
    public int insertSelective(BzCyjd record) {
        return bzCyjdMapper.insertSelective(record);
    }

    @Override
    public BzCyjd selectByPrimaryKey(String id) {
        return bzCyjdMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzCyjd record) {
        return bzCyjdMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzCyjd record) {
        return bzCyjdMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzCyjd> selectByAll(BzCyjd bzCyjd) {
        return bzCyjdMapper.selectByAll(bzCyjd);
    }

    @Override
    public int updateBatch(List<BzCyjd> list) {
        return bzCyjdMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzCyjd> list) {
        return bzCyjdMapper.batchInsert(list);
    }

    @Override
    public int updateBatchSelective(List<BzCyjd> list) {
        return bzCyjdMapper.updateBatchSelective(list);
    }

    @Override
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzCyjd> bzCyjds = bzCyjdMapper.selectByPage((BzCyjd) map.get("bzCyjd"));
        PageInfo<BzCyjd> pageInfo = new PageInfo<>(bzCyjds);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }
}

