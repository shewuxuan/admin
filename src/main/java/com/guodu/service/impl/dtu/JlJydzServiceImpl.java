package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.mapper.dtu.JlJydzMapper;
import com.guodu.pojo.dtu.JlJydz;
import com.guodu.service.dtu.JlJydzService;

/**
 * @ClassName: JlJydzServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
@Service
public class JlJydzServiceImpl implements JlJydzService {

    @Resource
    private JlJydzMapper jlJydzMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlJydzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlJydz record) {
        return jlJydzMapper.insert(record);
    }

    @Override
    public int insertSelective(JlJydz record) {
        return jlJydzMapper.insertSelective(record);
    }

    @Override
    public JlJydz selectByPrimaryKey(String id) {
        return jlJydzMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlJydz record) {
        return jlJydzMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlJydz record) {
        return jlJydzMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<JlJydz> list) {
        return jlJydzMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlJydz> list) {
        return jlJydzMapper.batchInsert(list);
    }

    @Override
    public List<JlJydz> selectByAll(JlJydz jlJydz) {
        return jlJydzMapper.selectByAll(jlJydz);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlJydzMapper.deleteByTsid(tsid);
	}



}

