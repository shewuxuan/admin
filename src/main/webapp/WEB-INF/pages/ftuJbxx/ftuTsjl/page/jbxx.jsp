<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 7:56 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend id="mao1">1、设备基本信息</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table class="layui-table" style="width: 100%; margin: auto;">
            <colgroup>
                <col width="16%">
                <col width="16%">
                <col width="16%">
                <col width="16%">
                <col width="16%">
                <col width="16%">
            </colgroup>
            <tbody>
            <tr>
                <th style="text-align: center">线路名称</th>
                <th id="jbxx_xlmc" style="text-align: center"></th>
                <th style="text-align: center">调度编号</th>
                <th id="jbxx_ddbh" style="text-align: center"></th>
                <th style="text-align: center">FTU编码</th>
                <th id="jbxx_ftu_bm" style="text-align: center"></th>
            </tr>
            <tr>
                <th style="text-align: center">验收人员</th>
                <th id="jbxx_ysry" style="text-align: center"></th>
                <th style="text-align: center">验收日期</th>
                <th id="jbxx_ysrq" style="text-align: center"></th>
                <th style="text-align: center">验收单位</th>
                <th id="jbxx_ysdw" style="text-align: center"></th>
            </tr>
            <tr>
                <th style="text-align: center" rowspan="8">设备台账</th>
                <th style="text-align: center" rowspan="3">开关本体</th>
                <th style="text-align: center">型号</th>
                <th id="jbxx_kg_xh" style="text-align: center"></th>
                <th style="text-align: center">生产日期</th>
                <th id="jbxx_kg_scrq" style="text-align: center"></th>
            </tr>
            <tr>
                <th style="text-align: center">厂家</th>
                <th id="jbxx_kg_cj" style="text-align: center" colspan="3"></th>
            </tr>
            <tr>
                <th style="text-align: center">相间CT变比</th>
                <th id="jbxx_kg_xjbb" style="text-align: center"></th>
                <th style="text-align: center">零序CT变比</th>
                <th id="jbxx_kg_lxbb" style="text-align: center"></th>
            </tr>
            <tr>
                <th style="text-align: center" rowspan="2">FTU</th>
                <th style="text-align: center">型号</th>
                <th id="jbxx_ftu_xh" style="text-align: center"></th>
                <th style="text-align: center">生产日期</th>
                <th id="jbxx_ftu_scrq" style="text-align: center"></th>
            </tr>
            <tr>
                <th style="text-align: center">厂家</th>
                <th id="jbxx_ftu_cj" style="text-align: center" colspan="3"></th>
            </tr>
            <tr>
                <th style="text-align: center" rowspan="2">通讯设备</th>
                <th style="text-align: center">型号</th>
                <th id="jbxx_txsb_xh" style="text-align: center"></th>
                <th style="text-align: center">生产日期</th>
                <th id="jbxx_txsb_scrq" style="text-align: center"></th>
            </tr>
            <tr>
                <th style="text-align: center">厂家</th>
                <th id="jbxx_txsb_cj" style="text-align: center" colspan="3"></th>
            </tr>
            <tr>
                <th style="text-align: center">无线卡号</th>
                <th id="jbxx_wxkh" style="text-align: center" colspan="2"></th>
                <th style="text-align: center">IP地址</th>
                <th id="jbxx_ipdz" style="text-align: center"></th>
            </tr>
            <tr>
                <th style="text-align: center">调试人员姓名</th>
                <th id="jbxx_tsryxm" style="text-align: center" colspan="5"></th>
            </tr>
            <tr>
                <th style="text-align: center">详细位置</th>
                <th id="jbxx_xxwz" style="text-align: center" colspan="5"></th>
            </tr>
            </tbody>
        </table>
    </blockquote>
</div>

<%-- 1、基本信息 --%>
<script>
    $(function () {
        $.ajaxSettings.async = false;           // 为了将页面加载完， 设置ajax为同步（给ssqy赋值）
        $.get("${basePath}/ftuJbxx/selectByPrimaryKey/" + tsid, function (data) {
            let jbxx = $.parseJSON(data);
            $("#jbxx_xlmc").text(jbxx.xlmc);
            $("#jbxx_tssj").text(jbxx.tssj);
            $("#jbxx_ddbh").text(jbxx.ddbh);
            $("#jbxx_ftu_bm").text(jbxx.ftuBm);
            $("#jbxx_ysry").text(jbxx.ysry);
            $("#jbxx_ysrq").text(jbxx.ysrq);
            $("#jbxx_ysdw").text(jbxx.ysdw);
            $("#jbxx_kg_cj").text(jbxx.kgCj);
            $("#jbxx_kg_xh").text(jbxx.kgXh);
            $("#jbxx_kg_scrq").text(jbxx.kgScrq);
            $("#jbxx_kg_xjbb").text(jbxx.kgXjbb);
            $("#jbxx_kg_lxbb").text(jbxx.kgLxbb);
            $("#jbxx_ftu_cj").text(jbxx.ftuCj);
            $("#jbxx_ftu_xh").text(jbxx.ftuXh);
            $("#jbxx_ftu_scrq").text(jbxx.ftuScrq);
            $("#jbxx_txsb_cj").text(jbxx.txsbCj);
            $("#jbxx_txsb_xh").text(jbxx.txsbXh);
            $("#jbxx_txsb_scrq").text(jbxx.txsbScrq);
            $("#jbxx_wxkh").text(jbxx.wxkh);
            $("#jbxx_ipdz").text(jbxx.ipdz);
            $("#jbxx_tsryxm").text(jbxx.tsryxm);
            $("#jbxx_xxwz").text(jbxx.xxwz);

            ssqy = jbxx.ssqy;
        });
        $.ajaxSettings.async = true;            // 取消同步， ajax改成异步

        <%--// 查询备注信息--%>
        $.get("${basePath}/beizhu/selectFtuBeizhuByPrimaryKey/" + tsid, function (data) {
            let beizhu = $.parseJSON(data);
            $("#kgdzbeizhu").val(beizhu.jlKgdz);
            $("#hbdybeizhu").val(beizhu.jlHbdy);
            $("#lpjybeizhu").val(beizhu.jlLpjy);
            $("#cyjdbeizhu").val(beizhu.jlCyjd);
            $("#gncsbeizhu").val(beizhu.jlGncs);
            $("#gjtsbeizhu").val(beizhu.jlGjts);
            $("#tzybbeizhu").val(beizhu.jlTzyb);
            $("#ykcdbeizhu").val(beizhu.jlYkcd);
            $("#cyjdcsbeizhu").val(beizhu.jlCyjdcs);
            $("#ykkgbeizhu").val(beizhu.jlYkkg);
            $("#tyjcbeizhu").val(beizhu.jlTyjc);
        });

        <%--// 查询告警定值--%>
        $.get("${basePath}/ftu_jl_gjdz/selectByPrimaryKey/" + tsid, function (data) {
            let gjdz = $.parseJSON(data);
            $("#gl1ddz").val(gjdz.gl1ddz);
            $("#gl1dsj").val(gjdz.gl1dsj);
            $("#gl1dtd").val(gjdz.gl1dtd);
            $("#gl2ddz").val(gjdz.gl2ddz);
            $("#gl2dsj").val(gjdz.gl2dsj);
            $("#gl2dtd").val(gjdz.gl2dtd);
            $("#lx1ddz").val(gjdz.lx1ddz);
            $("#lx1dsj").val(gjdz.lx1dsj);
            $("#lx1dtd").val(gjdz.lx1dtd);
            $("#lx2ddz").val(gjdz.lx2ddz);
            $("#lx2dsj").val(gjdz.lx2dsj);
            $("#lx2dtd").val(gjdz.lx2dtd);
        });
    });
</script>
</body>
</html>
