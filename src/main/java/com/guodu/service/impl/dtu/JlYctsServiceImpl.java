package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.mapper.dtu.JlYctsMapper;
import com.guodu.pojo.dtu.JlYcts;
import com.guodu.service.dtu.JlYctsService;

/**
 * @ClassName: JlYctsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
@Service
public class JlYctsServiceImpl implements JlYctsService {

    @Resource
    private JlYctsMapper jlYctsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlYctsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlYcts record) {
        return jlYctsMapper.insert(record);
    }

    @Override
    public int insertSelective(JlYcts record) {
        return jlYctsMapper.insertSelective(record);
    }

    @Override
    public JlYcts selectByPrimaryKey(String id) {
        return jlYctsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlYcts record) {
        return jlYctsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlYcts record) {
        return jlYctsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<JlYcts> list) {
        return jlYctsMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlYcts> list) {
        return jlYctsMapper.batchInsert(list);
    }

    @Override
    public List<JlYcts> selectByAll(JlYcts jlYcts) {
        return jlYctsMapper.selectByAll(jlYcts);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlYctsMapper.deleteByTsid(tsid);
	}



}

