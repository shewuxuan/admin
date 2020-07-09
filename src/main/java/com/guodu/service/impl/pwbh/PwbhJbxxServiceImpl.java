package com.guodu.service.impl.pwbh;

import cn.hutool.json.JSONUtil;
import com.guodu.mapper.pwbh.PwbhJbxxMapper;
import com.guodu.pojo.pwbh.*;
import com.guodu.pojo.sys.SysSsxl;
import com.guodu.service.impl.BaseServiceImpl;
import com.guodu.service.pwbh.*;
import com.guodu.service.sys.SysSsxlService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PwbhJbxxServiceImpl extends BaseServiceImpl<PwbhJbxx> {
    /**单一实现类直接继承BaseServiceImpl，调用父类共有方法，不需要单独写接口**/
    @Autowired
    private PwbhJbxxMapper pwbhJbxxMapper;

    /**  查询配网保护相关标准 **/
    @Autowired
    PwbhBzBhctService pwbhBzBhctServiceImpl;
    @Autowired
    PwbhBzDzjcService pwbhBzDzjcServiceImpl;
    @Autowired
    PwbhBzJdjyService pwbhBzJdjyServiceImpl;
    @Autowired
    PwbhBzJxdxService pwbhBzJxdxServiceImpl;
    @Autowired
    PwbhBzJycsService pwbhBzJycsServiceImpl;
    @Autowired
    PwbhBzLpjyService pwbhBzLpjyServiceImpl;
    @Autowired
    PwbhBzSgjcService pwbhBzSgjcServiceImpl;
    @Autowired
    PwbhBzWgjcService pwbhBzWgjcServiceImpl;
    @Autowired
    PwbhBzYqybService pwbhBzYqybServiceImpl;
    @Autowired
    PwbhBzZzsyService pwbhBzZzsyServiceImpl;
    public Object getPwbh(){
        Map<String,String> result = new HashMap<>();
        List<PwbhBzBhct> pwbhBzBhct = pwbhBzBhctServiceImpl.selectByAll(null);
        List<PwbhBzDzjc> pwbhBzDzjc = pwbhBzDzjcServiceImpl.selectByAll(null);
        List<PwbhBzJdjy> pwbhBzJdjy = pwbhBzJdjyServiceImpl.selectByAll(null);
        List<PwbhBzJxdx> pwbhBzJxdx = pwbhBzJxdxServiceImpl.selectByAll(null);
        List<PwbhBzJycs> pwbhBzJycs = pwbhBzJycsServiceImpl.selectByAll(null);
        List<PwbhBzLpjy> pwbhBzLpjy = pwbhBzLpjyServiceImpl.selectByAll(null);
        List<PwbhBzSgjc> pwbhBzSgjc = pwbhBzSgjcServiceImpl.selectByAll(null);
        List<PwbhBzWgjc> pwbhBzWgjc = pwbhBzWgjcServiceImpl.selectByAll(null);
        List<PwbhBzYqyb> pwbhBzYqyb = pwbhBzYqybServiceImpl.selectByAll(null);
        List<PwbhBzZzsy> pwbhBzZzsy = pwbhBzZzsyServiceImpl.selectByAll(null);

        result.put("bzBhct", JSONUtil.toJsonStr(pwbhBzBhct));
        result.put("bzDzjc", JSONUtil.toJsonStr(pwbhBzDzjc));
        result.put("bzJdjy", JSONUtil.toJsonStr(pwbhBzJdjy));
        result.put("bzJxdx", JSONUtil.toJsonStr(pwbhBzJxdx));
        result.put("bzJycs", JSONUtil.toJsonStr(pwbhBzJycs));
        result.put("bzLpjy", JSONUtil.toJsonStr(pwbhBzLpjy));
        result.put("bzSgjc", JSONUtil.toJsonStr(pwbhBzSgjc));
        result.put("bzWgjc", JSONUtil.toJsonStr(pwbhBzWgjc));
        result.put("bzYqyb", JSONUtil.toJsonStr(pwbhBzYqyb));
        result.put("bzZzsy", JSONUtil.toJsonStr(pwbhBzZzsy));

        return result;
    }

    /**配网保护导出**/
    @Autowired
    private ExportPwbhDocumentService exportPwbhDocumentService;
    @Autowired
    PwbhJlBhctbhService pwbhJlBhctbhService;
    @Autowired
    PwbhJlBhcthlService pwbhJlBhcthlServiceImpl;
    @Autowired
    PwbhJlBhctjxService pwbhJlBhctjxServiceImpl;
    @Autowired
    PwbhJlDzdjcService pwbhJlDzdjcServiceImpl;
    @Autowired
    PwbhJlDzjcService pwbhJlDzjcServiceImpl;
    @Autowired
    PwbhJlJdjyService pwbhJlJdjyServiceImpl;
    @Autowired
    PwbhJlJxdxService pwbhJlJxdxServiceImpl;
    @Autowired
    PwbhJlJycsService pwbhJlJycsServiceImpl;
    @Autowired
    PwbhJlLpjyService pwbhJlLpjyServiceImpl;
    @Autowired
    PwbhJlSgjcService pwbhJlSgjcServiceImpl;
    @Autowired
    PwbhJlWgjcService pwbhJlWgjcServiceImpl;
    @Autowired
    PwbhJlYqybService PwbhJlYqybServiceImpl;
    @Autowired
    PwbhJlZzsyService pwbhJlZzsyServiceImpl;
    @Autowired
    PwbhJbxxBeizhuService pwbhJbxxBeizhuServiceImpl;
    @Autowired
    PwbhDzService PwbhDzServiceImpl;
    @Autowired
    SysSsxlService sysSsxlServiceImpl;

    public XWPFDocument exportToWordByWord(String ssqy, PwbhJbxx pwbhJbxx){
        String tsid = pwbhJbxx.getTsid();
        XWPFDocument document = null;
        try {
            PwbhJbxxBeizhu beizhu = pwbhJbxxBeizhuServiceImpl.selectByPrimaryKey(tsid);
            SysSsxl sysSsxl = sysSsxlServiceImpl.selectByPrimaryKey(pwbhJbxx.getSsxl());
            document = exportPwbhDocumentService.createDocument(pwbhJbxx,beizhu,sysSsxl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //所需仪器仪表
        PwbhJlYqyb yqyb = new PwbhJlYqyb();
        yqyb.setSsqy(ssqy);
        yqyb.setTsid(tsid);
        List<PwbhJlYqyb> pwbhJlYqybs = PwbhJlYqybServiceImpl.selectByAll(yqyb);
        exportPwbhDocumentService.createTableByYqyb(document,pwbhJlYqybs);
        //外观检查
        PwbhJlWgjc wgjc = new PwbhJlWgjc();
        wgjc.setSsqy(ssqy);
        wgjc.setTsid(tsid);
        List<PwbhJlWgjc> pwbhJlWgjcs = pwbhJlWgjcServiceImpl.selectByAll(wgjc);
        exportPwbhDocumentService.createTableByWgjc(document,pwbhJlWgjcs);

        //紧线及对线
        PwbhJlJxdx jxdx = new PwbhJlJxdx();
        jxdx.setSsqy(ssqy);
        jxdx.setTsid(tsid);
        List<PwbhJlJxdx> pwbhJlJxdxes = pwbhJlJxdxServiceImpl.selectByAll(jxdx);
        exportPwbhDocumentService.createTableByJxdx(document,pwbhJlJxdxes);

        //校对时钟
        PwbhJbxxBeizhu szjcjg = pwbhJbxxBeizhuServiceImpl.selectByPrimaryKey(tsid);
        exportPwbhDocumentService.createTableByJdsz(document,szjcjg.getSzjcjg());

        //绝缘测试
        PwbhJlJycs jycs = new PwbhJlJycs();
        jycs.setSsqy(ssqy);
        jycs.setTsid(tsid);
        List<PwbhJlJycs> pwbhJlJycs = pwbhJlJycsServiceImpl.selectByAll(jycs);
        exportPwbhDocumentService.createTableByJycs(document,pwbhJlJycs);

        //定值单检查
        PwbhJlDzdjc dzdjc = new PwbhJlDzdjc();
        dzdjc.setSsqy(ssqy);
        dzdjc.setTsid(tsid);
        List<PwbhJlDzdjc> pwbhJlDzdjcs = pwbhJlDzdjcServiceImpl.selectByAll(dzdjc);
        exportPwbhDocumentService.createTableByDzdjc(document,pwbhJlDzdjcs);

        //电流、电压零漂校验
        PwbhJlLpjy lpjy = new PwbhJlLpjy();
        lpjy.setSsqy(ssqy);
        lpjy.setTsid(tsid);
        List<PwbhJlLpjy> pwbhJlLpjies = pwbhJlLpjyServiceImpl.selectByAll(lpjy);
        exportPwbhDocumentService.createTableByLpjy(document,pwbhJlLpjies);

        //电流、电压精度检验
        PwbhJlJdjy jdjy = new PwbhJlJdjy();
        jdjy.setSsqy(ssqy);
        jdjy.setTsid(tsid);
        List<PwbhJlJdjy> pwbhJlJdjies = pwbhJlJdjyServiceImpl.selectByAll(jdjy);
        exportPwbhDocumentService.createTableByJdjy(document,pwbhJlJdjies);

        //保护CT极性
        PwbhJlBhctjx bhctjx = new PwbhJlBhctjx();
        bhctjx.setSsqy(ssqy);
        bhctjx.setTsid(tsid);
        List<PwbhJlBhctjx> pwbhJlBhctjxes = pwbhJlBhctjxServiceImpl.selectByAll(bhctjx);
        exportPwbhDocumentService.createTableByBhctjx(document,pwbhJlBhctjxes);

        //保护CT变比
        PwbhJlBhctbh bhctbh = new PwbhJlBhctbh();
        bhctbh.setSsqy(ssqy);
        bhctbh.setTsid(tsid);
        List<PwbhJlBhctbh> pwbhJlBhctbhs = pwbhJlBhctbhService.selectByAll(bhctbh);
        exportPwbhDocumentService.createTableByCtbh(document,pwbhJlBhctbhs);

        //定值检查
        PwbhJlDzjc dzjc = new PwbhJlDzjc();
        dzjc.setSsqy(ssqy);
        dzjc.setTsid(tsid);
        List<PwbhJlDzjc> pwbhJlDzjcs = pwbhJlDzjcServiceImpl.selectByAll(dzjc);
        PwbhDz pwbhDz = PwbhDzServiceImpl.selectByPrimaryKey(tsid);
        exportPwbhDocumentService.createTableByDzjc(document,pwbhJlDzjcs,pwbhDz);

        //整组试验及实际断路器传动
        PwbhJlZzsy zzsy = new PwbhJlZzsy();
        zzsy.setSsqy(ssqy);
        zzsy.setTsid(tsid);
        List<PwbhJlZzsy> pwbhJlZzsies = pwbhJlZzsyServiceImpl.selectByAll(zzsy);
        exportPwbhDocumentService.createTableByZzsy(document,pwbhJlZzsies);

        //保护CT回路接触电阻：（误差不得超过10％）
        PwbhJlBhcthl bhcthl = new PwbhJlBhcthl();
        bhcthl.setSsqy(ssqy);
        bhcthl.setTsid(tsid);
        List<PwbhJlBhcthl> pwbhJlBhcthls = pwbhJlBhcthlServiceImpl.selectByAll(bhcthl);
        exportPwbhDocumentService.createTableByBhcthl(document,pwbhJlBhcthls);

        //收工前需检查的项目
        PwbhJlSgjc sgjc = new PwbhJlSgjc();
        sgjc.setSsqy(ssqy);
        sgjc.setTsid(tsid);
        List<PwbhJlSgjc> pwbhJlSgjcs = pwbhJlSgjcServiceImpl.selectByAll(sgjc);
        exportPwbhDocumentService.createTableBySgjc(document,pwbhJlSgjcs);

        //检验结论
        //****
        return document;
    }
}
