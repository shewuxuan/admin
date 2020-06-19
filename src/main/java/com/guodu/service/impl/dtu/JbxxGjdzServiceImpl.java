package com.guodu.service.impl.dtu;

import com.guodu.mapper.dtu.JbxxGjdzMapper;
import com.guodu.pojo.dtu.JbxxGjdz;
import com.guodu.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JbxxGjdzServiceImpl extends BaseServiceImpl<JbxxGjdz> {
    @Autowired
    JbxxGjdzMapper jbxxGjdzMapper;

    public void deleteAllByTsid(String tsid){
        jbxxGjdzMapper.deleteAllByTsid(tsid);
    }
}
