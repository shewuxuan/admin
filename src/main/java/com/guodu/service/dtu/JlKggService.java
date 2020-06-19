package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlKgg;

/**
 * @ClassName: JlKggService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
public interface JlKggService {


    int deleteByPrimaryKey(String id);

    int insert(JlKgg record);

    int insertSelective(JlKgg record);

    JlKgg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlKgg record);

    int updateByPrimaryKey(JlKgg record);

    int updateBatch(List<JlKgg> list);

    int batchInsert(List<JlKgg> list);

    List<JlKgg> selectByAll(JlKgg jlKgg);



	int deleteByTsid(String tsid);

}

