package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlYkts;

/**
 * @ClassName: JlYktsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
public interface JlYktsService {


    int deleteByPrimaryKey(String id);

    int insert(JlYkts record);

    int insertSelective(JlYkts record);

    JlYkts selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlYkts record);

    int updateByPrimaryKey(JlYkts record);

    int updateBatch(List<JlYkts> list);

    int batchInsert(List<JlYkts> list);

    List<JlYkts> selectByAll(JlYkts jlYkts);



	int deleteByTsid(String tsid);

}

