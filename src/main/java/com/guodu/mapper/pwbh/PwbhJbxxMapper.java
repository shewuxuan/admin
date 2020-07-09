package com.guodu.mapper.pwbh;

import com.guodu.mapper.BaseMapper;
import com.guodu.pojo.ftu.FtuJbxx;
import com.guodu.pojo.pwbh.PwbhJbxx;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PwbhJbxxMapper extends BaseMapper<PwbhJbxx> {
    PwbhJbxx selectByPrimaryKey(String id);
}