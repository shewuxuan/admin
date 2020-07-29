package com.guodu.service.impl.sys;

import com.guodu.mapper.sys.SysSsxlMapper;
import com.guodu.pojo.sys.SysSsxl;
import com.guodu.service.sys.SysSsxlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: SysSsxlServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/22 5:14 下午
 */
@Service
public class SysSsxlServiceImpl implements SysSsxlService {

    @Resource
    private SysSsxlMapper sysSsxlMapper;

    @Override
    public SysSsxl selectByPrimaryKey(String id) {
        return sysSsxlMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysSsxl> selectByAll(SysSsxl record) {
        return sysSsxlMapper.selectByAll(record);
    }

    @Override
    public List<SysSsxl> selectByGroup(SysSsxl sysSsxl, String groupBy) {
        return sysSsxlMapper.selectByGroup(sysSsxl, groupBy);
    }

    @Override
    public int insert(SysSsxl sysSsxl) {
        return sysSsxlMapper.insert(sysSsxl);
    }

    @Override
    public int getMaxId() {
        return sysSsxlMapper.getMaxId();
    }

}

