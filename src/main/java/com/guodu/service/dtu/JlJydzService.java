package com.guodu.service.dtu;

import java.util.List;

import com.guodu.pojo.dtu.JlJydz;

/**
 * @ClassName: JlJydzService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/10 11:28 上午
 */
public interface JlJydzService {


    int deleteByPrimaryKey(String id);

    int insert(JlJydz record);

    int insertSelective(JlJydz record);

    JlJydz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JlJydz record);

    int updateByPrimaryKey(JlJydz record);

    int updateBatch(List<JlJydz> list);

    int batchInsert(List<JlJydz> list);

    List<JlJydz> selectByAll(JlJydz jlJydz);



	int deleteByTsid(String tsid);

}

