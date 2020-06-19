package com.guodu.service.pwbh;

import java.util.List;
import com.guodu.pojo.pwbh.PwbhBzDzjc;
    /**
 * @ClassName: PwbhBzDzjcService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:58 下午
 */
public interface PwbhBzDzjcService{


    int deleteByPrimaryKey(String id);

    int insert(PwbhBzDzjc record);

    int insertSelective(PwbhBzDzjc record);

    PwbhBzDzjc selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhBzDzjc record);

    int updateByPrimaryKey(PwbhBzDzjc record);

    List<PwbhBzDzjc> selectByAll(PwbhBzDzjc pwbhBzDzjc);

    int updateBatch(List<PwbhBzDzjc> list);

    int batchInsert(List<PwbhBzDzjc> list);

    List<PwbhBzDzjc> selectByPage(PwbhBzDzjc record);
    }
