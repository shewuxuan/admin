package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.pojo.dtu.JlWgpz;
import com.guodu.mapper.dtu.JlWgpzMapper;
import com.guodu.service.dtu.JlWgpzService;

/**
 * @ClassName: JlWgpzServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
@Service
public class JlWgpzServiceImpl implements JlWgpzService {

    @Resource
    private JlWgpzMapper jlWgpzMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlWgpzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlWgpz record) {
        return jlWgpzMapper.insert(record);
    }

    @Override
    public int insertSelective(JlWgpz record) {
        return jlWgpzMapper.insertSelective(record);
    }

    @Override
    public JlWgpz selectByPrimaryKey(String id) {
        return jlWgpzMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlWgpz record) {
        return jlWgpzMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlWgpz record) {
        return jlWgpzMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<JlWgpz> list) {
        return jlWgpzMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlWgpz> list) {
        return jlWgpzMapper.batchInsert(list);
    }

    @Override
    public List<JlWgpz> selectByAll(JlWgpz jlWgpz) {
        return jlWgpzMapper.selectByAll(jlWgpz);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlWgpzMapper.deleteByTsid(tsid);
	}



}



