package com.guodu.service.impl.dtu;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzKgg;
import com.guodu.mapper.dtu.BzKggMapper;
import com.guodu.service.dtu.BzKggService;

/**
 * @ClassName: BzKggServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:39 上午
 */
@Service
public class BzKggServiceImpl implements BzKggService {

    @Resource
    private BzKggMapper bzKggMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bzKggMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BzKgg record) {
        return bzKggMapper.insert(record);
    }

    @Override
    public int insertSelective(BzKgg record) {
        return bzKggMapper.insertSelective(record);
    }

    @Override
    public BzKgg selectByPrimaryKey(String id) {
        return bzKggMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BzKgg record) {
        return bzKggMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BzKgg record) {
        return bzKggMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BzKgg> selectByAll(BzKgg bzKgg) {
        return bzKggMapper.selectByAll(bzKgg);
    }

    @Override
    public int updateBatch(List<BzKgg> list) {
        return bzKggMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<BzKgg> list) {
        return bzKggMapper.batchInsert(list);
    }

    @Override
    public String selectByPage(Map<String, Object> map) {
        // pagehelper分页
        PageHelper.startPage((Integer) map.get("page"), (Integer) map.get("rows"));
        List<BzKgg> bzKggs = bzKggMapper.selectByPage((BzKgg) map.get("bzKgg"));

        PageInfo<BzKgg> pageInfo = new PageInfo<>(bzKggs);

        Map<String, Object> respMap = new HashMap<>(16);
        respMap.put("rows", pageInfo.getList());
        respMap.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(respMap);
    }

}
