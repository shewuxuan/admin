package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.mapper.dtu.JlCtgyMapper;
import com.guodu.pojo.dtu.JlCtgy;
import com.guodu.service.dtu.JlCtgyService;

/**
 * @ClassName: JlCtgyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:48 上午
 */
@Service
public class JlCtgyServiceImpl implements JlCtgyService {

    @Resource
    private JlCtgyMapper jlCtgyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlCtgyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlCtgy record) {
        return jlCtgyMapper.insert(record);
    }

    @Override
    public int insertSelective(JlCtgy record) {
        return jlCtgyMapper.insertSelective(record);
    }

    @Override
    public JlCtgy selectByPrimaryKey(String id) {
        return jlCtgyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlCtgy record) {
        return jlCtgyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlCtgy record) {
        return jlCtgyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<JlCtgy> selectByAll(JlCtgy jlCtgy) {
        return jlCtgyMapper.selectByAll(jlCtgy);
    }

    @Override
    public int updateBatch(List<JlCtgy> list) {
        return jlCtgyMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlCtgy> list) {
        return jlCtgyMapper.batchInsert(list);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlCtgyMapper.deleteByTsid(tsid);
	}




}
