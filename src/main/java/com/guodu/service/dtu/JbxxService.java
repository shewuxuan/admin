package com.guodu.service.dtu;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.Jbxx;

/**
 * @ClassName: JbxxService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 12:38 下午
 */
public interface JbxxService {


    int deleteByPrimaryKey(String tsid);

    int insert(Jbxx record);

    int insertSelective(Jbxx record);

    Jbxx selectByPrimaryKey(String tsid);

    int updateByPrimaryKeySelective(Jbxx record);

    int updateByPrimaryKey(Jbxx record);

    List<Jbxx> selectByAll(Jbxx jbxx);

    int updateBatch(List<Jbxx> list);

    int batchInsert(List<Jbxx> list);

    List<Jbxx> selectByPage(Map<String, Object> map);

    Map<String, Object> selectPage(Map<String, Object> vo);

}


