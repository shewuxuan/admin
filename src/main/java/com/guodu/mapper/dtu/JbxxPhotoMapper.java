package com.guodu.mapper.dtu;

import com.guodu.mapper.BaseMapper;
import com.guodu.pojo.dtu.JbxxPhoto;
import org.springframework.stereotype.Repository;


@Repository
public interface JbxxPhotoMapper extends BaseMapper<JbxxPhoto> {
    void deleteByTsid(String tsid);
}
