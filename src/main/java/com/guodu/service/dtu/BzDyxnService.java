package com.guodu.service.dtu;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzDyxn;

/**
 * @ClassName: BzDyxnService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:38 上午
 */
public interface BzDyxnService {


    int deleteByPrimaryKey(String id);

    int insert(BzDyxn record);

    int insertSelective(BzDyxn record);

    BzDyxn selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzDyxn record);

    int updateByPrimaryKey(BzDyxn record);

    List<BzDyxn> selectByAll(BzDyxn bzDyxn);

    int updateBatch(List<BzDyxn> list);

    int batchInsert(List<BzDyxn> list);

    String selectByPage(Map<String, Object> map);
}
