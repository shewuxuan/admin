package com.guodu.service.impl.dtu;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guodu.mapper.dtu.JbxxMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.Jbxx;
import com.guodu.service.dtu.JbxxService;

/**
 * @ClassName: JbxxServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:38 下午
 */
@Service
public class JbxxServiceImpl implements JbxxService {

    @Resource
    private JbxxMapper jbxxMapper;

    @Override
    public int deleteByPrimaryKey(String tsid) {
        return jbxxMapper.deleteByPrimaryKey(tsid);
    }

    @Override
    public int insert(Jbxx record) {
        return jbxxMapper.insert(record);
    }

    @Override
    public int insertSelective(Jbxx record) {
        return jbxxMapper.insertSelective(record);
    }

    @Override
    public Jbxx selectByPrimaryKey(String tsid) {
        return jbxxMapper.selectByPrimaryKey(tsid);
    }

    @Override
    public int updateByPrimaryKeySelective(Jbxx record) {
        return jbxxMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Jbxx record) {
        return jbxxMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Jbxx> selectByAll(Jbxx jbxx) {
        return jbxxMapper.selectByAll(jbxx);
    }

    @Override
    public int updateBatch(List<Jbxx> list) {
        return jbxxMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<Jbxx> list) {
        return jbxxMapper.batchInsert(list);
    }

    @Override
    public List<Jbxx> selectByPage(Map<String, Object> map) {
        return jbxxMapper.selectByPage(map);
    }

    @Override
    public Map<String, Object> selectPage(Map<String, Object> vo) {
        Map<String, Object> res = new HashMap<String, Object>();
        PageHelper.startPage(Integer.valueOf(vo.get("page").toString()), Integer.valueOf(vo.get("rows").toString()));
        Page<List<Map<String, Object>>> shopList = (Page<List<Map<String, Object>>>) this.jbxxMapper.selectPage(vo);
        res.put("total", shopList.getTotal());
        res.put("rows", shopList);
        return res;
    }
}


