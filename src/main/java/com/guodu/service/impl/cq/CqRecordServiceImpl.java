package com.guodu.service.impl.cq;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guodu.mapper.cq.CqRecordMapper;
import com.guodu.mapper.equip.EquipInfoMapper;
import com.guodu.pojo.cq.CqRecord;
import com.guodu.service.cq.CqRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName: CqRecordServiceImpl
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/3/19 3:17 下午
 */
@Service
public class CqRecordServiceImpl implements CqRecordService {

    @Resource
    private CqRecordMapper cqRecordMapper;
    @Resource
    private EquipInfoMapper equipInfoMapper;

    @Override
    public int deleteByPrimaryKey(String cqid) {
        return cqRecordMapper.deleteByPrimaryKey(cqid);
    }

    @Override
    public int insert(CqRecord record) {
        return cqRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(CqRecord record) {
        return cqRecordMapper.insertSelective(record);
    }

    @Override
    public CqRecord selectByPrimaryKey(String cqid) {
        return cqRecordMapper.selectByPrimaryKey(cqid);
    }

    @Override
    public int updateByPrimaryKeySelective(CqRecord record) {
        return cqRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CqRecord record) {
        return cqRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CqRecord> selectByAll(CqRecord cqRecord) {
        return cqRecordMapper.selectByAll(cqRecord);
    }

    @Override
    public int updateBatch(List<CqRecord> list) {
        return cqRecordMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<CqRecord> list) {
        return cqRecordMapper.batchInsert(list);
    }

    @Override
    public List<CqRecord> selectByPage(CqRecord record) {
        return cqRecordMapper.selectByPage(record);


    }

    @Override
    public Map<String, Object> selectPageCqCount(Map<String, Object> vo) {
        Map<String, Object> res = new HashMap<String, Object>();
        PageHelper.startPage(Integer.valueOf(vo.get("page").toString()), Integer.valueOf(vo.get("rows").toString()));
        Page<List<Map<String, Object>>> shopList = (Page<List<Map<String, Object>>>) this.cqRecordMapper.selectPageCqCount(vo);
        res.put("total", shopList.getTotal());
        res.put("dataList", shopList);
        List<Map<String, Object>> result = (List<Map<String, Object>>)res.get("dataList");
        List<Map<String, Object>> cqList = new ArrayList<Map<String, Object>>();
        String azddDdh = "";
        for(Map<String, Object> data:result){
            azddDdh = data.get("azdd_ddh").toString();
            data.put("qx1","0");
            data.put("qx2","0");
            data.put("qx3","0");
            data.put("qx4","0");
            data.put("qx5","0");
            vo.put("azddDdh",azddDdh);
            int sum = 0;
            List<Map<String, Object>> cqQxflListMap = cqRecordMapper.getCqQxflGroupConut(vo);
            for(Map<String, Object> cqQxflMap:cqQxflListMap){
                sum+=Integer.valueOf(cqQxflMap.get("alls").toString());
               switch (cqQxflMap.get("qxfl").toString()){
                   case "1":
                       data.put("qx1",cqQxflMap.get("alls"));
                       data.put("ids1",cqQxflMap.get("ids"));
                       break;
                   case "2":
                       data.put("qx2",cqQxflMap.get("alls"));
                       data.put("ids2",cqQxflMap.get("ids"));
                       break;
                   case "3":
                       data.put("qx3",cqQxflMap.get("alls"));
                       data.put("ids3",cqQxflMap.get("ids"));
                       break;
                   case "4":
                       data.put("qx4",cqQxflMap.get("alls"));
                       data.put("ids4",cqQxflMap.get("ids"));
                       break;
                   case "5":
                       data.put("qx5",cqQxflMap.get("alls"));
                       data.put("ids5",cqQxflMap.get("ids"));
                       break;
               }
            }
            data.put("sum",sum);
            cqList.add(data);
        }
        res.put("rows", cqList);
        return res;
    }

    public List<Map<String,Object>>  getCqRecords(String[] idArr){
        return cqRecordMapper.getCqRecords(idArr);

    }

}


