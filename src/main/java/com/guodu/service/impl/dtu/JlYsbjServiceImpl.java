package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.mapper.dtu.JlYsbjMapper;
import com.guodu.pojo.dtu.JlYsbj;
import com.guodu.service.dtu.JlYsbjService;

/**
 * @ClassName: JlYsbjServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/11 4:45 下午
 */
@Service
public class JlYsbjServiceImpl implements JlYsbjService {

    @Resource
    private JlYsbjMapper jlYsbjMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlYsbjMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlYsbj record) {
        return jlYsbjMapper.insert(record);
    }

    @Override
    public int insertSelective(JlYsbj record) {
        return jlYsbjMapper.insertSelective(record);
    }

    @Override
    public JlYsbj selectByPrimaryKey(String id) {
        return jlYsbjMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlYsbj record) {
        return jlYsbjMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlYsbj record) {
        return jlYsbjMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<JlYsbj> selectByAll(JlYsbj jlYsbj) {
        return jlYsbjMapper.selectByAll(jlYsbj);
    }

    @Override
    public int updateBatch(List<JlYsbj> list) {
        return jlYsbjMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlYsbj> list) {
        return jlYsbjMapper.batchInsert(list);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlYsbjMapper.deleteByTsid(tsid);
	}




}
