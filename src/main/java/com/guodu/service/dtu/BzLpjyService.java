package com.guodu.service.dtu;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzLpjy;

/**
 * @ClassName: BzLpjyService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:40 上午
 */
public interface BzLpjyService {


    int deleteByPrimaryKey(String id);

    int insert(BzLpjy record);

    int insertSelective(BzLpjy record);

    BzLpjy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzLpjy record);

    int updateByPrimaryKey(BzLpjy record);

    List<BzLpjy> selectByAll(BzLpjy bzLpjy);

    int updateBatch(List<BzLpjy> list);

    int batchInsert(List<BzLpjy> list);

    String selectByPage(Map<String, Object> map);
}
