package com.guodu.service.dtu;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzWgpz;

/**
 * @ClassName: BzWgpzService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:41 上午
 */
public interface BzWgpzService {


    int deleteByPrimaryKey(String id);

    int insert(BzWgpz record);

    int insertSelective(BzWgpz record);

    BzWgpz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzWgpz record);

    int updateByPrimaryKey(BzWgpz record);

    List<BzWgpz> selectByAll(BzWgpz bzWgpz);

    int updateBatch(List<BzWgpz> list);

    int batchInsert(List<BzWgpz> list);

    String selectByPage(Map<String, Object> map);
}
