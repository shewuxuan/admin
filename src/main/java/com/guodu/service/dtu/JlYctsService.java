package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlYcts;

/**
 * @ClassName: JlYctsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
public interface JlYctsService {


    int deleteByPrimaryKey(String id);

    int insert(JlYcts record);

    int insertSelective(JlYcts record);

    JlYcts selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlYcts record);

    int updateByPrimaryKey(JlYcts record);

    int updateBatch(List<JlYcts> list);

    int batchInsert(List<JlYcts> list);

    List<JlYcts> selectByAll(JlYcts jlYcts);



	int deleteByTsid(String tsid);

}

