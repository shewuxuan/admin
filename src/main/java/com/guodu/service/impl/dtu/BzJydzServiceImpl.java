package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.mapper.dtu.BzJydzMapper;
import com.guodu.pojo.dtu.BzJydz;
import com.guodu.service.dtu.BzJydzService;

/**
 * @ClassName: BzJydzServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:39 上午
 */
@Service
public class BzJydzServiceImpl implements BzJydzService {

    @Resource
    private BzJydzMapper bzJydzMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzJydzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzJydz record) {
        return bzJydzMapper.insert(record);
    }

    @Override
    public int insertSelective(BzJydz record) {
        return bzJydzMapper.insertSelective(record);
    }

    @Override
    public BzJydz selectByPrimaryKey(String id) {
        return bzJydzMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzJydz record) {
        return bzJydzMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzJydz record) {
        return bzJydzMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzJydz> selectByAll(BzJydz bzJydz) {
        return bzJydzMapper.selectByAll(bzJydz);
    }

    @Override
    public int updateBatch(List<BzJydz> list) {
        return bzJydzMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzJydz> list) {
        return bzJydzMapper.batchInsert(list);
    }

    @Override
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzJydz> bzJydzs = bzJydzMapper.selectByPage((BzJydz) map.get("bzJydz"));

        PageInfo<BzJydz> pageInfo = new PageInfo<>(bzJydzs);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }

}
