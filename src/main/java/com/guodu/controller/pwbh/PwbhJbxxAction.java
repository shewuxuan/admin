package com.guodu.controller.pwbh;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.guodu.pojo.pwbh.PwbhJbxx;
import com.guodu.pojo.sys.Auth;
import com.guodu.service.impl.pwbh.PwbhJbxxServiceImpl;
import com.guodu.util.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("pwbhJbxx")
public class PwbhJbxxAction {
	private static Logger log = Logger.getLogger(PwbhJbxxAction.class);
	@Autowired
	PwbhJbxxServiceImpl pwbhJbxxServiceImpl;

	@RequestMapping(value = {"toPwbhJbxxView.action"}, produces = { "application/json;charset=UTF-8" })
	public ModelAndView toPwbhJbxxView(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("pwbh/pwbhJbxxList");
		return view;
	}

	@RequestMapping(value = {"selectListPwbhJbxx.action"}, produces = { "application/json;charset=UTF-8" },method=RequestMethod.POST)
	public Object selectListPwbhJbxx(@RequestParam Map<String, Object> form,HttpServletRequest request) {
		Map res = new HashMap<String , Object>();
		try{
			res = this.pwbhJbxxServiceImpl.selectPage(form);
		}catch(Exception e){
			e.printStackTrace();
		}
		return JSON.toJSONString(res);

	}

	@RequestMapping(value = {"toSeePwbhJbxxView.action"}, produces = { "application/json;charset=UTF-8" })
	public ModelAndView toSeePwbhJbxxView(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("pwbh/seePwbhJbxx");
		String tsid = request.getParameter("tsid");
		PwbhJbxx pwbhJbxx = this.pwbhJbxxServiceImpl.selectById(tsid);
		view.addObject("pwbhJbxx", pwbhJbxx);
		return view;
	}

	@RequestMapping(value = {"delPwbhJbxx.action"}, produces = { "application/json;charset=UTF-8" },method=RequestMethod.POST)
	public Object delPwbhJbxx(@RequestParam Map<String, Object> form) {
		Map<String , Object> res = new HashMap<String , Object>();
		res.put("code", "0");
		res.put("message", "删除成功");
		String tsid = (String)form.get("tsid");
		try{
			this.pwbhJbxxServiceImpl.delete(tsid);
		}catch(Exception e){
			res.put("code", "-1");
			res.put("message", "删除失败");
			e.printStackTrace();
		}
		return JSON.toJSONString(res);
	}

	/***
	 * 调试信息导出
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = {"exportToWordByPwbhJbxx.action"}, produces = { "application/json;charset=UTF-8" })
	public void exportToWordByPwbhJbxx(HttpServletRequest request, HttpServletResponse response) {
		String tsid = request.getParameter("tsid");
		XWPFDocument doc = null;
		OutputStream os = null;
		try {
			PwbhJbxx pwbhJbxx = pwbhJbxxServiceImpl.selectById(tsid);
			doc = pwbhJbxxServiceImpl.exportToWordByWord(pwbhJbxx.getSsqy(),pwbhJbxx);
			os = response.getOutputStream();
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");
			response.setHeader("Content-disposition","attachment;filename="+java.net.URLEncoder.encode(pwbhJbxx.getAzddDdh()+"配网保护调试记录表", "UTF-8")+".docx");
			doc.write(os);
		}catch (Exception e) {
			e.printStackTrace();
			log.error("导出失败，请重新导出！");
		}finally {
			try {
				if(os!=null){
					os.flush();
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	@RequestMapping("getPwbh")
	public Object getPwbh(){
		return JSONUtil.toJsonStr(pwbhJbxxServiceImpl.getPwbh());
	}
}