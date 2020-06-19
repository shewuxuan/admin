package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlDyxn;

/**
 * @ClassName: JlDyxnService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
public interface JlDyxnService {


    int deleteByPrimaryKey(String id);

    int insert(JlDyxn record);

    int insertSelective(JlDyxn record);

    JlDyxn selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlDyxn record);

    int updateByPrimaryKey(JlDyxn record);

    int updateBatch(List<JlDyxn> list);

    int batchInsert(List<JlDyxn> list);

    List<JlDyxn> selectByAll(JlDyxn jlDyxn);



	int deleteByTsid(String tsid);

}

