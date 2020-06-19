package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.guodu.pojo.dtu.JlCyjd;

import java.util.List;

import com.guodu.mapper.dtu.JlCyjdMapper;
import com.guodu.service.dtu.JlCyjdService;

/**
 * @ClassName: JlCyjdServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
@Service
public class JlCyjdServiceImpl implements JlCyjdService {

    @Resource
    private JlCyjdMapper jlCyjdMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlCyjdMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlCyjd record) {
        return jlCyjdMapper.insert(record);
    }

    @Override
    public int insertSelective(JlCyjd record) {
        return jlCyjdMapper.insertSelective(record);
    }

    @Override
    public JlCyjd selectByPrimaryKey(String id) {
        return jlCyjdMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlCyjd record) {
        return jlCyjdMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlCyjd record) {
        return jlCyjdMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<JlCyjd> list) {
        return jlCyjdMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlCyjd> list) {
        return jlCyjdMapper.batchInsert(list);
    }

    @Override
    public List<JlCyjd> selectByAll(JlCyjd jlCyjd) {
        return jlCyjdMapper.selectByAll(jlCyjd);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlCyjdMapper.deleteByTsid(tsid);
	}



}




