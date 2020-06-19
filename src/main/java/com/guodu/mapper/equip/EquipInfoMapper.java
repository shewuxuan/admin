package com.guodu.mapper.equip;

import com.guodu.mapper.BaseMapper;
import com.guodu.pojo.equip.EquipInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipInfoMapper extends BaseMapper<EquipInfo> {

    /**
     * select by primary key
     * @param sbid primary key
     * @return object by primary key
     */
    EquipInfo selectByPrimaryKey(String sbid);

    List<EquipInfo> selectByAll(EquipInfo equipInfo);
}
