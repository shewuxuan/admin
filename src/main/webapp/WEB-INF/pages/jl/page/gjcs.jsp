<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 11:00 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend id="mao13">13、告警功能调试</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <h4>测量步骤：</h4>
        <h4>（1）在DTU设置过流和零序告警定值。</h4>
        <h4>（2）在保护装置设置过流和零序定值，并投入跳闸功能。</h4>
        <h4>
            （3）分别在测量CT、保护CT和零序CT端子上加电流，记录主站收到的一次电流值。记录是否收到过流告警、零序告警、过流保护动作出口告警、零序保护动作出口告警，要求出现以上告警时必须伴随线路总告警。</h4>
        <h4>过流告警定值：二次<input id="glgj1" readonly type="text"/> A <input id="glgj2" readonly type="text"/>ms； CT变比：<input id="glgj3" readonly type="text"/></h4>
        <h4>过流告警测试值：二次<input id="glcs1" readonly type="text"/> A <input id="glcs2" readonly type="text"/>ms；</h4>
        <h4>零序告警定值：二次<input id="lxgj1" readonly type="text"/> A <input id="lxgj2" readonly type="text"/>ms； CT变比：<input id="lxgj3" readonly type="text"/></h4>
        <h4>零序告警测试值：二次<input id="lxcs1" readonly type="text"/> A <input id="lxcs2" readonly type="text"/>ms；</h4>
        <table id="gjcs1" lay-filter="gjcs1"></table>
        <table id="gjcs2" lay-filter="gjcs2"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="gjcsbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<script>
    $(function () {
        $.get("${basePath}/gjdz/selectByPrimaryKey/" + tsid, function (data) {
            let gjdz = $.parseJSON(data);
            $("#glgj1").val(gjdz.glgj1);
            $("#glgj2").val(gjdz.glgj2);
            $("#glgj3").val(gjdz.glgj3);
            $("#glcs1").val(gjdz.glcs1);
            $("#glcs2").val(gjdz.glcs2);
            $("#lxgj1").val(gjdz.lxgj1);
            $("#lxgj2").val(gjdz.lxgj2);
            $("#lxgj3").val(gjdz.lxgj3);
            $("#lxcs1").val(gjdz.lxcs1);
            $("#lxcs2").val(gjdz.lxcs2);
        });
    })
</script>
<%-- 13、告警功能调试1 --%>
<script>
    <%--  判断两个表格是否都有值  --%>
    let gjcs1 = false;
    let gjcs2 = false;

    function gjcsflag(gjcs1, gjcs2) {
        if (gjcs1 && gjcs2) {
            $("#li_gjcs").css({"background-color": "#009688"});
            return;
        }
        $("#li_gjcs").css({"background-color": ""});
    }

    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#gjcs1'                           // 改
            , title: '绝缘电阻测试'
            , page: false
            , skin: 'row，line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jlgjcs/selectByAll?tsid=' + tsid + "&gjlx=过流" //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', rowspan: 2, sort: true}
                , {field: 'jg', title: '间隔', width: '9%', align: 'center', rowspan: 2, sort: true}
                , {field: 'gjlx', title: '告警类型', width: '16%', rowspan: 2, align: 'center', sort: true}
                , {title: 'A相', align: 'center', colspan: 2}
                , {title: 'B相', align: 'center', colspan: 2}
                , {title: 'C相', align: 'center', colspan: 2}
                , {
                    field: 'csjg1',
                    title: '检查结果',
                    width: '10%',
                    rowspan: 2,
                    align: 'center',
                    templet: '#gjcs1jg'
                }
                ]

                , [{field: 'a1', title: '0.95倍', width: '10%', align: 'center'}
                    , {field: 'a2', title: '1.05倍', width: '10%', align: 'center'}
                    , {field: 'b1', title: '0.95倍', width: '10%', align: 'center'}
                    , {field: 'b2', title: '1.05倍', width: '10%', align: 'center'}
                    , {field: 'c1', title: '0.95倍', width: '10%', align: 'center'}
                    , {field: 'c2', title: '1.05倍', width: '10%', align: 'center'}
                ]
            ]
            , done: function (res) {}
        });

    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="gjcs1jg">
    {{# if (d.csjg1 == 1) { }}
    <span>正常</span>
    {{# } else if (d.csjg1 == 0) { }}
    <span>超标</span>
    {{# } else if (d.csjg1 == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>

<%-- 13、告警功能调试2 --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#gjcs2'                           // 改
            , title: '绝缘电阻测试'
            , page: false
            , skin: 'row，line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jlgjcs/selectByAll?tsid=' + tsid + "&gjlx=零序" //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', rowspan: 2, sort: true}
                , {field: 'jg', title: '间隔', width: '10%', align: 'center', rowspan: 2, sort: true}
                , {field: 'gjlx', title: '告警类型', width: '39%', rowspan: 2, align: 'center', sort: true}
                , {title: '零序', align: 'center', colspan: 2}
                , {
                    field: 'csjg1',
                    title: '检查结果',
                    width: '14%',
                    rowspan: 2,
                    align: 'center',
                    templet: '#gjcs2jg'
                }
                ]

                , [{field: 'l1', title: '0.95倍(0.95A)', width: '16%', align: 'center'}
                    , {field: 'l2', title: '1.05倍(1.05A)', width: '16%', align: 'center'}
                ]
            ]
            , done: function (res) {}
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="gjcs2jg">
    {{# if (d.csjg1 == 1) { }}
    <span>正常</span>
    {{# } else if (d.csjg1 == 0) { }}
    <span>超标</span>
    {{# } else if (d.csjg1 == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>
