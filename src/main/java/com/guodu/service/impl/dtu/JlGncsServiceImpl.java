package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.mapper.dtu.JlGncsMapper;
import com.guodu.pojo.dtu.JlGncs;
import com.guodu.service.dtu.JlGncsService;

/**
 * @ClassName: JlGncsServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
@Service
public class JlGncsServiceImpl implements JlGncsService {

    @Resource
    private JlGncsMapper jlGncsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlGncsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlGncs record) {
        return jlGncsMapper.insert(record);
    }

    @Override
    public int insertSelective(JlGncs record) {
        return jlGncsMapper.insertSelective(record);
    }

    @Override
    public JlGncs selectByPrimaryKey(String id) {
        return jlGncsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlGncs record) {
        return jlGncsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlGncs record) {
        return jlGncsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<JlGncs> list) {
        return jlGncsMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlGncs> list) {
        return jlGncsMapper.batchInsert(list);
    }

    @Override
    public List<JlGncs> selectByAll(JlGncs jlGncs) {
        return jlGncsMapper.selectByAll(jlGncs);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlGncsMapper.deleteByTsid(tsid);
	}



}

