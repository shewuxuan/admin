package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlDtu;

/**
 * @ClassName: JlDtuService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/11 4:44 下午
 */
public interface JlDtuService {


    int deleteByPrimaryKey(String id);

    int insert(JlDtu record);

    int insertSelective(JlDtu record);

    JlDtu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlDtu record);

    int updateByPrimaryKey(JlDtu record);

    List<JlDtu> selectByAll(JlDtu jlDtu);

    int updateBatch(List<JlDtu> list);

    int batchInsert(List<JlDtu> list);



	int deleteByTsid(String tsid);


}
