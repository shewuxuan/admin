package com.guodu.service.pwbh;

import java.util.List;
import com.guodu.pojo.pwbh.PwbhBzLpjy;
    /**
 * @ClassName: PwbhBzLpjyService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 3:00 下午
 */
public interface PwbhBzLpjyService{


    int deleteByPrimaryKey(String id);

    int insert(PwbhBzLpjy record);

    int insertSelective(PwbhBzLpjy record);

    PwbhBzLpjy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhBzLpjy record);

    int updateByPrimaryKey(PwbhBzLpjy record);

    List<PwbhBzLpjy> selectByAll(PwbhBzLpjy pwbhBzLpjy);

    int updateBatch(List<PwbhBzLpjy> list);

    int batchInsert(List<PwbhBzLpjy> list);

    List<PwbhBzLpjy> selectByPage(PwbhBzLpjy record);
    }
