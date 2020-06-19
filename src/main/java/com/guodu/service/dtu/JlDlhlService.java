package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlDlhl;

/**
 * @ClassName: JlDlhlService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
public interface JlDlhlService {


    int deleteByPrimaryKey(String id);

    int insert(JlDlhl record);

    int insertSelective(JlDlhl record);

    JlDlhl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlDlhl record);

    int updateByPrimaryKey(JlDlhl record);

    int updateBatch(List<JlDlhl> list);

    int batchInsert(List<JlDlhl> list);

    List<JlDlhl> selectByAll(JlDlhl jlDlhl);



	int deleteByTsid(String tsid);

}

