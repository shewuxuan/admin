package com.guodu.controller.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.guodu.pojo.sys.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import com.guodu.pojo.sys.RoleInfo;
import com.guodu.service.impl.sys.RoleInfoServiceImpl;
import com.guodu.util.StringUtils;


/**
* @ClassName: RoleInfoAction.java
* @Description: 角色相关操作
* @author: shewuxuan
* @date: 2020年3月13日
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
*  2020年3月13日   shewuxuan           v1.0.0               初始化构建
*/
@Controller
@RequestMapping("role")
public class RoleInfoAction {

	@Autowired
	RoleInfoServiceImpl roleInfoServiceImpl;
	
	
	
	@RequestMapping(value = {"selectListRoleInfo.action",  "/" }, produces = { "application/json;charset=UTF-8" },method=RequestMethod.POST)
	@ResponseBody
	public Object selectListRoleInfo(@RequestParam Map<String, Object> form) {
		Map<String , Object> res = new HashMap<String , Object>();
		String roleName = (String)form.get("roleName");
		Map<String,Object> vo = new HashMap<String,Object>();
		vo.put("roleName", roleName);
		try{
			res = this.roleInfoServiceImpl.selectPage(form);
 		}catch(Exception e){
 			e.printStackTrace();
		}
		return JSON.toJSONString(res);
		
	}
	
	@RequestMapping(value = {"toAddRoleInfoView.action",  "/" }, produces = { "application/json;charset=UTF-8" })
	public ModelAndView toAddRoleInfoView(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("sys/addRole");
		String roleId = request.getParameter("roleId") == null ? "":request.getParameter("roleId").toString();
		if(!roleId.equals("")){
			Map<String,Object> vo = new HashMap<String,Object>();
			vo.put("roleId", roleId);
			RoleInfo roleInfo = this.roleInfoServiceImpl.selectList(vo).get(0);
			view.addObject("roleInfo",roleInfo);
			Map<String,Object> resultMap = new HashMap<String,Object>();
			List<Map<String,Object>> roleFuncList = this.roleInfoServiceImpl.getRoleByFunc(roleId);
			for(Map<String,Object> map : roleFuncList){
				resultMap.put(map.get("FUNCCODE").toString(), map.get("AUTHVALUE"));
			}
			view.addObject("roleFuncList",resultMap);
		}else{
			List<Map<String,Object>> roleFuncList = this.roleInfoServiceImpl.getAllFunc();
			view.addObject("roleFuncList",roleFuncList);
		}
		return view;
	}
	@RequestMapping(value = {"addRoleInfo.action",  "/" }, produces = { "application/json;charset=UTF-8" },method=RequestMethod.POST)
	@ResponseBody
	public Object addRoleInfo(HttpServletRequest request,@RequestParam Map<String, Object> form) {
		Map<String , Object> res = new HashMap<String , Object>();
		res.put("code", "0");
		res.put("message", "添加成功");
		String roleName = (String)form.get("roleName");
		String remark = (String)form.get("remark");
		Map<String,Object> vo = new HashMap<String,Object>();
		vo.put("roleName", roleName);
		List<RoleInfo> list = this.roleInfoServiceImpl.selectList(vo);
		if(list != null && list.size() > 0 ){
			res.put("code", "-1");
			res.put("message", "角色已存在");
			return JSON.toJSONString(res);
		}
		/*String xmxx = (String)form.get("xmxx");//项目信息
		String cgjh = (String)form.get("cgjh");//采购计划
		String xmzb = (String)form.get("xmzb");//项目招标
		String xmys = (String)form.get("xmys");//项目预算	
		String xmht = (String)form.get("xmht");//项目合同	
		String xmys2 = (String)form.get("xmys2");//项目验收
		String djzc = (String)form.get("djzc");//登记资产
		String xmfk = (String)form.get("xmfk");//项目付款
		String pfgl = (String)form.get("pfgl");//批复管理	
		String tjhz = (String)form.get("tjhz");//统计汇总
		String yhgl = (String)form.get("yhgl");//用户管理
		String jsgl = (String)form.get("jsgl");//角色管理
		String xmrz = (String)form.get("xmrz");//项目日志
		String czrz = (String)form.get("czrz");//操作日志	*/
		RoleInfo roleInfo = new RoleInfo();
		/*String[] funcCode = {"xmxx","cgjh","xmzb","xmys","xmht","xmys2","djzc","xmfk","pfgl",
				"tjhz","yhgl","jsgl","xmrz","czrz"};
		String[] authValue= {xmxx,cgjh,xmzb,xmys,xmht,xmys2,djzc,xmfk,pfgl,tjhz,yhgl,jsgl,xmrz,czrz};*/
		String[] funcCode = {};
		String[] authValue = {};
		try {
			Date createDate = new Date();
			String roleId = StringUtils.createDateRandomString(createDate);
			roleInfo.setRoleId(roleId);
			res.put("lockData","角色ID："+roleId+",角色名称："+roleName);
			roleInfo.setRoleName(roleName);
			roleInfo.setBeizhu(remark);
			roleInfo.setCzsj(createDate);
			roleInfo.setCzr(Auth.getAuth(request).getLoginname());
			this.roleInfoServiceImpl.txAddRoleInfoAndRoleFunc(roleInfo,authValue,funcCode);
		} catch (Exception e) {
			res.put("code", "-1");
			res.put("message", "添加失败");
			e.printStackTrace();
		}	
		return JSON.toJSONString(res);	
	}
	
	@RequestMapping(value = {"updeatRoleInfo.action",  "/" }, produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object updeatRoleInfo(@RequestParam Map<String, Object> form, HttpServletRequest request) {
		Map<String , Object> res = new HashMap<String , Object>();
		String roleName = (String)form.get("roleName");
		String remark = (String)form.get("remark");
		String roleId = (String)form.get("roleId");
		Date date = new Date();
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setRoleId(roleId);
		res.put("lockData","角色ID："+roleId+",角色名称："+roleName);
		roleInfo.setRoleName(roleName);
		roleInfo.setBeizhu(remark);
		roleInfo.setCzsj(date);
		roleInfo.setCzr(Auth.getAuth(request).getLoginname());
		res.put("code", "0");
		res.put("message", "修改成功");
		try{
			/*String xmxx = (String)form.get("xmxx");//项目信息
			String cgjh = (String)form.get("cgjh");//采购计划
			String xmzb = (String)form.get("xmzb");//项目招标
			String xmys = (String)form.get("xmys");//项目预算	
			String xmht = (String)form.get("xmht");//项目合同	
			String xmys2 = (String)form.get("xmys2");//项目验收
			String djzc = (String)form.get("djzc");//登记资产
			String xmfk = (String)form.get("xmfk");//项目付款
			String pfgl = (String)form.get("pfgl");//批复管理	
			String tjhz = (String)form.get("tjhz");//统计汇总
			String yhgl = (String)form.get("yhgl");//用户管理
			String jsgl = (String)form.get("jsgl");//角色管理
			String xmrz = (String)form.get("xmrz");//项目日志
			String czrz = (String)form.get("czrz");//操作日志	
			String[] funcCode = {"xmxx","cgjh","xmzb","xmys","xmht","xmys2","djzc","xmfk","pfgl",
					"tjhz","yhgl","jsgl","xmrz","czrz"};
			String[] authValue = {xmxx,cgjh,xmzb,xmys,xmht,xmys2,djzc,xmfk,pfgl,tjhz,yhgl,jsgl,xmrz,czrz};*/
			String[] funcCode = {};
			String[] authValue = {};
			this.roleInfoServiceImpl.txUpdateRoleFuncByRoleId(roleInfo,authValue,funcCode);
		}catch(Exception e){
			res.put("code", "-1");
			res.put("message", "修改失败");
			e.printStackTrace();
		}
		return JSON.toJSONString(res);	
	}
	
	@RequestMapping(value = {"delRoleInfo.action",  "/" }, produces = { "application/json;charset=UTF-8" },method=RequestMethod.POST)
	@ResponseBody
	public Object delRoleInfo(@RequestParam Map<String, Object> form) {
		Map<String , Object> res = new HashMap<String , Object>();
		res.put("code", "0");
		res.put("message", "删除成功");
		String roleId = (String)form.get("roleId");
		res.put("dataId",roleId);
		try{
			RoleInfo roleInfo = this.roleInfoServiceImpl.selectById(roleId);
			res.put("lockData","角色ID："+roleId+",角色名称："+roleInfo.getRoleName());
			this.roleInfoServiceImpl.txDelRoleInfoAndFuncInfo(roleId);
		}catch(Exception e){
			res.put("code", "-1");
			res.put("message", "删除失败");
			e.printStackTrace();
		}
		return JSON.toJSONString(res);	
	}
	
	@RequestMapping(value = {"queryAllRoleInfo.action",  "/" }, produces = { "application/json;charset=UTF-8" },method=RequestMethod.POST)
	@ResponseBody
	public Object queryAllRoleInfo(@RequestParam Map<String, Object> form) {
		List<Map<String, Object>> queryAllRoleInfo = null;
		try{
			 queryAllRoleInfo = this.roleInfoServiceImpl.queryAllRoleInfo();
		}catch(Exception e){
			e.printStackTrace();
		}
		return JSON.toJSONString(queryAllRoleInfo);
	}
}
