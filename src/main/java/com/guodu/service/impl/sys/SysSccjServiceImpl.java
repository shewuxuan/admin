package com.guodu.service.impl.sys;

import com.guodu.mapper.sys.SysSccjMapper;
import com.guodu.pojo.sys.SysSccj;
import com.guodu.service.impl.BaseServiceImpl;
import com.guodu.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysSccjServiceImpl extends BaseServiceImpl<SysSccj> {
	@Autowired
    SysSccjMapper sysSccjMapper;

	public void addCjmcByName(String cjmc){
		//添加未保存的模块厂家
		Map vo = new HashMap();
		vo.put("cjmc",cjmc);
		List list = selectList(vo);
		if(list == null || list.size()<1){
			SysSccj sysSccj = new SysSccj();
			sysSccj.setId(StringUtils.createDateRandomString(new Date()));
			sysSccj.setCjmc(cjmc);
			add(sysSccj);
		}
	}

}
