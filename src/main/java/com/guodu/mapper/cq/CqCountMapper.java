package com.guodu.mapper.cq;

import com.guodu.pojo.cq.CqCount;

import java.util.List;

import com.guodu.pojo.cq.CqRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: CqCountMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 1:43 下午
 */
@Mapper
public interface CqCountMapper {
    /**
     * select by primary key
     *
     * @param sbid primary key
     * @return object by primary key
     */
    CqCount selectByPrimaryKey(String sbid);

    List<CqCount> selectByAll(CqRecord cqCount);
}