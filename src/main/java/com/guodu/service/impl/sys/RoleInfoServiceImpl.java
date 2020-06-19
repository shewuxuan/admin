package com.guodu.service.impl.sys;

import java.util.List;
import java.util.Map;
import com.guodu.mapper.sys.RoleInfoMapper;
import com.guodu.pojo.sys.RoleInfo;

import javax.annotation.Resource;

import com.guodu.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleInfoServiceImpl extends BaseServiceImpl<RoleInfo> {
	RoleInfoMapper roleInfoMapper;
	@Resource
	public void setRoleInfoDao(RoleInfoMapper roleInfoMapper) {
		this.roleInfoMapper = roleInfoMapper;
		super.baseMapper = roleInfoMapper;
	}
	
	public List<Map<String,Object>> getRoleByFunc(String roleId) {
		return this.roleInfoMapper.getRoleByFunc(roleId);
	}
	
	public List<Map<String,Object>> getAllFunc() {
		return this.roleInfoMapper.getAllFunc();
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void txAddRoleInfoAndRoleFunc(RoleInfo roleInfo,String[] authValue,String[] funcCode) {
		 this.roleInfoMapper.insert(roleInfo);
		 /*String roleId =  roleInfo.getRoleId();
		 Map<String,Object> vo = new HashMap<String,Object>();
		 for(int i = 0;i<authValue.length;i++){
			 vo.put("roleId", roleId);
			 vo.put("authValue", Integer.valueOf(authValue[i]));
			 vo.put("funcCode", funcCode[i]);
			 this.roleInfoMapper.addRoleFuncByRoleId(vo);
		 }*/
		 
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void txUpdateRoleFuncByRoleId(RoleInfo roleInfo,String[] authValue,String[] funcCode) {
		 this.roleInfoMapper.update(roleInfo);
		 /*Map<String,Object> vo = new HashMap<String,Object>();
		 for(int i = 0;i<authValue.length;i++){
			 vo.put("roleId", roleInfo.getRoleId());
			 vo.put("authValue", Integer.valueOf(authValue[i]));
			 vo.put("funcCode", funcCode[i]);
			 this.roleInfoMapper.updateRoleFuncByRoleId(vo);
		 }*/
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void txDelRoleInfoAndFuncInfo(String roleId) {
		 this.roleInfoMapper.deleteFuncInfoByRoleId(roleId);
		 this.roleInfoMapper.delete(roleId);
	}
	
	public List<Map<String,Object>> queryAllRoleInfo() {
		return this.roleInfoMapper.queryAllRoleInfo();
	}
	
	public List<Map<String, Object>> queryListAll()throws Exception{
		return this.selectListAll();
	}
	
}
