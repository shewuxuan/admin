package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.pojo.dtu.JlLpjy;
import com.guodu.mapper.dtu.JlLpjyMapper;
import com.guodu.service.dtu.JlLpjyService;

/**
 * @ClassName: JlLpjyServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
@Service
public class JlLpjyServiceImpl implements JlLpjyService {

    @Resource
    private JlLpjyMapper jlLpjyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlLpjyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlLpjy record) {
        return jlLpjyMapper.insert(record);
    }

    @Override
    public int insertSelective(JlLpjy record) {
        return jlLpjyMapper.insertSelective(record);
    }

    @Override
    public JlLpjy selectByPrimaryKey(String id) {
        return jlLpjyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlLpjy record) {
        return jlLpjyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlLpjy record) {
        return jlLpjyMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<JlLpjy> list) {
        return jlLpjyMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlLpjy> list) {
        return jlLpjyMapper.batchInsert(list);
    }

    @Override
    public List<JlLpjy> selectByAll(JlLpjy jlLpjy) {
        return jlLpjyMapper.selectByAll(jlLpjy);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlLpjyMapper.deleteByTsid(tsid);
	}



}

