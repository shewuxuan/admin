package com.guodu.service.dtu;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzJydz;

/**
 * @ClassName: BzJydzService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:39 上午
 */
public interface BzJydzService {


    int deleteByPrimaryKey(String id);

    int insert(BzJydz record);

    int insertSelective(BzJydz record);

    BzJydz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzJydz record);

    int updateByPrimaryKey(BzJydz record);

    List<BzJydz> selectByAll(BzJydz bzJydz);

    int updateBatch(List<BzJydz> list);

    int batchInsert(List<BzJydz> list);

    String selectByPage(Map<String, Object> map);
}
