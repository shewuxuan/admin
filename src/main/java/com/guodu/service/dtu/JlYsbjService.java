package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlYsbj;

/**
 * @ClassName: JlYsbjService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/11 4:45 下午
 */
public interface JlYsbjService {


    int deleteByPrimaryKey(String id);

    int insert(JlYsbj record);

    int insertSelective(JlYsbj record);

    JlYsbj selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlYsbj record);

    int updateByPrimaryKey(JlYsbj record);

    List<JlYsbj> selectByAll(JlYsbj jlYsbj);

    int updateBatch(List<JlYsbj> list);

    int batchInsert(List<JlYsbj> list);



	int deleteByTsid(String tsid);


}
