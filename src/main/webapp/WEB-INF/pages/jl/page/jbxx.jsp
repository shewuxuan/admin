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
    <legend id="mao1">1、基本信息</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table class="layui-table" style="width: 90%; margin: auto;">
            <colgroup>
                <col width="25%">
                <col width="25%">
                <col width="25%">
                <col width="25%">
            </colgroup>
            <tbody>
            <tr>
                <th style="text-align: center">调试时间</th>
                <th id="jbxx_tssj" style="text-align: center"></th>
                <th style="text-align: center">安装地点及调度号</th>
                <th id="jbxx_azdd_ddh" style="text-align: center"></th>
            </tr>
            <tr>
                <th style="text-align: center">终端名称</th>
                <th id="jbxx_zdmc" style="text-align: center"></th>
                <th style="text-align: center">所属线路</th>
                <th id="jbxx_ssxl" style="text-align: center"></th>
            </tr>
            <tr>
                <td style="text-align: center">通信模块厂家</td>
                <td id="jbxx_txmkcj" style="text-align: center"></td>
                <td style="text-align: center">IP地址</td>
                <td id="jbxx_ipdz" style="text-align: center"></td>
            </tr>
            <tr>
                <td style="text-align: center">物联网卡号</td>
                <td id="jbxx_wlwkh" style="text-align: center"></td>
                <td style="text-align: center">RTU地址</td>
                <td id="jbxx_rtudz" style="text-align: center"></td>
            </tr>
            <tr>
                <td style="text-align: center">端口号</td>
                <td id="jbxx_dkh" style="text-align: center"></td>
                <td style="text-align: center">DTU生产厂商</td>
                <td id="jbxx_sccs" style="text-align: center"></td>
            </tr>
            <tr>
                <td style="text-align: center">生产日期</td>
                <td id="jbxx_scrq" style="text-align: center"></td>
                <td style="text-align: center">装置型号</td>
                <td id="jbxx_zzxh" style="text-align: center"></td>
            </tr>
            <tr>
                <td style="text-align: center">装置编号</td>
                <td id="jbxx_zzbh" style="text-align: center"></td>
                <td style="text-align: center">软件版本及校验码</td>
                <td id="jbxx_rjbb_jym" style="text-align: center"></td>
            </tr>
            <tr>
                <td style="text-align: center">硬件版本</td>
                <td id="jbxx_yjbb" style="text-align: center"></td>
                <td style="text-align: center">DTU调试人员姓名</td>
                <td id="jbxx_sccs_ycg" style="text-align: center"></td>
            </tr>
            <tr>
                <td style="text-align: center">一次柜装置型号</td>
                <td id="jbxx_zbxh_ycg" style="text-align: center"></td>
                <td style="text-align: center">一次柜生产厂商</td>
                <td id="jbxx_tsryxm" style="text-align: center"></td>
            </tr>
            <tr>
                <td style="text-align: center">一次柜调试人员姓名</td>
                <td id="jbxx_tsryxm_ycg" colspan="3"></td>
            </tr>
            <tr>
                <td style="text-align: center">溢水生产厂商</td>
                <td id="jbxx_sccs_ys" style="text-align: center"></td>
                <td style="text-align: center">溢水柜装置型号</td>
                <td id="jbxx_zbxh_ys" style="text-align: center"></td>
            </tr>
            <tr>
                <td style="text-align: center">溢水柜调试人员姓名</td>
                <td id="jbxx_tsryxm_ys" colspan="3"></td>
            </tr>
            <tr>
                <td style="text-align: center">消防生产厂商</td>
                <td id="jbxx_sccs_xf" style="text-align: center"></td>
                <td style="text-align: center">消防装置型号</td>
                <td id="jbxx_zbxh_xf" style="text-align: center"></td>
            </tr>
            <tr>
                <td style="text-align: center">消防调试人员姓名</td>
                <td id="jbxx_tsryxm_xf" colspan="3"></td>
            </tr>
            <tr>
                <td style="text-align: center">经度</td>
                <td id="jbxx_jd" style="text-align: center"></td>
                <td style="text-align: center">纬度</td>
                <td id="jbxx_wd" style="text-align: center"></td>
            </tr>
            <tr>
                <td style="text-align: center">详细位置</td>
                <td id="jbxx_xxwz" colspan="3"></td>
            </tr>
<%--            <tr>--%>
<%--                <td style="text-align: center">调试人员姓名</td>--%>
<%--                <td id="jbxx_tsryxm" colspan="3"></td>--%>
<%--            </tr>--%>
            </tbody>
        </table>
    </blockquote>
</div>

<%-- 1、基本信息 --%>
<script>
    $(function () {
        $.ajaxSettings.async = false;           // 为了将页面加载完， 设置ajax为同步（给ssqy赋值）
        $.get("${basePath}/jbxx/selectByPrimaryKey/" + tsid, function (data) {
            let jbxx = $.parseJSON(data);
            $("#jbxx_tssj").text(timestampToTime(jbxx.tssj));
            $("#jbxx_ipdz").text(jbxx.ipdz);
            $("#jbxx_rtudz").text(jbxx.rtudz);
            $("#jbxx_sccs").text(jbxx.sccs);
            $("#jbxx_zzxh").text(jbxx.zzxh);
            $("#jbxx_rjbb_jym").text(jbxx.rjbbJym);
            $("#jbxx_azdd_ddh").text(jbxx.azddDdh);
            $("#jbxx_wlwkh").text(jbxx.wlwkh);
            $("#jbxx_dkh").text(jbxx.dkh);
            $("#jbxx_scrq").text(timestampToTime(jbxx.scrq));
            $("#jbxx_zzbh").text(jbxx.zzbh);
            $("#jbxx_yjbb").text(jbxx.yjbb);
            $("#jbxx_tsryxm").text(jbxx.tsryxm);
            $("#jbxx_zdmc").text(jbxx.zdmc);
            $("#jbxx_ssxl").text(jbxx.ssxl);
            $("#jbxx_txmkcj").text(jbxx.txmkcj);
            $("#jbxx_sccs_ycg").text(jbxx.sccsYcg);
            $("#jbxx_zbxh_ycg").text(jbxx.zbxhYcg);
            $("#jbxx_tsryxm_ycg").text(jbxx.tsryxmYcg);
            $("#jbxx_sccs_ys").text(jbxx.sccsYs);
            $("#jbxx_zbxh_ys").text(jbxx.zbxhYs);
            $("#jbxx_tsryxm_ys").text(jbxx.tsryxmYs);
            $("#jbxx_sccs_xf").text(jbxx.sccsXf);
            $("#jbxx_zbxh_xf").text(jbxx.zbxhXf);
            $("#jbxx_tsryxm_xf").text(jbxx.tsryxmXf);
            $("#jbxx_jd").text(jbxx.jd);
            $("#jbxx_wd").text(jbxx.wd);
            $("#jbxx_xxwz").text(jbxx.xxwz);
            ssqy = jbxx.ssqy;
        });
        $.ajaxSettings.async = true;            // 取消同步， ajax改成异步

        // 查询备注信息
        $.get("${basePath}/beizhu/selectBeizhuByPrimaryKey/" + tsid, function (data) {
            let beizhu = $.parseJSON(data);
            $("#ctgybeizhu").val(beizhu.jlCtgy);
            $("#cyjdbeizhu").val(beizhu.jlCyjd);
            $("#dlhlbeizhu").val(beizhu.jlDlhl);
            $("#dtubeizhu").val(beizhu.jlDtu);
            $("#dyxnbeizhu").val(beizhu.jlDyxn);
            $("#gjcsbeizhu").val(beizhu.jlGjcs);
            $("#gncsbeizhu").val(beizhu.jlGncs);
            $("#hldzbeizhu").val(beizhu.jlHldz);
            $("#jydzbeizhu").val(beizhu.jlJydz);
            $("#kggbeizhu").val(beizhu.jlKgg);
            $("#lpjybeizhu").val(beizhu.jlLpjy);
            $("#wgpzbeizhu").val(beizhu.jlWgpz);
            $("#xbybeizhu").val(beizhu.jlXb);
            $("#yctsbeizhu").val(beizhu.jlYcts);
            $("#yktsbeizhu").val(beizhu.jlYkts);
            $("#ysbjbeizhu").val(beizhu.jlYsbj);
        });

        // 查询告警定值
        $.get("${basePath}/gjdz/selectByPrimaryKey/" + tsid, function (data) {
            let gjdz = $.parseJSON(data);
            $("#glgj1").val(gjdz.glgj1);
            $("#glgj2").val(gjdz.glgj2);
            $("#glgj3").val(gjdz.glgj3);
            $("#lxgj1").val(gjdz.lxgj1);
            $("#lxgj2").val(gjdz.lxgj2);
            $("#lxgj3").val(gjdz.lxgj3);
        });
    });

    //转化为时间格式
    function timestampToTime(timestamp) {
        var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = (date.getDate() < 10 ? '0'+(date.getDate()) : date.getDate()) + ' ';
        h = (date.getHours() < 10 ? '0'+(date.getHours()) : date.getHours()) + ':';
        m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) : date.getMinutes()) + ':';
        s = (date.getSeconds() < 10 ? '0'+(date.getSeconds()) : date.getSeconds());
        return Y+M+D+h+m+s;
    }
</script>
</body>
</html>
