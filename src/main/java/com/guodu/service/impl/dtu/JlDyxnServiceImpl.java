package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.mapper.dtu.JlDyxnMapper;
import com.guodu.pojo.dtu.JlDyxn;
import com.guodu.service.dtu.JlDyxnService;

/**
 * @ClassName: JlDyxnServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
@Service
public class JlDyxnServiceImpl implements JlDyxnService {

    @Resource
    private JlDyxnMapper jlDyxnMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlDyxnMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlDyxn record) {
        return jlDyxnMapper.insert(record);
    }

    @Override
    public int insertSelective(JlDyxn record) {
        return jlDyxnMapper.insertSelective(record);
    }

    @Override
    public JlDyxn selectByPrimaryKey(String id) {
        return jlDyxnMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlDyxn record) {
        return jlDyxnMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlDyxn record) {
        return jlDyxnMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<JlDyxn> list) {
        return jlDyxnMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlDyxn> list) {
        return jlDyxnMapper.batchInsert(list);
    }

    @Override
    public List<JlDyxn> selectByAll(JlDyxn jlDyxn) {
        return jlDyxnMapper.selectByAll(jlDyxn);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlDyxnMapper.deleteByTsid(tsid);
	}



}


