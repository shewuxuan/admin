package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.guodu.pojo.dtu.JlXb;

import java.util.List;

import com.guodu.mapper.dtu.JlXbMapper;
import com.guodu.service.dtu.JlXbService;

/**
 * @ClassName: JlXbServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/11 4:45 下午
 */
@Service
public class JlXbServiceImpl implements JlXbService {

    @Resource
    private JlXbMapper jlXbMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlXbMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlXb record) {
        return jlXbMapper.insert(record);
    }

    @Override
    public int insertSelective(JlXb record) {
        return jlXbMapper.insertSelective(record);
    }

    @Override
    public JlXb selectByPrimaryKey(String id) {
        return jlXbMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlXb record) {
        return jlXbMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlXb record) {
        return jlXbMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<JlXb> selectByAll(JlXb jlXb) {
        return jlXbMapper.selectByAll(jlXb);
    }

    @Override
    public int updateBatch(List<JlXb> list) {
        return jlXbMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlXb> list) {
        return jlXbMapper.batchInsert(list);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlXbMapper.deleteByTsid(tsid);
	}




}
