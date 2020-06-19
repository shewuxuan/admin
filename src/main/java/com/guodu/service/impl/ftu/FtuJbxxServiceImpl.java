package com.guodu.service.impl.ftu;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.guodu.mapper.ftu.FtuJbxxMapper;
import java.util.List;
import com.guodu.pojo.ftu.FtuJbxx;
import com.guodu.service.ftu.FtuJbxxService;

/**
 * @ClassName: FtuJbxxServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/13 5:05 下午
 */
@Service
public class FtuJbxxServiceImpl implements FtuJbxxService {

    @Resource
    private FtuJbxxMapper ftuJbxxMapper;

    @Override
    public int deleteByPrimaryKey(String tsid) {
        return ftuJbxxMapper.deleteByPrimaryKey(tsid);
    }

    @Override
    public int insert(FtuJbxx record) {
        return ftuJbxxMapper.insert(record);
    }

    @Override
    public int insertSelective(FtuJbxx record) {
        return ftuJbxxMapper.insertSelective(record);
    }

    @Override
    public FtuJbxx selectByPrimaryKey(String tsid) {
        return ftuJbxxMapper.selectByPrimaryKey(tsid);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJbxx record) {
        return ftuJbxxMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJbxx record) {
        return ftuJbxxMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJbxx> selectByAll(FtuJbxx ftuJbxx) {
        return ftuJbxxMapper.selectByAll(ftuJbxx);
    }

    @Override
    public int updateBatch(List<FtuJbxx> list) {
        return ftuJbxxMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<FtuJbxx> list) {
        return ftuJbxxMapper.batchInsert(list);
    }

}


