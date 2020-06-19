package com.guodu.service.ftu;

import java.util.List;
import com.guodu.pojo.ftu.FtuJbxx;

/**
 * @ClassName: FtuJbxxService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/13 5:05 下午
 */
public interface FtuJbxxService {


    int deleteByPrimaryKey(String tsid);

    int insert(FtuJbxx record);

    int insertSelective(FtuJbxx record);

    FtuJbxx selectByPrimaryKey(String tsid);

    int updateByPrimaryKeySelective(FtuJbxx record);

    int updateByPrimaryKey(FtuJbxx record);

    List<FtuJbxx> selectByAll(FtuJbxx ftuJbxx);

    int updateBatch(List<FtuJbxx> list);

    int batchInsert(List<FtuJbxx> list);

}


