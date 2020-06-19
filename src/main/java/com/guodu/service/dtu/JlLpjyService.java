package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlLpjy;

/**
 * @ClassName: JlLpjyService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
public interface JlLpjyService {


    int deleteByPrimaryKey(String id);

    int insert(JlLpjy record);

    int insertSelective(JlLpjy record);

    JlLpjy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlLpjy record);

    int updateByPrimaryKey(JlLpjy record);

    int updateBatch(List<JlLpjy> list);

    int batchInsert(List<JlLpjy> list);

    List<JlLpjy> selectByAll(JlLpjy jlLpjy);



	int deleteByTsid(String tsid);

}

