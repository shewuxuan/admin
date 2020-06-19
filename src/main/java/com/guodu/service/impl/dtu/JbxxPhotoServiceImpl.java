package com.guodu.service.impl.dtu;

import com.guodu.mapper.dtu.JbxxPhotoMapper;
import com.guodu.pojo.dtu.JbxxPhoto;
import com.guodu.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JbxxPhotoServiceImpl extends BaseServiceImpl<JbxxPhoto> {
	@Autowired
	JbxxPhotoMapper jbxxPhotoMapper;

	public void deleteByTsid(String tsid){
		jbxxPhotoMapper.deleteByTsid(tsid);
	}

}
