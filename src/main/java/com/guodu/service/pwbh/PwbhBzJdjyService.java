package com.guodu.service.pwbh;

import java.util.List;
import com.guodu.pojo.pwbh.PwbhBzJdjy;
    /**
 * @ClassName: PwbhBzJdjyService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:58 下午
 */
public interface PwbhBzJdjyService{


    int deleteByPrimaryKey(String id);

    int insert(PwbhBzJdjy record);

    int insertSelective(PwbhBzJdjy record);

    PwbhBzJdjy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhBzJdjy record);

    int updateByPrimaryKey(PwbhBzJdjy record);

    List<PwbhBzJdjy> selectByAll(PwbhBzJdjy pwbhBzJdjy);

    int updateBatch(List<PwbhBzJdjy> list);

    int batchInsert(List<PwbhBzJdjy> list);

    List<PwbhBzJdjy> selectByPage(PwbhBzJdjy record);
    }
