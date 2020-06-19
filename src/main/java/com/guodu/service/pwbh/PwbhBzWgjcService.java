package com.guodu.service.pwbh;

import java.util.List;
import com.guodu.pojo.pwbh.PwbhBzWgjc;
    /**
 * @ClassName: PwbhBzWgjcService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 3:00 下午
 */
public interface PwbhBzWgjcService{


    int deleteByPrimaryKey(String id);

    int insert(PwbhBzWgjc record);

    int insertSelective(PwbhBzWgjc record);

    PwbhBzWgjc selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhBzWgjc record);

    int updateByPrimaryKey(PwbhBzWgjc record);

    List<PwbhBzWgjc> selectByAll(PwbhBzWgjc pwbhBzWgjc);

    int updateBatch(List<PwbhBzWgjc> list);

    int batchInsert(List<PwbhBzWgjc> list);

    List<PwbhBzWgjc> selectByPage(PwbhBzWgjc record);
    }
