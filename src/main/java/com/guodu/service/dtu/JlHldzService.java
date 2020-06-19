package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlHldz;

/**
 * @ClassName: JlHldzService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
public interface JlHldzService {


    int deleteByPrimaryKey(String id);

    int insert(JlHldz record);

    int insertSelective(JlHldz record);

    JlHldz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlHldz record);

    int updateByPrimaryKey(JlHldz record);

    int updateBatch(List<JlHldz> list);

    int batchInsert(List<JlHldz> list);

    List<JlHldz> selectByAll(JlHldz jlHldz);



	int deleteByTsid(String tsid);

}

