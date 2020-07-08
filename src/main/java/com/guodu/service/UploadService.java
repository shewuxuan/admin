package com.guodu.service;

import com.guodu.pojo.dtu.Jbxx;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: UploadService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/3/3 5:48 下午
 */
public interface UploadService {
    void uploadJl(Jbxx jbxx);
    void uploadJbxxFile(String tsid,List<Map<String,Object>> jbxxPhotos, String imgSavePath)throws Exception;
    void deleteJlByJbxx(String tsid);
    void uploadPwbhJl(Map<String, Object> map) throws Exception;
}
