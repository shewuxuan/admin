package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzDlhl;
import com.guodu.mapper.dtu.BzDlhlMapper;
import com.guodu.service.dtu.BzDlhlService;

/**
 * @ClassName: BzDlhlServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:36 上午
 */
@Service
public class BzDlhlServiceImpl implements BzDlhlService {

    @Resource
    private BzDlhlMapper bzDlhlMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzDlhlMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzDlhl record) {
        return bzDlhlMapper.insert(record);
    }

    @Override
    public int insertSelective(BzDlhl record) {
        return bzDlhlMapper.insertSelective(record);
    }

    @Override
    public BzDlhl selectByPrimaryKey(String id) {
        return bzDlhlMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzDlhl record) {
        return bzDlhlMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzDlhl record) {
        return bzDlhlMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzDlhl> selectByAll(BzDlhl bzDlhl) {
        return bzDlhlMapper.selectByAll(bzDlhl);
    }

    @Override
    public int updateBatch(List<BzDlhl> list) {
        return bzDlhlMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzDlhl> list) {
        return bzDlhlMapper.batchInsert(list);
    }

    @Override
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzDlhl> bzDlhls = bzDlhlMapper.selectByPage((BzDlhl) map.get("bzDlhl"));
        PageInfo<BzDlhl> pageInfo = new PageInfo<>(bzDlhls);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }

}

