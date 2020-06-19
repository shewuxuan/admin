package com.guodu.mapper.dtu;

import com.guodu.mapper.BaseMapper;
import com.guodu.pojo.dtu.JbxxGjdz;
import org.springframework.stereotype.Repository;

@Repository
public interface JbxxGjdzMapper extends BaseMapper<JbxxGjdz> {
    void deleteAllByTsid(String tsid);
}