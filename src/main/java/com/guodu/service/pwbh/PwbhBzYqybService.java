package com.guodu.service.pwbh;

import java.util.List;
import com.guodu.pojo.pwbh.PwbhBzYqyb;
    /**
 * @ClassName: PwbhBzYqybService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 3:00 下午
 */
public interface PwbhBzYqybService{


    int deleteByPrimaryKey(String id);

    int insert(PwbhBzYqyb record);

    int insertSelective(PwbhBzYqyb record);

    PwbhBzYqyb selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhBzYqyb record);

    int updateByPrimaryKey(PwbhBzYqyb record);

    List<PwbhBzYqyb> selectByAll(PwbhBzYqyb pwbhBzYqyb);

    int updateBatch(List<PwbhBzYqyb> list);

    int batchInsert(List<PwbhBzYqyb> list);

    List<PwbhBzYqyb> selectByPage(PwbhBzYqyb record);
    }
