package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.guodu.mapper.dtu.JlYktsMapper;

import java.util.List;

import com.guodu.pojo.dtu.JlYkts;
import com.guodu.service.dtu.JlYktsService;

/**
 * @ClassName: JlYktsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
@Service
public class JlYktsServiceImpl implements JlYktsService {

    @Resource
    private JlYktsMapper jlYktsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlYktsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlYkts record) {
        return jlYktsMapper.insert(record);
    }

    @Override
    public int insertSelective(JlYkts record) {
        return jlYktsMapper.insertSelective(record);
    }

    @Override
    public JlYkts selectByPrimaryKey(String id) {
        return jlYktsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlYkts record) {
        return jlYktsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlYkts record) {
        return jlYktsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<JlYkts> list) {
        return jlYktsMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlYkts> list) {
        return jlYktsMapper.batchInsert(list);
    }

    @Override
    public List<JlYkts> selectByAll(JlYkts jlYkts) {
        return jlYktsMapper.selectByAll(jlYkts);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlYktsMapper.deleteByTsid(tsid);
	}



}

