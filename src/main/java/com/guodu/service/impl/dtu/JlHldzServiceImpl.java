package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.mapper.dtu.JlHldzMapper;
import com.guodu.pojo.dtu.JlHldz;
import com.guodu.service.dtu.JlHldzService;

/**
 * @ClassName: JlHldzServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
@Service
public class JlHldzServiceImpl implements JlHldzService {

    @Resource
    private JlHldzMapper jlHldzMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlHldzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlHldz record) {
        return jlHldzMapper.insert(record);
    }

    @Override
    public int insertSelective(JlHldz record) {
        return jlHldzMapper.insertSelective(record);
    }

    @Override
    public JlHldz selectByPrimaryKey(String id) {
        return jlHldzMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlHldz record) {
        return jlHldzMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlHldz record) {
        return jlHldzMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<JlHldz> list) {
        return jlHldzMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlHldz> list) {
        return jlHldzMapper.batchInsert(list);
    }

    @Override
    public List<JlHldz> selectByAll(JlHldz jlHldz) {
        return jlHldzMapper.selectByAll(jlHldz);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlHldzMapper.deleteByTsid(tsid);
	}



}

