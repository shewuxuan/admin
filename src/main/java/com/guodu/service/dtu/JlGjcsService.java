package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlGjcs;

/**
 * @ClassName: JlGjcsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
public interface JlGjcsService {


    int deleteByPrimaryKey(String id);

    int insert(JlGjcs record);

    int insertSelective(JlGjcs record);

    JlGjcs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlGjcs record);

    int updateByPrimaryKey(JlGjcs record);

    int updateBatch(List<JlGjcs> list);

    int batchInsert(List<JlGjcs> list);

    List<JlGjcs> selectByAll(JlGjcs jlGjcs);



	int deleteByTsid(String tsid);

}


