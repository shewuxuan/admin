package com.guodu.mapper.dtu;

import com.guodu.pojo.dtu.JbxxBeizhu;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: JbxxBeizhuMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/4/29 12:22 下午
 */
@Mapper
public interface JbxxBeizhuMapper {
    int deleteByPrimaryKey(String tsid);

    int insert(JbxxBeizhu record);

    int insertSelective(JbxxBeizhu record);

    JbxxBeizhu selectByPrimaryKey(String tsid);

    int updateByPrimaryKeySelective(JbxxBeizhu record);

    int updateByPrimaryKey(JbxxBeizhu record);
}