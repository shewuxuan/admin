package com.guodu.service.impl.pwbh;

import com.guodu.pojo.pwbh.*;
import com.guodu.pojo.sys.SysSsxl;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by word .
 */
@Service
public class ExportPwbhDocumentService {

    public PwbhJbxxBeizhu beizhu;
    public XWPFDocument createDocument(PwbhJbxx pwbhJbxx, PwbhJbxxBeizhu beizhu, SysSsxl sysSsxl)throws Exception {
        XWPFDocument document= new XWPFDocument();
        this.beizhu = beizhu;
        toParagraph(document);
        toParagraph(document);
        //添加标题
        XWPFParagraph titleParagraph = document.createParagraph();
        //设置段落居中
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleParagraphRun = titleParagraph.createRun();
        titleParagraphRun.setText("配网保护验收报告");
        titleParagraphRun.setColor("000000");
        titleParagraphRun.setFontSize(26);
        titleParagraphRun.setBold(true);

        XWPFParagraph titleParagraph2 = document.createParagraph();
        titleParagraph2.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleParagraphRun2 = titleParagraph2.createRun();
        titleParagraphRun2.setText("  所属线路："+returnString(sysSsxl.getBdz()+sysSsxl.getXlmc()));
        titleParagraphRun2.setColor("000000");
        titleParagraphRun2.setFontSize(18);
        titleParagraphRun2.setBold(false);

        XWPFParagraph titleParagraph3 = document.createParagraph();
        titleParagraph3.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleParagraphRun3 = titleParagraph3.createRun();
        titleParagraphRun3.setText("    调度号："+returnString(pwbhJbxx.getAzddDdh()));
        titleParagraphRun3.setColor("000000");
        titleParagraphRun3.setFontSize(18);
        titleParagraphRun3.setBold(false);

        XWPFParagraph titleParagraph4 = document.createParagraph();
        titleParagraph4.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleParagraphRun4 = titleParagraph4.createRun();
        titleParagraphRun4.setText("      路名："+returnString(pwbhJbxx.getLm()));
        titleParagraphRun4.setColor("000000");
        titleParagraphRun4.setFontSize(18);
        titleParagraphRun4.setBold(false);

        toParagraph(document);
        toParagraph(document);

        XWPFParagraph titleParagraph5 = document.createParagraph();
        titleParagraph5.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun titleParagraphRun5 = titleParagraph5.createRun();
        titleParagraphRun5.setText("工作负责人："+pwbhJbxx.getGzfzr());
        titleParagraphRun5.setFontSize(18);

        XWPFParagraph titleParagraph6 = document.createParagraph();
        titleParagraph6.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun titleParagraphRun6 = titleParagraph6.createRun();
        titleParagraphRun6.setText("工作人员："+pwbhJbxx.getGzry());
        titleParagraphRun6.setFontSize(18);

        XWPFParagraph titleParagraph7 = document.createParagraph();
        titleParagraph7.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun titleParagraphRun7 = titleParagraph7.createRun();
        titleParagraphRun7.setText("路名："+pwbhJbxx.getLm());
        titleParagraphRun7.setFontSize(18);

        XWPFParagraph titleParagraph8 = document.createParagraph();
        titleParagraph8.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun titleParagraphRun8 = titleParagraph8.createRun();
        titleParagraphRun8.setText("工作日期："+pwbhJbxx.getTssj().substring(0,10));
        titleParagraphRun8.setFontSize(18);

        toParagraph(document);
        toParagraph(document);

        XWPFParagraph titleParagraph9 = document.createParagraph();
        titleParagraph9.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleParagraphRun9 = titleParagraph9.createRun();
        titleParagraphRun9.setText("石景山供电公司");
        titleParagraphRun9.setFontSize(18);
        for(int i=0;i<20;i++) toParagraph(document);
        return document;
    }

    /***
     * 所需仪器仪表
     * @param document
     * @param pwbhJlYqybs
     * @return
     */
    public XWPFDocument createTableByYqyb(XWPFDocument document, List<PwbhJlYqyb> pwbhJlYqybs){
        createTitle(document,"检验作业流程控制");
        toParagraph(document);
        createTitle(document,"1、所需仪器仪表");
        XWPFTable infoTable = createTable(document);
        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.setHeight(10);
        infoTableRowOne.getCell(0).setText("序号");
        infoTableRowOne.addNewTableCell().setText("试验仪器名称");
        infoTableRowOne.addNewTableCell().setText("设备型号");
        infoTableRowOne.addNewTableCell().setText("编号");
        infoTableRowOne.addNewTableCell().setText("合格期限");
        setCellTextAlign( infoTableRowOne.getCell(0));
        setCellTextAlign( infoTableRowOne.getCell(1));
        setCellTextAlign( infoTableRowOne.getCell(2));
        setCellTextAlign( infoTableRowOne.getCell(3));
        setCellTextAlign( infoTableRowOne.getCell(4));

        PwbhJlYqyb yqyb = null;
        for(int i=0;i<pwbhJlYqybs.size();i++){
            yqyb = pwbhJlYqybs.get(i);
            XWPFTableRow infoTableRowTwo = infoTable.createRow();
            infoTableRowTwo.getCell(0).setText(String.valueOf(i+1));
            setCellTextAlign( infoTableRowTwo.getCell(0));
            infoTableRowTwo.getCell(1).setText(returnString(yqyb.getYqmc()));
            infoTableRowTwo.getCell(2).setText(returnString(yqyb.getSbxh()));
            infoTableRowTwo.getCell(3).setText(returnString(yqyb.getBh()));
            infoTableRowTwo.getCell(4).setText(returnString(yqyb.getHgqx()));
        }
        return document;
    }

    /***
     * 外观检查
     * @param document
     * @return
     */
    public XWPFDocument createTableByWgjc(XWPFDocument document, List<PwbhJlWgjc> pwbhJlWgjcs){
        toParagraph(document);
        createTitle(document,"2、外观检查");
        XWPFTable infoTable = createTable(document);
        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.setHeight(20);
        infoTableRowOne.getCell(0).setText("内  容");
        infoTableRowOne.addNewTableCell().setText("检查结果");
        setCellTextAlign(infoTableRowOne.getCell(0));
        setCellTextAlign(infoTableRowOne.getCell(1));

        for(PwbhJlWgjc pwbhJlWgjc:pwbhJlWgjcs){
            XWPFTableRow infoTableRowTow = infoTable.createRow();
            infoTableRowTow.getCell(0).setText(returnString(pwbhJlWgjc.getNr()));
            infoTableRowTow.getCell(1).setText(switchJcjg("0",returnString(pwbhJlWgjc.getJcjg())));
            setCellTextAlign(infoTableRowTow.getCell(1));
        }
        createRemark(document,returnString(beizhu.getPwbhJlWgjc()));
        return document;
    }

    /***
     * 紧线及对线
     * @param document
     * @return
     */
    public XWPFDocument createTableByJxdx(XWPFDocument document, List<PwbhJlJxdx> pwbhJlJxdxs ){
        toParagraph(document);
        createTitle(document,"3、紧线及对线");
        XWPFTable infoTable = createTable(document);
        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("内  容");
        infoTableRowOne.addNewTableCell().setText("检查结果");
        setCellWidth(infoTableRowOne.getCell(0),360);
        setCellWidth(infoTableRowOne.getCell(1),120);
        setCellTextAlign(infoTableRowOne.getCell(0));
        setCellTextAlign(infoTableRowOne.getCell(1));

        for(PwbhJlJxdx pwbhJlJxdx:pwbhJlJxdxs){
            //表格第2行
            XWPFTableRow infoTableRowTow = infoTable.createRow();
            infoTableRowTow.getCell(0).setText(returnString(pwbhJlJxdx.getNr()));
            infoTableRowTow.getCell(1).setText(switchJcjg("0",returnString(pwbhJlJxdx.getJcjg())));
            setCellWidth(infoTableRowTow.getCell(0),360);
            setCellWidth(infoTableRowTow.getCell(1),120);
            setCellTextAlign(infoTableRowTow.getCell(1));
        }
        createRemark(document,returnString(beizhu.getPwbhJlJxdx()));
        return document;
    }

    /***
     * 校对时钟
     * @param document
     * @return
     */
    public XWPFDocument createTableByJdsz(XWPFDocument document,String jcjg){
        toParagraph(document);
        createTitle(document,"4、校对时钟");
        createTitle(document,"检验要求：将装置时钟校对至当前时钟，以便于系统故障时进行分析。");
        createTitle(document,"检查结果：______"+(jcjg==null?"_":switchJcjg("1",jcjg))+"______");
        return document;
    }
    /***
     * 绝缘测试
     * @param document
     * @return
     */
    public XWPFDocument createTableByJycs(XWPFDocument document, List<PwbhJlJycs> pwbhJlJycss){
        toParagraph(document);
        createTitle(document,"5、绝缘测试");
        XWPFTable infoTable = createTable(document);
        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("检查内容");
        infoTableRowOne.addNewTableCell().setText("标  准");
        infoTableRowOne.addNewTableCell().setText("试验结果");
        setCellTextAlign(infoTableRowOne.getCell(0));
        setCellTextAlign(infoTableRowOne.getCell(1));
        setCellTextAlign(infoTableRowOne.getCell(2));

        for(PwbhJlJycs pwbhJlJycs:pwbhJlJycss){
            XWPFTableRow infoTableRowTow = infoTable.createRow();
            infoTableRowTow.getCell(0).setText(returnString(pwbhJlJycs.getJcnr()));
            infoTableRowTow.getCell(1).setText(returnString(pwbhJlJycs.getBz()));
            infoTableRowTow.getCell(2).setText(switchJcjg("0",returnString(pwbhJlJycs.getSyjg())));
            setCellTextAlign(infoTableRowTow.getCell(2));
        }
        createRemark(document,returnString(beizhu.getPwbhJlJycs()));
        return document;
    }

    /***
     * 定值单检查
     * @param document
     * @return
     */
    public XWPFDocument createTableByDzdjc(XWPFDocument document,List<PwbhJlDzdjc> pwbhJlDzdjcs){
        toParagraph(document);
        createTitle(document,"6、定值单检查:");
        XWPFTable infoTable = createTable(document);
        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("出单日期");
        infoTableRowOne.addNewTableCell().setText("定值单号");
        infoTableRowOne.addNewTableCell().setText("版本");
        infoTableRowOne.addNewTableCell().setText("校验码");
        infoTableRowOne.addNewTableCell().setText("程序形成时间");
        setCellTextAlign(infoTableRowOne.getCell(0));
        setCellTextAlign(infoTableRowOne.getCell(1));
        setCellTextAlign(infoTableRowOne.getCell(2));
        setCellTextAlign(infoTableRowOne.getCell(3));
        setCellTextAlign(infoTableRowOne.getCell(4));
        for(PwbhJlDzdjc pwbhJlDzdjc:pwbhJlDzdjcs){
            XWPFTableRow infoTableRowTow = infoTable.createRow();
            infoTableRowTow.getCell(0).setText(returnString(pwbhJlDzdjc.getCdrq()));
            infoTableRowTow.getCell(1).setText(returnString(pwbhJlDzdjc.getDzdh()));
            infoTableRowTow.getCell(2).setText(returnString(pwbhJlDzdjc.getBb()));
            infoTableRowTow.getCell(3).setText(returnString(pwbhJlDzdjc.getJym()));
            infoTableRowTow.getCell(4).setText(returnString(pwbhJlDzdjc.getCxsj()));
        }
        return document;
    }


    /***
     * 电流、电压零漂校验
     * @param document
     * @param pwbhJlLpjys
     * @return
     */
    public XWPFDocument createTableByLpjy(XWPFDocument document, List<PwbhJlLpjy> pwbhJlLpjys) {
        toParagraph(document);
        createTitle(document, "7、电流、电压零漂校验");
        XWPFTable infoTable = createTable(document);

        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("测试结果");
        infoTableRowOne.addNewTableCell().setText("");
        infoTableRowOne.addNewTableCell().setText("CPU");
        setCellTextAlign(infoTableRowOne.getCell(0));
        setCellTextAlign(infoTableRowOne.getCell(2));

        mergeCellsHorizontal(infoTable,0,0,1);
        infoTable.getRow(0).getCell(0).getCTTc().addNewTcPr().addNewTcW()
                .setW(BigInteger.valueOf((9072 / 3) * (1 - 0 + 1)));
        setCellWidth(infoTableRowOne.getCell(0),60);
        setCellWidth(infoTableRowOne.getCell(1),120);
        setCellWidth(infoTableRowOne.getCell(2),90);

        for(PwbhJlLpjy pwbhJlLpjy:pwbhJlLpjys){
            XWPFTableRow infoTableRowTow = infoTable.createRow();
            infoTableRowTow.getCell(0).setText("");
            infoTableRowTow.getCell(1).setText(returnString(pwbhJlLpjy.getCsjg()));
            infoTableRowTow.getCell(2).setText(switchJcjg("0",returnString(pwbhJlLpjy.getCpu())));
            setCellTextAlign(infoTableRowTow.getCell(0));
            setCellTextAlign(infoTableRowTow.getCell(1));
            setCellTextAlign(infoTableRowTow.getCell(2));
            setCellWidth(infoTableRowTow.getCell(0),60);
            setCellWidth(infoTableRowTow.getCell(1),120);
            setCellWidth(infoTableRowTow.getCell(2),90);
        }


       if(pwbhJlLpjys!=null && pwbhJlLpjys.size()>1) {
            List<XWPFTableRow> rows = infoTable.getRows();
            infoTable.getRow(1).getCell(0).setText("零漂");
            mergeCellsVertically(infoTable, 0, 1, pwbhJlLpjys.size());
        }
        createRemark(document,returnString(beizhu.getPwbhJlLpjy()));
        return document;
    }

    /***
     * 电流、电压精度检验
     * @param document
     * @param pwbhJlJdjys
     * @return
     */
    public XWPFDocument createTableByJdjy(XWPFDocument document, List<PwbhJlJdjy> pwbhJlJdjys) {
        toParagraph(document);
        createTitle(document, "8、电流、电压精度检验");
        XWPFTable infoTable = createTable(document);
        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("测试结果");
        infoTableRowOne.addNewTableCell().setText("");
        infoTableRowOne.addNewTableCell().setText("通入要求值");
        infoTableRowOne.addNewTableCell().setText("装置显示");
        infoTableRowOne.addNewTableCell().setText("检查结果");

        mergeCellsHorizontal(infoTable,0,0,1);
        infoTable.getRow(0).getCell(0).getCTTc().addNewTcPr().addNewTcW()
                .setW(BigInteger.valueOf((9072 / 5) * (1 - 0 + 1)));

        setCellWidth(infoTableRowOne.getCell(0),90);
        setCellWidth(infoTableRowOne.getCell(1),90);
        setCellWidth(infoTableRowOne.getCell(2),90);
        setCellWidth(infoTableRowOne.getCell(3),90);
        setCellWidth(infoTableRowOne.getCell(4),90);

        setCellTextAlign(infoTableRowOne.getCell(0));
        setCellTextAlign(infoTableRowOne.getCell(1));
        setCellTextAlign(infoTableRowOne.getCell(2));
        setCellTextAlign(infoTableRowOne.getCell(3));
        setCellTextAlign(infoTableRowOne.getCell(4));

        for(PwbhJlJdjy pwbhJlJdjy:pwbhJlJdjys){
            XWPFTableRow infoTableRowTow = infoTable.createRow();
            infoTableRowTow.getCell(0).setText("");
            infoTableRowTow.getCell(1).setText(returnString(pwbhJlJdjy.getJcjg()));
            infoTableRowTow.getCell(2).setText(returnString(pwbhJlJdjy.getTryq()));
            infoTableRowTow.getCell(3).setText(returnString(pwbhJlJdjy.getZzxs()));
            infoTableRowTow.getCell(4).setText(switchJcjg("0",switchJcjg("0",returnString(pwbhJlJdjy.getJcjg()))));

            setCellWidth(infoTableRowTow.getCell(0),90);
            setCellWidth(infoTableRowTow.getCell(1),90);
            setCellWidth(infoTableRowTow.getCell(2),90);
            setCellWidth(infoTableRowTow.getCell(3),90);
            setCellWidth(infoTableRowTow.getCell(4),90);

            setCellTextAlign(infoTableRowTow.getCell(1));
            setCellTextAlign(infoTableRowTow.getCell(4));
        }
        if(pwbhJlJdjys!=null && pwbhJlJdjys.size()>1){
            List<XWPFTableRow> rows = infoTable.getRows();
            infoTable.getRow(1).getCell(0).setText("精度");
            mergeCellsVertically(infoTable,0,1,pwbhJlJdjys.size());
        }
        createRemark(document,returnString(beizhu.getPwbhJlJdjy()));
        return document;
    }

    /***
     *保护CT参数、变比试验
     * @param document
     * @return
     */
    public XWPFDocument createTableByBhctjx(XWPFDocument document, List<PwbhJlBhctjx> pwbhJlBhctjxs) {
        toParagraph(document);
        createTitle(document,"9、保护CT参数、变比试验");
        createTitle(document,"9.1 保护CT极性");
        XWPFTable infoTable = createTable(document);
        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("相别");
        infoTableRowOne.addNewTableCell().setText("一次以母线为正");
        infoTableRowOne.addNewTableCell().setText("二次以母线为正");
        infoTableRowOne.addNewTableCell().setText("表计指示");
        setCellTextAlign(infoTableRowOne.getCell(0));
        setCellTextAlign(infoTableRowOne.getCell(1));
        setCellTextAlign(infoTableRowOne.getCell(2));
        setCellTextAlign(infoTableRowOne.getCell(3));

        for(PwbhJlBhctjx pwbhJlBhctjx:pwbhJlBhctjxs){
            XWPFTableRow infoTableRowTow = infoTable.createRow();
            infoTableRowTow.getCell(0).setText(returnString(pwbhJlBhctjx.getXb()));
            infoTableRowTow.getCell(1).setText(returnString(pwbhJlBhctjx.getMx1()));
            infoTableRowTow.getCell(2).setText(returnString(pwbhJlBhctjx.getMx2()));
            infoTableRowTow.getCell(3).setText(returnString(pwbhJlBhctjx.getBjzs()));
            setCellTextAlign(infoTableRowTow.getCell(0));
        }
        createRemark(document,returnString(beizhu.getPwbhJlBhctjx()));
        return document;
    }

    /***
     * 保护CT变比
     * @param document
     * @return
     */
    public XWPFDocument createTableByCtbh(XWPFDocument document, List<PwbhJlBhctbh> pwbhJlBhctbhs) {
        toParagraph(document);
        createTitle(document,"9.2 保护CT变比");
        XWPFTable infoTable = createTable(document);
        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("相别");
        infoTableRowOne.addNewTableCell().setText("型号");
        infoTableRowOne.addNewTableCell().setText("线圈号");
        infoTableRowOne.addNewTableCell().setText("参数");
        infoTableRowOne.addNewTableCell().setText("名义变比");
        infoTableRowOne.addNewTableCell().setText("试验变比");
        setCellTextAlign(infoTableRowOne.getCell(0));
        setCellTextAlign(infoTableRowOne.getCell(1));
        setCellTextAlign(infoTableRowOne.getCell(2));
        setCellTextAlign(infoTableRowOne.getCell(3));
        setCellTextAlign(infoTableRowOne.getCell(4));
        setCellTextAlign(infoTableRowOne.getCell(5));

        for(PwbhJlBhctbh pwbhJlBhctbh:pwbhJlBhctbhs){
            XWPFTableRow infoTableRowTow = infoTable.createRow();
            infoTableRowTow.getCell(0).setText(returnString(pwbhJlBhctbh.getXb()));
            infoTableRowTow.getCell(1).setText(returnString(pwbhJlBhctbh.getXh()));
            infoTableRowTow.getCell(2).setText(returnString(pwbhJlBhctbh.getXqh()));
            infoTableRowTow.getCell(3).setText(returnString(pwbhJlBhctbh.getCs()));
            infoTableRowTow.getCell(4).setText(returnString(pwbhJlBhctbh.getMybh()));
            infoTableRowTow.getCell(5).setText(returnString(pwbhJlBhctbh.getSybh()));
            setCellTextAlign(infoTableRowTow.getCell(0));
        }
        createRemark(document,returnString(beizhu.getPwbhJlBhctbh()));
        return document;
    }

    /***
     * 定值检查
     * @param document
     * @param pwbhJlDzjcs
     * @return
     */
    public XWPFDocument createTableByDzjc(XWPFDocument document, List<PwbhJlDzjc> pwbhJlDzjcs, PwbhDz pwbhDz) {
        if(pwbhDz == null) return document;
        toParagraph(document);
        createTitle(document,"10、定值检查：");
        toParagraph(document);
        createTitle(document,"（1）过流Ⅰ段定值_____"+returnString(pwbhDz.getG1())+"_____,  过流Ⅱ段定值_____"+returnString(pwbhDz.getG2())+"_____。");
        XWPFTable infoTable = createTable(document);
        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("");
        infoTableRowOne.addNewTableCell().setText("过流Ⅰ段整定值");
        infoTableRowOne.addNewTableCell().setText("实际通电0.95倍定值／1.05倍定值");
        infoTableRowOne.addNewTableCell().setText("过流Ⅱ段整定值");
        infoTableRowOne.addNewTableCell().setText("实际通电0.95倍定值／1.05倍定值");
        setCellWidth(infoTableRowOne.getCell(0),90);

        for(PwbhJlDzjc pwbhJlDzjc:pwbhJlDzjcs){
            XWPFTableRow infoTableRowTow = infoTable.createRow();
            infoTableRowTow.getCell(0).setText(returnString(pwbhJlDzjc.getJg()));
            infoTableRowTow.getCell(1).setText(returnString(pwbhJlDzjc.getG1()));
            infoTableRowTow.getCell(2).setText("____"+returnString(pwbhJlDzjc.getG11())+"____A 不动作；"
                    +"\n____"+returnString(pwbhJlDzjc.getG12())+"____A 动作。");
            infoTableRowTow.getCell(3).setText(returnString(pwbhJlDzjc.getG2()));
            infoTableRowTow.getCell(4).setText("____"+returnString(pwbhJlDzjc.getG21())+"____A 不动作；"
                    +"\n____"+returnString(pwbhJlDzjc.getG22())+"____A 动作。");
            setCellWidth(infoTableRowTow.getCell(0),90);
        }
        toParagraph(document);
        createTitle(document,"过流Ⅰ段时间：___"+returnString(pwbhDz.getG11())+"___秒,通电___"+returnString(pwbhDz.getG12())
                +"___秒, 过流Ⅱ段时间___"+returnString(pwbhDz.getG21())
                +"___秒，通电___"+pwbhDz.getG22()+"___秒.");
        createTitle(document,"（2）零序过流Ⅰ段定值___"+returnString(pwbhDz.getL1())+"___, 零序过流Ⅱ段定值___"+returnString(pwbhDz.getL2())+"___。");
        toParagraph(document);
        XWPFTable infoTable2 = createTable(document);
        //表格第一行
        XWPFTableRow infoTableRowOne2 = infoTable2.getRow(0);
        infoTableRowOne2.getCell(0).setText("零序Ⅰ段整定值");
        infoTableRowOne2.addNewTableCell().setText("实际通电0.95倍定值／1.05倍定值");
        infoTableRowOne2.addNewTableCell().setText("零序Ⅱ段整定值");
        infoTableRowOne2.addNewTableCell().setText("实际通电0.95倍定值／1.05倍定值");

        XWPFTableRow infoTableRowTow2 = infoTable2.createRow();
        infoTableRowTow2.getCell(0).setText(returnString(pwbhDz.getL1()));
        infoTableRowTow2.getCell(1).setText("____"+returnString(pwbhDz.getG11())+"____A 不动作；"
                +"\n____"+returnString(pwbhDz.getG12())+"____A 动作。");
        infoTableRowTow2.getCell(2).setText(returnString(pwbhDz.getL2()));
        infoTableRowTow2.getCell(3).setText("____"+returnString(pwbhDz.getG21())+"____A 不动作；"
                +"\n____"+returnString(pwbhDz.getG22())+"____A 动作。");

        toParagraph(document);
        createTitle(document,"零序Ⅰ段时间：____"+returnString(pwbhDz.getL11())+"____秒，通电____"+returnString(pwbhDz.getL12())+"____秒,  零序Ⅱ段时间：____"
                +returnString(pwbhDz.getL21())+"____秒，通电____"+returnString(pwbhDz.getL22())+"____秒.");

        createRemark(document,returnString(beizhu.getPwbhJlDzjc()));
        return document;
    }

    /***
     *  整组试验及实际断路器传动
     * @param document
     * @return
     */
    public XWPFDocument createTableByZzsy(XWPFDocument document,List<PwbhJlZzsy> pwbhJlZzsys) {
        toParagraph(document);
        createTitle(document,"11、整组试验及实际断路器传动");
        createTitle(document,"此项试验前应将本次可以传动的断路器合入，上好出口跳闸压板 ");
        XWPFTable infoTable = createTable(document);
        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("检验项目");
        infoTableRowOne.addNewTableCell().setText("故障模拟");
        infoTableRowOne.addNewTableCell().setText("断路器（或启动信号）");
        infoTableRowOne.addNewTableCell().setText("断路器动作情况（或信号动作情况）");
        infoTableRowOne.addNewTableCell().setText("");
        infoTableRowOne.addNewTableCell().setText("检查结果（正确打√）");

        mergeCellsHorizontal(infoTable,0,3,4);
        infoTable.getRow(0).getCell(3).getCTTc().addNewTcPr().addNewTcW()
                .setW(BigInteger.valueOf((9072 / 6) * (4 - 3 + 1)));

        setCellTextAlign(infoTableRowOne.getCell(0));
        setCellTextAlign(infoTableRowOne.getCell(1));
        setCellTextAlign(infoTableRowOne.getCell(2));
        setCellTextAlign(infoTableRowOne.getCell(3));
        setCellTextAlign(infoTableRowOne.getCell(4));
        setCellTextAlign(infoTableRowOne.getCell(5));

        XWPFTableRow infoTableRowTow = infoTable.createRow();
        infoTableRowTow.getCell(0).setText("");
        infoTableRowTow.getCell(1).setText("");
        infoTableRowTow.getCell(2).setText("");
        infoTableRowTow.getCell(3).setText("主站信号");
        infoTableRowTow.getCell(4).setText("装置显示");
        setCellTextAlign(infoTableRowTow.getCell(3));
        setCellTextAlign(infoTableRowTow.getCell(4));
        infoTableRowTow.getCell(5).setText("");

        mergeCellsVertically(infoTable,0,0,1);
        mergeCellsVertically(infoTable,1,0,1);
        mergeCellsVertically(infoTable,2,0,1);
        mergeCellsVertically(infoTable,5,0,1);



        for(PwbhJlZzsy pwbhJlZzsy:pwbhJlZzsys){
            XWPFTableRow infoTableRowLast = infoTable.createRow();
            infoTableRowLast.getCell(0).setText(returnString(pwbhJlZzsy.getJyxm()));
            infoTableRowLast.getCell(1).setText(returnString(pwbhJlZzsy.getGzmn()));
            infoTableRowLast.getCell(2).setText(returnString(pwbhJlZzsy.getDlq()));
            infoTableRowLast.getCell(3).setText(returnString(pwbhJlZzsy.getZzxh()));
            infoTableRowLast.getCell(4).setText(returnString(pwbhJlZzsy.getZzxs()));
            infoTableRowLast.getCell(5).setText(switchJcjg("1",returnString(pwbhJlZzsy.getJcjg())));
            setCellTextAlign(infoTableRowLast.getCell(5));
        }
        createRemark(document,returnString(beizhu.getPwbhJlZzsy()));
        return document;
    }

    /***
     *   保护CT回路接触电阻
     * @param document
     * @return
     */
    public XWPFDocument createTableByBhcthl(XWPFDocument document,List<PwbhJlBhcthl> pwbhJlBhcthls) {
        toParagraph(document);
        createTitle(document,"12、保护CT回路接触电阻：（误差不得超过10％）");
        XWPFTable infoTable = createTable(document);
        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("用途：保护");
        infoTableRowOne.addNewTableCell().setText("");
        infoTableRowOne.addNewTableCell().setText("");
        mergeCellsHorizontal(infoTable,0,0,2);

        XWPFTableRow infoTableRowTow = infoTable.createRow();
        infoTableRowTow.getCell(0).setText("相别");
        infoTableRowTow.getCell(1).setText("保护侧");
        infoTableRowTow.getCell(2).setText("CT侧");
        setCellTextAlign(infoTableRowTow.getCell(0));
        setCellTextAlign(infoTableRowTow.getCell(1));
        setCellTextAlign(infoTableRowTow.getCell(2));

        for(PwbhJlBhcthl pwbhJlBhcthl:pwbhJlBhcthls){
            XWPFTableRow infoTableRowLast = infoTable.createRow();
            infoTableRowLast.getCell(0).setText(returnString(pwbhJlBhcthl.getXb()));
            infoTableRowLast.getCell(1).setText(returnString(pwbhJlBhcthl.getBhc()));
            infoTableRowLast.getCell(2).setText(returnString(pwbhJlBhcthl.getCtc()));
            setCellTextAlign(infoTableRowLast.getCell(0));
        }
        createRemark(document,returnString(beizhu.getPwbhJlBhcthl()));
        return document;
    }

    /***
     *  收工前需检查的项目
     * @param document
     * @return
     */
    public XWPFDocument createTableBySgjc(XWPFDocument document,List<PwbhJlSgjc> pwbhJlSgjcs) {
        toParagraph(document);
        createTitle(document,"13、 收工前需检查的项目");
        XWPFTable infoTable = createTable(document);
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("检查内容");
        infoTableRowOne.addNewTableCell().setText("结果");
        setCellTextAlign(infoTableRowOne.getCell(0));
        setCellTextAlign(infoTableRowOne.getCell(1));

        for(PwbhJlSgjc pwbhJlSgjc:pwbhJlSgjcs){
            XWPFTableRow infoTableRowTow = infoTable.createRow();
            infoTableRowTow.getCell(0).setText(returnString(pwbhJlSgjc.getNr()));
            infoTableRowTow.getCell(1).setText(switchJcjg("0",returnString(pwbhJlSgjc.getJcjg())));
            setCellTextAlign(infoTableRowTow.getCell(1));
        }
        createRemark(document,returnString(beizhu.getPwbhJlSgjc()));
        toParagraph(document);
        createTitle(document,"14、检验结论：（填写发现问题及处理情况、遗留问题，可否投运等）");
        return document;
    }




    public void createRemark(XWPFDocument document,String remark){
        XWPFParagraph firstParagraph = document.createParagraph();
        XWPFRun run = firstParagraph.createRun();
        run.setText("备注："+ (remark==null?"":remark));
        run.setBold(false);
        run.setFontSize(8);
        XWPFRun runBr = firstParagraph.createRun();
    }
    /***
     * 创建标题
     * @param document
     * @param title
     * @return
     */
    public void createTitle(XWPFDocument document,String title){
        XWPFParagraph firstParagraph = document.createParagraph();
        XWPFRun run = firstParagraph.createRun();
        run.setText(title);
        run.setBold(false);
        run.setFontSize(10);
    }
    /***
     * 创建表格
     * @param document
     * @return
     */
    public XWPFTable createTable(XWPFDocument document){
        XWPFTable infoTable = document.createTable();
        //去表格边框
        // infoTable.getCTTbl().getTblPr().unsetTblBorders();

        //列宽自动分割
        CTTblWidth infoTableWidth = infoTable.getCTTbl().addNewTblPr().addNewTblW();
        infoTableWidth.setType(STTblWidth.DXA);
        infoTableWidth.setW(BigInteger.valueOf(9072));

        return infoTable;
    }
    /***
     * 当前文档换行
     * @param document
     */
    public void toParagraph(XWPFDocument document){
        XWPFParagraph paragraph1 = document.createParagraph();
        XWPFRun paragraphRun1 = paragraph1.createRun();
        paragraphRun1.setText("\r");
    }
    /***
     * 跨列合并单元格
     * @param table
     * @param row
     * @param fromCell
     * @param toCell
     */
    public   static void mergeCellsHorizontal(XWPFTable table, int row, int fromCell, int toCell) {
        for (int cellIndex = fromCell; cellIndex <= toCell; cellIndex++) {
            XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
            if ( cellIndex == fromCell ) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
                //cell.getCTTc().addNewMoveFrom().addNewBar().setBarPr(CTBarPr.EQUAL);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    /***
     * word跨行并单元格
     * @param table
     * @param col
     * @param fromRow
     * @param toRow
     */
    public void mergeCellsVertically(XWPFTable table, int col, int fromRow, int toRow) {
        for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
            XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
            if ( rowIndex == fromRow ) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    /***
     * 设置单元格宽度
     * @param cell
     */
    public void setCellWidth(XWPFTableCell cell,int w) {
        CTTcPr tcpr = cell.getCTTc().addNewTcPr();
        CTTblWidth cellw = tcpr.addNewTcW();
        cellw.setType(STTblWidth.DXA);
        cellw.setW(BigInteger.valueOf(w * 5));
    }

    /***
     * 设置单元格内容居中
     * @param cell
     */
    public void setCellTextAlign(XWPFTableCell cell) {
        CTTc cttc = cell.getCTTc();
        CTTcPr ctPr = cttc.addNewTcPr();
        ctPr.addNewVAlign().setVal(STVerticalJc.CENTER);
        cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
    }
    /***
     * 设置单元格内容靠右
     * @param cell
     */
    public void setCellTextRight(XWPFTableCell cell) {
        CTTc cttc = cell.getCTTc();
        CTTcPr ctPr = cttc.addNewTcPr();
        ctPr.addNewVAlign().setVal(STVerticalJc.CENTER);
        cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.RIGHT);
    }


    public String returnString(Object obj){
        if(obj==null){
            return "";
        }
        return obj.toString();
    }

    public String switchJcjg(String type,String jcjg){
        if(type.equals("0")){
            switch (jcjg){
                case "-1":
                    jcjg = "";
                    break;
                case "1":
                    jcjg = "是";
                    break;
                case "0":
                    jcjg = "否";
                    break;
                case "2":
                    jcjg = "N/A";
                    break;

            }
        }else if(type.equals("1")){
            switch (jcjg){
                case "-1":
                    jcjg = "";
                    break;
                case "1":
                    jcjg = "正确";
                    break;
                case "0":
                    jcjg = "错误";
                    break;
                case "2":
                    jcjg = "N/A";
                    break;
            }
        }else if(type.equals("2")){
            switch (jcjg){
                case "-1":
                    jcjg = "";
                    break;
                case "1":
                    jcjg = "正常";
                    break;
                case "0":
                    jcjg = "超标";
                    break;
                case "2":
                    jcjg = "N/A";
                    break;
            }
        }
        return jcjg;
    }

}