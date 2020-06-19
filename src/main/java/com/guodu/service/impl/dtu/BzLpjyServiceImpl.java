package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.mapper.dtu.BzLpjyMapper;
import com.guodu.pojo.dtu.BzLpjy;
import com.guodu.service.dtu.BzLpjyService;

/**
 * @ClassName: BzLpjyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:40 上午
 */
@Service
public class BzLpjyServiceImpl implements BzLpjyService {

    @Resource
    private BzLpjyMapper bzLpjyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzLpjyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzLpjy record) {
        return bzLpjyMapper.insert(record);
    }

    @Override
    public int insertSelective(BzLpjy record) {
        return bzLpjyMapper.insertSelective(record);
    }

    @Override
    public BzLpjy selectByPrimaryKey(String id) {
        return bzLpjyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzLpjy record) {
        return bzLpjyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzLpjy record) {
        return bzLpjyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzLpjy> selectByAll(BzLpjy bzLpjy) {
        return bzLpjyMapper.selectByAll(bzLpjy);
    }

    @Override
    public int updateBatch(List<BzLpjy> list) {
        return bzLpjyMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzLpjy> list) {
        return bzLpjyMapper.batchInsert(list);
    }

    @Override
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzLpjy> bzLpjys = bzLpjyMapper.selectByPage((BzLpjy) map.get("bzLpjy"));
        PageInfo<BzLpjy> pageInfo = new PageInfo<>(bzLpjys);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }

}
