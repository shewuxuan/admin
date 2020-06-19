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
    <legend id="mao6">6、采样精度测试（测量值在0.5%以内）</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <h4>测量步骤：</h4>
        <h4>继保仪Ia、In输出电流接开关柜的A、C相及零序电流试验端子，测试中满度值采用额定电流5A，半度值采用2.5A 。</h4>
        <h4>（1）满度测量值应在4.975~5.025A以内</h4>
        <h4>（2）半度测量值应在2.488~2.513A以内</h4>
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

<%-- 6、采样精度测试（测量值在0.5%以内） --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#cyjd'                           // 改
            , title: '绝缘电阻测试'
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jlcyjd/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: []
            , cols: [
                [{title: '模拟量采集单元测试记录', align: 'center', colspan: 9}]

                , [{field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', rowspan: 2, sort: true}
                    , {field: 'jg', title: '间隔', width: '10%', rowspan: 2, align: 'center', sort: true}
                    , {
                        field: 'csgn',
                        title: '测试功能',
                        width: '25%',
                        rowspan: 2,
                        align: 'center',
                        sort: true,
                        templet: function (d) {
                            return '<div style="text-align: left">' + d.csgn + '</div>';
                        }
                    }
                    , {field: 'clx', title: '测量项', width: '10%', rowspan: 2, align: 'center', sort: true}
                    , {title: '读值', width: '10%', align: 'center', colspan: 4}
                    , {field: 'csjg', title: '检查结果', width: '10%', rowspan: 2, align: 'center', templet: '#cyjdjg'}
                ]

                , [{field: 'a', title: 'A', width: '10%', align: 'center'}
                    , {field: 'b', title: 'B', width: '10%', align: 'center'}
                    , {field: 'c', title: 'C', width: '10%', align: 'center'}
                    , {field: 'lx', title: '零序', width: '10%', align: 'center'}]
            ]
            , done: function (res, curr, count) {
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
