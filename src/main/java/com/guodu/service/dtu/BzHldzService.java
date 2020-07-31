package com.guodu.service.dtu;

import com.guodu.pojo.dtu.BzHldz;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzHldzService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:39 上午
 */
public interface BzHldzService {


    int deleteByPrimaryKey(String id);

    int insert(BzHldz record);

    int insertSelective(BzHldz record);

    BzHldz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzHldz record);

    int updateByPrimaryKey(BzHldz record);

    List<BzHldz> selectByAll(BzHldz bzHldz);

    int updateBatch(List<BzHldz> list);

    int batchInsert(List<BzHldz> list);

    List<BzHldz> selectByPage(BzHldz record);
}

