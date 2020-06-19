package com.guodu.service.cq;

import java.util.List;
import com.guodu.pojo.cq.CqCount;
import com.guodu.pojo.cq.CqRecord;

/**
 * @ClassName: CqCountService
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/6/5 2:31 下午
 */
public interface CqCountService {


    CqCount selectByPrimaryKey(String sbid);

    List<CqCount> selectByAll(CqRecord record);

}

