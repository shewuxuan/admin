package com.guodu.service.impl.equip;

import com.guodu.mapper.equip.EquipPhotoMapper;
import com.guodu.pojo.equip.EquipPhoto;
import com.guodu.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipPhotoServiceImpl extends BaseServiceImpl<EquipPhoto> {
	@Autowired
	EquipPhotoMapper equipPhotoMapper;

}
