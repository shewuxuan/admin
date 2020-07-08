package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhJbxxBeizhu;

/**
* @ClassName: PwbhJbxxBeizhuService
* @Description: TODO
* @Author: 2Uli
* @Date: 2020/6/11 4:01 下午
*/
public interface PwbhJbxxBeizhuService{


int deleteByPrimaryKey(String tsid);

int insert(PwbhJbxxBeizhu record);

int insertSelective(PwbhJbxxBeizhu record);

PwbhJbxxBeizhu selectByPrimaryKey(String tsid);

int updateByPrimaryKeySelective(PwbhJbxxBeizhu record);

int updateByPrimaryKey(PwbhJbxxBeizhu record);

}
