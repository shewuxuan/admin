package com.guodu.controller.cq;

import cn.hutool.json.JSONUtil;
import com.guodu.pojo.cq.CqCount;
import com.guodu.pojo.cq.CqRecord;
import com.guodu.service.cq.CqCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CqController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/3/23 1:27 下午
 */
@RestController
@RequestMapping("cq_count/")
public class CqCountController {

    @Autowired
    private CqCountService cqCountServiceImpl;

    private final Map<String, Object> map = new HashMap<>(16);

    @RequestMapping("selectByAll")
    public String selectByCount(CqRecord record,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        map.clear();
//        PageHelper.startPage(page, rows);
        List<CqCount> cqCounts = cqCountServiceImpl.selectByAll(record);
//        PageInfo<CqCount> pageInfo = new PageInfo<>(cqCounts);

        map.put("total", cqCounts.size());
        map.put("rows", cqCounts);
        return JSONUtil.toJsonStr(map);
    }

}
