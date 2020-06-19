package com.guodu.service.dtu;

import com.guodu.pojo.dtu.JbxxBeizhu;

/**
 * @ClassName: JbxxBeizhuService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/29 9:46 上午
 */
public interface JbxxBeizhuService {


    int insert(JbxxBeizhu record);

    int insertSelective(JbxxBeizhu record);

    int deleteByPrimaryKey(String tsid);

    JbxxBeizhu selectByPrimaryKey(String tsid);

    int updateByPrimaryKeySelective(JbxxBeizhu record);

    int updateByPrimaryKey(JbxxBeizhu record);
}

