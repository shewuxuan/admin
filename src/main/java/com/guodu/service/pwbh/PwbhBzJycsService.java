package com.guodu.service.pwbh;

import com.guodu.pojo.pwbh.PwbhBzJycs;
import java.util.List;
    /**
 * @ClassName: PwbhBzJycsService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/8 2:59 下午
 */
public interface PwbhBzJycsService{


    int deleteByPrimaryKey(String id);

    int insert(PwbhBzJycs record);

    int insertSelective(PwbhBzJycs record);

    PwbhBzJycs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PwbhBzJycs record);

    int updateByPrimaryKey(PwbhBzJycs record);

    List<PwbhBzJycs> selectByAll(PwbhBzJycs pwbhBzJycs);

    int updateBatch(List<PwbhBzJycs> list);

    int batchInsert(List<PwbhBzJycs> list);

    List<PwbhBzJycs> selectByPage(PwbhBzJycs record);
    }
