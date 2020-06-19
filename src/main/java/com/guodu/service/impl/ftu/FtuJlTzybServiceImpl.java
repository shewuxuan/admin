package com.guodu.service.impl.ftu;

import com.guodu.mapper.ftu.FtuJlTzybMapper;
import com.guodu.pojo.ftu.FtuJlTzyb;
import com.guodu.service.ftu.FtuJlTzybService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FtuJlTzybServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/12 2:07 下午
 */
@Service
public class FtuJlTzybServiceImpl implements FtuJlTzybService {

    @Resource
    private FtuJlTzybMapper ftuJlTzybMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuJlTzybMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuJlTzyb record) {
        return ftuJlTzybMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(FtuJlTzyb record) {
        return ftuJlTzybMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(FtuJlTzyb record) {
        return ftuJlTzybMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(FtuJlTzyb record) {
        return ftuJlTzybMapper.insertSelective(record);
    }

    @Override
    public FtuJlTzyb selectByPrimaryKey(String id) {
        return ftuJlTzybMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuJlTzyb record) {
        return ftuJlTzybMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuJlTzyb record) {
        return ftuJlTzybMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuJlTzyb> selectByAll(FtuJlTzyb ftuJlTzyb) {
        return ftuJlTzybMapper.selectByAll(ftuJlTzyb);
    }

    @Override
    public int updateBatch(List<FtuJlTzyb> list) {
        return ftuJlTzybMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<FtuJlTzyb> list) {
        return ftuJlTzybMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<FtuJlTzyb> list) {
        return ftuJlTzybMapper.batchInsert(list);
    }

}
