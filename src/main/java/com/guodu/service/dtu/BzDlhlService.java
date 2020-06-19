package com.guodu.service.dtu;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzDlhl;

/**
 * @ClassName: BzDlhlService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:36 上午
 */
public interface BzDlhlService {


    int deleteByPrimaryKey(String id);

    int insert(BzDlhl record);

    int insertSelective(BzDlhl record);

    BzDlhl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzDlhl record);

    int updateByPrimaryKey(BzDlhl record);

    List<BzDlhl> selectByAll(BzDlhl bzDlhl);

    int updateBatch(List<BzDlhl> list);

    int batchInsert(List<BzDlhl> list);

    String selectByPage(Map<String, Object> map);
}

