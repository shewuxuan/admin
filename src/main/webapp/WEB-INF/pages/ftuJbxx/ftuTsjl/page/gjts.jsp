<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:51 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .layui-table-cell {
            height: auto !important;
        }
    </style>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend id="mao7">7、跳闸、告警功能调试（通入二次值）</legend>
</fieldset>
<div class="layui-field-box" style="padding-left: 0px;">
    <blockquote class="layui-elem-quote" style="width: 98%; margin: auto;">
        <%-- 告警定值--%>
        <%@include file="gjdz.jsp" %>
        <table id="gjts" lay-filter="gjts"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="gjtsbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
        <%-- 跳闸压板--%>
        <%@include file="tzyb.jsp" %>
    </blockquote>
</div>

<%-- 导航背景--%>
<script>
    let gjts = false;
    let tzyb = false;
    function gjtsflag(gjts,tzyb) {
        if (gjts && tzyb) {
            $("#li_gjts").css({"background-color": "#009688"});
            return;
        }
        $("#li_gjts").css({"background-color": ""});
    }
</script>

<%-- 表格 --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let record = [];
        let tableReload = table.render({
            elem: '#gjts'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , size: 'sm'
            , even: false //开启隔行背景
            , url: '${basePath}/ftu_jl_gjts/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[
                {field: 'csx', title: '测试项', width: '14%', rowspan: 2, align: 'center'}
                , {field: 'g1dz', title: '过流<br>Ⅰ段<br>整定值', width: '8%', rowspan: 2, align: 'center'}
                , {title: '实际通电<br>0.95倍定值<br>/1.05倍定值', align: 'center', colspan: 2}
                , {field: 'g2dz', title: '过流<br>ⅠⅠ段<br>整定值', width: '8%', rowspan: 2, align: 'center'}
                , {title: '实际通电<br>0.95倍定值<br>/1.05倍定值', align: 'center', colspan: 2}
                , {field: 'lx1dz', title: '零序<br>Ⅰ段<br>整定值', width: '8%', rowspan: 2, align: 'center'}
                , {title: '实际通电<br>0.95倍定值<br>/1.05倍定值', align: 'center', colspan: 2}
                , {field: 'lx2dz', title: '零序<br>ⅠⅠ段<br>整定值', width: '8%', rowspan: 2, align: 'center'}
                , {title: '实际通电<br>0.95倍定值<br>/1.05倍定值', align: 'center', colspan: 2}
            ]

                , [
                    {field: 'g1sjtd1', title: '不动作', width: '7%', align: 'center'}
                    , {field: 'g1sjtd2', title: '动作', width: '7%', align: 'center'}
                    , {field: 'g2sjtd1', title: '不动作', width: '7%', align: 'center'}
                    , {field: 'g2sjtd2', title: '动作', width: '7%', align: 'center'}
                    , {field: 'lx1sjtd1', title: '不动作', width: '7%', align: 'center'}
                    , {field: 'lx1sjtd2', title: '动作', width: '7%', align: 'center'}
                    , {field: 'lx2sjtd1', title: '不动作', width: '7%', align: 'center'}
                    , {field: 'lx2sjtd2', title: '动作', width: '7%', align: 'center'}
                ]
            ]
            , done: function (res, curr, count) {
                let resdata = res.data;
                record = resdata;
                for (let i = 0, length = resdata.length; i < length; i++) {
                    if (
                        resdata[i].g1dz == null || resdata[i].g1dz === ""
                        || resdata[i].g1sjtd1 == null || resdata[i].g1sjtd1 === ""
                        || resdata[i].g1sjtd2 == null || resdata[i].g1sjtd2 === ""
                        || resdata[i].g2dz == null || resdata[i].g2dz === ""
                        || resdata[i].g2sjtd1 == null || resdata[i].g2sjtd1 === ""
                        || resdata[i].g2sjtd2 == null || resdata[i].g2sjtd2 === ""
                        || resdata[i].lx1dz == null || resdata[i].lx1dz === ""
                        || resdata[i].lx1sjtd1 == null || resdata[i].lx1sjtd1 === ""
                        || resdata[i].lx1sjtd2 == null || resdata[i].lx1sjtd2 === ""
                        || resdata[i].lx2dz == null || resdata[i].lx2dz === ""
                        || resdata[i].lx2sjtd1 == null || resdata[i].lx2sjtd1 === ""
                        || resdata[i].lx2sjtd2 == null || resdata[i].lx2sjtd2 === ""
                    ) {
                        gjts = false;
                        gjtsflag(gjts, tzyb);
                        return;
                    }
                    gjts = true;
                    gjtsflag(gjts, tzyb);
                }
            }
        });
    });
</script>
</body>
</html>
