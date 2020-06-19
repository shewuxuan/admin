package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhBzJxdx;
import java.util.List;
    /**
 * @ClassName: PwbhBzJxdxService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:59 下午
 */
public interface PwbhBzJxdxService{


    int deleteByPrimaryKey(String id);

    int insert(PwbhBzJxdx record);

    int insertSelective(PwbhBzJxdx record);

    PwbhBzJxdx selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhBzJxdx record);

    int updateByPrimaryKey(PwbhBzJxdx record);

    List<PwbhBzJxdx> selectByAll(PwbhBzJxdx pwbhBzJxdx);

    int updateBatch(List<PwbhBzJxdx> list);

    int batchInsert(List<PwbhBzJxdx> list);

    List<PwbhBzJxdx> selectByPage(PwbhBzJxdx record);
    }
