package com.guodu.service.dtu;

import java.util.List;
import java.util.Map;

import com.guodu.pojo.dtu.BzKgg;

/**
 * @ClassName: BzKggService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/1/19 11:39 上午
 */
public interface BzKggService {


    int deleteByPrimaryKey(String id);

    int insert(BzKgg record);

    int insertSelective(BzKgg record);

    BzKgg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BzKgg record);

    int updateByPrimaryKey(BzKgg record);

    List<BzKgg> selectByAll(BzKgg bzKgg);

    int updateBatch(List<BzKgg> list);

    int batchInsert(List<BzKgg> list);

    String selectByPage(Map<String, Object> map);
}
