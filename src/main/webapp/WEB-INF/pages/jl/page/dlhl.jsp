<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:52 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend id="mao7">7、模拟CT一次电流验证回路</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <h4>测量步骤：</h4>
        <h4>（1）在全部A、C相和零序CT缠绕绝缘导线，在相间CT上缠绕三圈，在零序CT缠绕两圈。</h4>
        <h4>（2）继保仪Ia、In输出10A电流，分别用鳄鱼夹接导线两端。</h4>
        <h4>（3）DTU二次值读数乘以CT变比，将计算值填入下表。</h4>
        <table id="dlhl" lay-filter="dlhl"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="dlhlbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 7、模拟CT一次电流验证回路 --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#dlhl'                           // 改
            , title: '绝缘电阻测试'
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jldlhl/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: []
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', rowspan: 2, sort: true}
                , {field: 'jg', title: '间隔', width: '10%', rowspan: 2, align: 'center', sort: true}
                , {
                    field: 'csgn',
                    title: '测试功能',
                    width: '13%',
                    rowspan: 2,
                    align: 'center',
                    sort: true,
                    templet: function (d) {
                        return '<div style="text-align: left">' + d.csgn + '</div>';
                    }
                }
                , {
                    field: 'csff',
                    title: '测试方法',
                    width: '26%',
                    rowspan: 2,
                    align: 'center',
                    sort: true,
                    templet: function (d) {
                        return '<div style="text-align: left">' + d.csff + '</div>';
                    }
                }
                , {title: '二次电流读值', align: 'center', colspan: 4}
                , {
                    field: 'csjg',
                    title: '检查结果',
                    width: '10%',
                    rowspan: 2,
                    align: 'center',
                    templet: '#dlhljg'
                }
                ]

                , [{field: 'a', title: 'A相', width: '9%', align: 'center'}
                    , {field: 'b', title: 'B相', width: '9%', align: 'center'}
                    , {field: 'c', title: 'C相', width: '9%', align: 'center'}
                    , {field: 'lx', title: '零序', width: '9%', align: 'center'}
                ]]
            , done: function (res) {}
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="dlhljg">
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
