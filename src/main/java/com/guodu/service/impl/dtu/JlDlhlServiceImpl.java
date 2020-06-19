package com.guodu.service.impl.dtu;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.guodu.mapper.dtu.JlDlhlMapper;
import com.guodu.pojo.dtu.JlDlhl;
import com.guodu.service.dtu.JlDlhlService;

/**
 * @ClassName: JlDlhlServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
@Service
public class JlDlhlServiceImpl implements JlDlhlService {

    @Resource
    private JlDlhlMapper jlDlhlMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return jlDlhlMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JlDlhl record) {
        return jlDlhlMapper.insert(record);
    }

    @Override
    public int insertSelective(JlDlhl record) {
        return jlDlhlMapper.insertSelective(record);
    }

    @Override
    public JlDlhl selectByPrimaryKey(String id) {
        return jlDlhlMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JlDlhl record) {
        return jlDlhlMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JlDlhl record) {
        return jlDlhlMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<JlDlhl> list) {
        return jlDlhlMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JlDlhl> list) {
        return jlDlhlMapper.batchInsert(list);
    }

    @Override
    public List<JlDlhl> selectByAll(JlDlhl jlDlhl) {
        return jlDlhlMapper.selectByAll(jlDlhl);
    }

	@Override
	public int deleteByTsid(String tsid){
		 return jlDlhlMapper.deleteByTsid(tsid);
	}



}

