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
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend id="mao5">5、采样精度测试（二次值）</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="cyjd" lay-filter="cyjd"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="cyjdbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 6、采样精度测试（二次值） --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let record = [];
        let tableReload = table.render({
            elem: '#cyjd'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/ftu_jl_cyjd/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [
                [{title: '模拟量采集单元测试记录', align: 'center', colspan: 9}]

                , [{field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', rowspan: 2, sort: true}
                    , {field: 'clx', title: '测量项', width: '26%', rowspan: 2, align: 'center', sort: true}
                    , {title: '读值', width: '10%', align: 'center', colspan: 5}
                    , {field: 'csjg', title: '检查结果', width: '10%', rowspan: 2, align: 'center', templet: '#cyjdjg'}
                ]

                , [{field: 'uab', title: 'Uab', width: '12%', align: 'center'}
                    , {field: 'ubc', title: 'Ubc', width: '12%', align: 'center'}
                    , {field: 'ia', title: 'IA', width: '12%', align: 'center'}
                    , {field: 'ic', title: 'IC', width: '12%', align: 'center'}
                    , {field: 'io', title: 'I0', width: '12%', align: 'center'}]
            ]
            , done: function (res, curr, count) {
                let resdata = res.data;
                record = resdata;
                for (let i = 0, length = resdata.length; i < length; i++) {
                    if (
                        resdata[i].uab == null || resdata[i].uab === ""
                        || resdata[i].ubc == null || resdata[i].ubc === ""
                        || resdata[i].ia == null || resdata[i].ia === ""
                        || resdata[i].ic == null || resdata[i].ic === ""
                        || resdata[i].io == null || resdata[i].io === ""
                        || resdata[i].csjg == null || resdata[i].csjg === "" || resdata[i].csjg == -1
                    ) {
                        $("#li_cyjd").css({"background-color": ""});
                        return;
                    }
                    $("#li_cyjd").css({"background-color": "#009688"});
                }
            }
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="cyjdjg">
    {{# if (d.csjg == 1) { }}
    <span>正常</span>
    {{# } else if (d.csjg == 0) { }}
    <span>超标</span>
    {{# } else if (d.csjg == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>
