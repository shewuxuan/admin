package com.guodu.service.pwbh;

import java.util.List;
import com.guodu.pojo.pwbh.PwbhBzSgjc;
    /**
 * @ClassName: PwbhBzSgjcService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 3:00 下午
 */
public interface PwbhBzSgjcService{


    int deleteByPrimaryKey(String id);

    int insert(PwbhBzSgjc record);

    int insertSelective(PwbhBzSgjc record);

    PwbhBzSgjc selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhBzSgjc record);

    int updateByPrimaryKey(PwbhBzSgjc record);

    List<PwbhBzSgjc> selectByAll(PwbhBzSgjc pwbhBzSgjc);

    int updateBatch(List<PwbhBzSgjc> list);

    int batchInsert(List<PwbhBzSgjc> list);

    List<PwbhBzSgjc> selectByPage(PwbhBzSgjc record);
    }
