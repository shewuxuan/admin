package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.mapper.dtu.JlKggMapper;
import com.guodu.pojo.dtu.JlKgg;
import com.guodu.service.dtu.JlKggService;

/**
 * @ClassName: JlKggServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
@Service
public class JlKggServiceImpl implements JlKggService {

    @Resource
    private JlKggMapper jlKggMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlKggMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlKgg record) {
        return jlKggMapper.insert(record);
    }

    @Override
    public int insertSelective(JlKgg record) {
        return jlKggMapper.insertSelective(record);
    }

    @Override
    public JlKgg selectByPrimaryKey(String id) {
        return jlKggMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlKgg record) {
        return jlKggMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlKgg record) {
        return jlKggMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<JlKgg> list) {
        return jlKggMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlKgg> list) {
        return jlKggMapper.batchInsert(list);
    }

    @Override
    public List<JlKgg> selectByAll(JlKgg jlKgg) {
        return jlKggMapper.selectByAll(jlKgg);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlKggMapper.deleteByTsid(tsid);
	}



}

