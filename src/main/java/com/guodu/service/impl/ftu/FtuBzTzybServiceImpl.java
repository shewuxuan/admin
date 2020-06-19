package com.guodu.service.impl.ftu;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.guodu.mapper.ftu.FtuBzTzybMapper;
import com.guodu.pojo.ftu.FtuBzTzyb;
import com.guodu.service.ftu.FtuBzTzybService;
/**
 * @ClassName: FtuBzTzybServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/7 4:22 下午
 */
@Service
public class FtuBzTzybServiceImpl implements FtuBzTzybService{

    @Resource
    private FtuBzTzybMapper ftuBzTzybMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ftuBzTzybMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FtuBzTzyb record) {
        return ftuBzTzybMapper.insert(record);
    }

    @Override
    public int insertSelective(FtuBzTzyb record) {
        return ftuBzTzybMapper.insertSelective(record);
    }

    @Override
    public FtuBzTzyb selectByPrimaryKey(String id) {
        return ftuBzTzybMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FtuBzTzyb record) {
        return ftuBzTzybMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FtuBzTzyb record) {
        return ftuBzTzybMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FtuBzTzyb> selectByAll(FtuBzTzyb ftuBzTzyb) {
        return ftuBzTzybMapper.selectByAll(ftuBzTzyb);
    }

    @Override
    public int updateBatch(List<FtuBzTzyb> list) {
        return ftuBzTzybMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<FtuBzTzyb> list) {
        return ftuBzTzybMapper.batchInsert(list);
    }

    @Override
    public List<FtuBzTzyb> selectByPage(FtuBzTzyb record) {
        return ftuBzTzybMapper.selectByPage(record);
    }

}
