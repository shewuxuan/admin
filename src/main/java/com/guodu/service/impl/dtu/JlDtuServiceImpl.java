package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.mapper.dtu.JlDtuMapper;
import com.guodu.pojo.dtu.JlDtu;
import com.guodu.service.dtu.JlDtuService;

/**
 * @ClassName: JlDtuServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/11 4:44 下午
 */
@Service
public class JlDtuServiceImpl implements JlDtuService {

    @Resource
    private JlDtuMapper jlDtuMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlDtuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlDtu record) {
        return jlDtuMapper.insert(record);
    }

    @Override
    public int insertSelective(JlDtu record) {
        return jlDtuMapper.insertSelective(record);
    }

    @Override
    public JlDtu selectByPrimaryKey(String id) {
        return jlDtuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlDtu record) {
        return jlDtuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlDtu record) {
        return jlDtuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<JlDtu> selectByAll(JlDtu jlDtu) {
        return jlDtuMapper.selectByAll(jlDtu);
    }

    @Override
    public int updateBatch(List<JlDtu> list) {
        return jlDtuMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlDtu> list) {
        return jlDtuMapper.batchInsert(list);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlDtuMapper.deleteByTsid(tsid);
	}




}
