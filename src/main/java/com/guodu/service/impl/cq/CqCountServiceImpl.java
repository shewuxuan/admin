package com.guodu.service.impl.cq;

import com.guodu.pojo.cq.CqRecord;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.guodu.pojo.cq.CqCount;
import com.guodu.mapper.cq.CqCountMapper;
import com.guodu.service.cq.CqCountService;

/**
 * @ClassName: CqCountServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/5 2:31 下午
 */
@Service
public class CqCountServiceImpl implements CqCountService {

    @Resource
    private CqCountMapper cqCountMapper;

    @Override
    public CqCount selectByPrimaryKey(String sbid) {
        return cqCountMapper.selectByPrimaryKey(sbid);
    }

    @Override
    public List<CqCount> selectByAll(CqRecord record) {
        return cqCountMapper.selectByAll(record);
    }

}

