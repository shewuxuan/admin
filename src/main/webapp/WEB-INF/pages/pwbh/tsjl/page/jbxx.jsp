<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/6/16
  Time: 2:56 下午
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
                <th style="text-align: center">所属线路</th>
                <th id="jbxx_ssxl" style="text-align: center"></th>
                <td style="text-align: center">路名</td>
                <td id="jbxx_lm" style="text-align: center"></td>
            </tr>
            <tr>
                <td style="text-align: center">工作负责人</td>
                <td id="jbxx_gzfzr" style="text-align: center"></td>
                <td style="text-align: center">工作人员</td>
                <td id="jbxx_gzry" style="text-align: center"></td>
            </tr>
            <tr>
                <td style="text-align: center">审核人</td>
                <td id="jbxx_shr" colspan="3" style="text-align: center"></td>
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
        $.get("${basePath}/pwbhJbxx/selectByPrimaryKey/" + tsid, function (data) {
            let jbxx = $.parseJSON(data);
            $("#jbxx_tssj").text(jbxx.tssj);
            $("#jbxx_azdd_ddh").text(jbxx.azddDdh);
            $("#jbxx_ssxl").text(jbxx.bdz + '-' + jbxx.xlmc);
            $("#jbxx_lm").text(jbxx.lm);
            $("#jbxx_gzfzr").text(jbxx.gzfzr);
            $("#jbxx_gzry").text(jbxx.gzry);
            $("#jbxx_shr").text(jbxx.shr);
            ssqy = jbxx.ssqy;
        });
        $.ajaxSettings.async = true;            // 取消同步， ajax改成异步

        // 查询备注信息
        $.get("${basePath}/pwbh_beizhu/selectByPrimaryKey/" + tsid, function (data) {
            data = $.parseJSON(data);
            $("#bhctbhbeizhu").val(data.pwbhJlBhctbh);
            $("#bhcthlbeizhu").val(data.pwbhJlBhcthl);
            $("#bhctjxbeizhu").val(data.pwbhJlBhctjx);
            $("#dzdjcbeizhu").val(data.pwbhJlDzdjc);
            $("#dzjcbeizhu").val(data.pwbhJlDzjc);
            $("#jdjybeizhu").val(data.pwbhJlJdjy);
            $("#jdszbeizhu").val(data.pwbhJlJdsz);
            $("#jxdxbeizhu").val(data.pwbhJlJxdx);
            $("#jycsbeizhu").val(data.pwbhJlJycs);
            $("#lpjybeizhu").val(data.pwbhJlLpjy);
            $("#sgjcbeizhu").val(data.pwbhJlSgjc);
            $("#wgjcbeizhu").val(data.pwbhJlWgjc);
            $("#yqybbeizhu").val(data.pwbhJlYqyb);
            $("#zzsybeizhu").val(data.pwbhJlZzsy);
        });

        <%--$.get("${basePath}/pwbh_dz/selectByPrimaryKey/" + tsid, function (data) {--%>
        <%--    data = $.parseJSON(data).data;--%>
        <%--    console.log(data);--%>
        <%--    $("#l1").val(data.l1);--%>
        <%--    $("#l11").val(data.l11);--%>
        <%--    $("#l12").val(data.l12);--%>
        <%--    $("#l2").val(data.l2);--%>
        <%--    $("#l21").val(data.l21);--%>
        <%--    $("#l22").val(data.l22);--%>
        <%--    $("#g1").val(data.g1);--%>
        <%--    $("#g11").val(data.g11);--%>
        <%--    $("#g12").val(data.g12);--%>
        <%--    $("#g2").val(data.g2);--%>
        <%--    $("#g21").val(data.g21);--%>
        <%--    $("#g22").val(data.g22);--%>
        <%--});--%>

        // 查询告警定值
        <%--$.get("${basePath}/gjdz/selectByPrimaryKey/" + tsid, function (data) {--%>
        <%--    let gjdz = $.parseJSON(data);--%>
        <%--    // 告警功能--%>
        <%--    $("#glgj1").val(gjdz.glgj1);--%>
        <%--    $("#glgj2").val(gjdz.glgj2);--%>
        <%--    $("#glgj3").val(gjdz.glgj3);--%>
        <%--    $("#glcs1").val(gjdz.glcs1);--%>
        <%--    $("#glcs2").val(gjdz.glcs2);--%>
        <%--    $("#lxgj1").val(gjdz.lxgj1);--%>
        <%--    $("#lxgj2").val(gjdz.lxgj2);--%>
        <%--    $("#lxgj3").val(gjdz.lxgj3);--%>
        <%--    $("#lxcs1").val(gjdz.lxcs1);--%>
        <%--    $("#lxcs2").val(gjdz.lxcs2);--%>
        <%--    // 开关柜告警--%>
        <%--    $("#qygj1").val(gjdz.qygj1);--%>
        <%--    $("#qygj2").val(gjdz.qygj2);--%>
        <%--});--%>
    });
</script>
</body>
</html>
