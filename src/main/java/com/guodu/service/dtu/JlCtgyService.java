package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlCtgy;

/**
 * @ClassName: JlCtgyService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:48 上午
 */
public interface JlCtgyService {


    int deleteByPrimaryKey(String id);

    int insert(JlCtgy record);

    int insertSelective(JlCtgy record);

    JlCtgy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlCtgy record);

    int updateByPrimaryKey(JlCtgy record);

    List<JlCtgy> selectByAll(JlCtgy jlCtgy);

    int updateBatch(List<JlCtgy> list);

    int batchInsert(List<JlCtgy> list);

	int deleteByTsid(String tsid);

}
