package com.guodu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guodu.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl<T> {
    @Autowired
    public BaseMapper<T> baseMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(T t) {
        boolean reslut = false;
        Integer iReslut = baseMapper.insert(t);
        if (iReslut == null || iReslut > 0) {
            reslut = true;
        }
        return reslut;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean edit(T t) {
        boolean reslut = false;
        Integer iReslut = baseMapper.update(t);
        if (iReslut == null || iReslut > 0) {
            reslut = true;
        }
        return reslut;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(String id) {
        boolean reslut = false;
        Integer iReslut = baseMapper.delete(id);
        if (iReslut == null || iReslut > 0) {
            reslut = true;
        }
        return reslut;
    }

    public Map<String, Object> selectPage(Map<String, Object> vo) throws Exception {
        Map<String, Object> res = new HashMap<String, Object>();
        PageHelper.startPage(Integer.valueOf(vo.get("page").toString()), Integer.valueOf(vo.get("rows").toString()));
        Page<List<Map<String, Object>>> shopList = (Page<List<Map<String, Object>>>) this.baseMapper.selectPage(vo);
        res.put("total", shopList.getTotal());
        res.put("rows", shopList);
        return res;
    }

    public List<T> selectList(Map<String, Object> map) {
        return this.baseMapper.selectList(map);
    }

    public T selectById(String id) {
        return this.baseMapper.selectById(id);
    }

    public List<Map<String, Object>> selectListAll() {
        return this.baseMapper.selectListAll();
    }
}
