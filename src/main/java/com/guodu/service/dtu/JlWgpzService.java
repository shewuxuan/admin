package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlWgpz;

/**
 * @ClassName: JlWgpzService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
public interface JlWgpzService {


    int deleteByPrimaryKey(String id);

    int insert(JlWgpz record);

    int insertSelective(JlWgpz record);

    JlWgpz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlWgpz record);

    int updateByPrimaryKey(JlWgpz record);

    int updateBatch(List<JlWgpz> list);

    int batchInsert(List<JlWgpz> list);

    List<JlWgpz> selectByAll(JlWgpz jlWgpz);



	int deleteByTsid(String tsid);

}



