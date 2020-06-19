package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.guodu.mapper.dtu.JlGjcsMapper;

import java.util.List;

import com.guodu.pojo.dtu.JlGjcs;
import com.guodu.service.dtu.JlGjcsService;

/**
 * @ClassName: JlGjcsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
@Service
public class JlGjcsServiceImpl implements JlGjcsService {

    @Resource
    private JlGjcsMapper jlGjcsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlGjcsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlGjcs record) {
        return jlGjcsMapper.insert(record);
    }

    @Override
    public int insertSelective(JlGjcs record) {
        return jlGjcsMapper.insertSelective(record);
    }

    @Override
    public JlGjcs selectByPrimaryKey(String id) {
        return jlGjcsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlGjcs record) {
        return jlGjcsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlGjcs record) {
        return jlGjcsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<JlGjcs> list) {
        return jlGjcsMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlGjcs> list) {
        return jlGjcsMapper.batchInsert(list);
    }

    @Override
    public List<JlGjcs> selectByAll(JlGjcs jlGjcs) {
        return jlGjcsMapper.selectByAll(jlGjcs);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlGjcsMapper.deleteByTsid(tsid);
	}



}


