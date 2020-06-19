package com.guodu.service.pwbh;

import java.util.List;
import com.guodu.pojo.pwbh.PwbhBzBhct;
    /**
 * @ClassName: PwbhBzBhctService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:57 下午
 */
public interface PwbhBzBhctService{


    int deleteByPrimaryKey(String id);

    int insert(PwbhBzBhct record);

    int insertSelective(PwbhBzBhct record);

    PwbhBzBhct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhBzBhct record);

    int updateByPrimaryKey(PwbhBzBhct record);

    List<PwbhBzBhct> selectByAll(PwbhBzBhct pwbhBzBhct);

    int updateBatch(List<PwbhBzBhct> list);

    int batchInsert(List<PwbhBzBhct> list);

    List<PwbhBzBhct> selectByPage(PwbhBzBhct pwbhBzBhct);

    }
