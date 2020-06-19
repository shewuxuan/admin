package com.guodu.service.dtu;

import com.guodu.pojo.dtu.JlXb;

import java.util.List;

/**
 * @ClassName: JlXbService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/11 4:45 下午
 */
public interface JlXbService {


    int deleteByPrimaryKey(String id);

    int insert(JlXb record);

    int insertSelective(JlXb record);

    JlXb selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlXb record);

    int updateByPrimaryKey(JlXb record);

    List<JlXb> selectByAll(JlXb jlXb);

    int updateBatch(List<JlXb> list);

    int batchInsert(List<JlXb> list);



	int deleteByTsid(String tsid);


}
