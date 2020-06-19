package com.guodu.service.dtu;

import com.guodu.pojo.dtu.JlCyjd;

import java.util.List;

/**
 * @ClassName: JlCyjdService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
public interface JlCyjdService {


    int deleteByPrimaryKey(String id);

    int insert(JlCyjd record);

    int insertSelective(JlCyjd record);

    JlCyjd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlCyjd record);

    int updateByPrimaryKey(JlCyjd record);

    int updateBatch(List<JlCyjd> list);

    int batchInsert(List<JlCyjd> list);

    List<JlCyjd> selectByAll(JlCyjd jlCyjd);



	int deleteByTsid(String tsid);

}




