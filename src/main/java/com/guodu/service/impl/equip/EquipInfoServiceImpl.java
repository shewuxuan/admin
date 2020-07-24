package com.guodu.service.impl.equip;

import com.guodu.mapper.equip.EquipInfoMapper;
import com.guodu.pojo.equip.EquipInfo;
import com.guodu.pojo.equip.EquipPhoto;
import com.guodu.service.impl.BaseServiceImpl;
import com.guodu.util.FileHandleUtils;
import com.guodu.util.QRCodeUtil;
import com.guodu.util.StringUtils;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;



@Service
public class EquipInfoServiceImpl
		extends BaseServiceImpl<EquipInfo>
{
	@Autowired
	EquipInfoMapper equipInfoMapper;
	@Autowired
	EquipPhotoServiceImpl equipPhotoServiceImpl;

	public EquipInfo selectByPrimaryKey(String sbid) { return this.equipInfoMapper.selectByPrimaryKey(sbid); }



	public List<EquipInfo> selectByAll(EquipInfo equipInfo) { return this.equipInfoMapper.selectByAll(equipInfo); }



	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public void txAddEquipAndPhoto(HttpServletRequest request, EquipInfo equipInfo, String sbid, String imgSavePath) throws Exception {
		this.equipInfoMapper.insert(equipInfo);
		List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
		//上传文件
		MultipartFile file = null;
		String[] imgNames = equipInfo.getImgName();
		for (int i=0;i<files.size();i++) {
			file = files.get(i);
			String pid = StringUtils.createDateRandomString(new Date());
			FileHandleUtils.singlefileUpload(request,file,imgSavePath,pid);
			String fileName = file.getOriginalFilename();
			EquipPhoto photo = new EquipPhoto();
			photo.setPid(pid);
			photo.setSbid(sbid);
			if(imgNames.length<1 || imgNames[i]==null) photo.setPName("");
			else photo.setPName(imgNames[i]);
			photo.setPPath(imgSavePath + pid + fileName);
			this.equipPhotoServiceImpl.add(photo);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public void txUpdateEquipInfoAndPhoto(EquipInfo equipInfo, HttpServletRequest request,String imgSavePath) throws Exception {
		String flagArrayStr = equipInfo.getFlagArrayStr();
		if (!flagArrayStr.equals("")) {
			String[] fileIds = flagArrayStr.split(",");
			EquipPhoto equipPhoto = null;
			for (String pid : fileIds) {
				equipPhoto = this.equipPhotoServiceImpl.selectById(pid);
				FileHandleUtils.deleteFile(equipPhoto.getPPath());
				this.equipPhotoServiceImpl.delete(pid);
			}
		}

		List<EquipPhoto> photos = equipInfo.getPhoto();
		if(photos!=null && photos.size()>0){
			for(EquipPhoto photo:photos){
				photo.setPPath(null);
				photo.setSbid(null);
				equipPhotoServiceImpl.edit(photo);
			}
		}

		List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
		String[] imgNames = equipInfo.getImgName();
		for (int i = 0;i<files.size();i++) {
			MultipartFile file = files.get(i);
			String pid = StringUtils.createDateRandomString(new Date());
			FileHandleUtils.singlefileUpload(request,file,imgSavePath,pid);
			String fileName = file.getOriginalFilename();
			EquipPhoto photo = new EquipPhoto();
			photo.setPid(pid);
			photo.setSbid(equipInfo.getSbid());
			if(imgNames.length<1 || imgNames[i]==null) photo.setPName("");
			else photo.setPName(imgNames[i]);
			photo.setPPath(imgSavePath + pid + fileName);
			this.equipPhotoServiceImpl.add(photo);
		}
		this.edit(equipInfo);
	}


	public BufferedImage createQRCodeByEquipInfo(HttpServletRequest request, EquipInfo equipInfo) throws Exception {
		//反向地址解析  与标注相反location	lat<纬度>,lng<经度>	必选
		String url="http://api.map.baidu.com/marker?location="+equipInfo.getWd()+","+equipInfo.getJd()+"&title="+equipInfo.getXxwz()
				+"&content="
				+"终端名称:"+equipInfo.getZdmc()
				+"/装置类型:"+choiceSbZzlxName(equipInfo.getZzlx())
				+"&output=html&src=webapp.baidu.openAPIdemo";
		BufferedImage img = QRCodeUtil.encode(url,"","",true);
		return QRCodeUtil.QRCodeAddFont(img,equipInfo);
	}

	public String choiceSbZzlxName(String zzlx) {
		String name = "";
		switch (zzlx) {
			case "1":
				name ="开闭站";
				break;
			case "2":
				name = "开闭器";
				break;
			case "3":
				name = "分界室";
				break;
			case "4":
				name = "箱变";
				break;
			case "5":
				name = "配电室";
			case "6":
				name = "柱变";
			case "7":
				name = "柱上FTU";
			case "8":
				name = "故障指示器";
				break;
		}
		return name;
	}
}
