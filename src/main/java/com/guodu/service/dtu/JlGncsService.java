package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlGncs;

/**
 * @ClassName: JlGncsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
public interface JlGncsService {


    int deleteByPrimaryKey(String id);

    int insert(JlGncs record);

    int insertSelective(JlGncs record);

    JlGncs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlGncs record);

    int updateByPrimaryKey(JlGncs record);

    int updateBatch(List<JlGncs> list);

    int batchInsert(List<JlGncs> list);

    List<JlGncs> selectByAll(JlGncs jlGncs);



	int deleteByTsid(String tsid);

}

