<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:54 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title">
    <legend id="mao10_1">10.1 开关柜</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="kgg" lay-filter="kgg"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="kggbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 10.1 开关柜 --%>
<script>
    let kgg = false;
    let dtu = false;
    let ysbj = false;
    let xb = false;

    function yxtsflag(kgg, dtu, ysbj, xb) {
        if (kgg && dtu && ysbj && xb) {
            $("#li_yxts").css({"background-color": "#009688"});
            return;
        }
        $("#li_yxts").css({"background-color": ""});
    }

    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#kgg'
            , title: 'CT工艺检查'
            , page: false
            , skin: 'row,line，nob' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jlkgg/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', rowspan: 2, sort: true}
                , {field: 'jg', title: '间隔', width: '17%', rowspan: 2, align: 'center', sort: true}
                , {title: '手把', align: 'center', colspan: 2}
                , {title: '地刀', align: 'center', colspan: 2}
                , {title: '开关', align: 'center', colspan: 2}
                ]

                , [{field: 'sbyf', title: '远方', width: '13%', align: 'center', templet: '#sbyfjg'}
                    , {field: 'sbjd', title: '就地', width: '13%', align: 'center', templet: '#sbjdjg'}
                    , {field: 'ddf', title: '分', width: '13%', align: 'center', templet: '#ddfjg'}
                    , {field: 'ddh', title: '合', width: '13%', align: 'center', templet: '#ddhjg'}
                    , {field: 'kgf', title: '分', width: '13%', align: 'center', templet: '#kgfjg'}
                    , {field: 'kgh', title: '合', width: '13%', align: 'center', templet: '#kghjg'}
                ]]
            , done: function (res) {}
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="sbyfjg">
    {{# if (d.sbyf == 1) { }}
    <span>正确</span>
    {{# } else if (d.sbyf == 0) { }}
    <span>错误</span>
    {{# } else if (d.sbyf == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="sbjdjg">
    {{# if (d.sbjd == 1) { }}
    <span>正确</span>
    {{# } else if (d.sbjd == 0) { }}
    <span>错误</span>
    {{# } else if (d.sbjd == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="ddfjg">
    {{# if (d.ddf == 1) { }}
    <span>正确</span>
    {{# } else if (d.ddf == 0) { }}
    <span>错误</span>
    {{# } else if (d.ddf == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="ddhjg">
    {{# if (d.ddh == 1) { }}
    <span>正确</span>
    {{# } else if (d.ddh == 0) { }}
    <span>错误</span>
    {{# } else if (d.ddh == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="kgfjg">
    {{# if (d.kgf == 1) { }}
    <span>正确</span>
    {{# } else if (d.kgf == 0) { }}
    <span>错误</span>
    {{# } else if (d.kgf == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="kghjg">
    {{# if (d.kgh == 1) { }}
    <span>正确</span>
    {{# } else if (d.kgh == 0) { }}
    <span>错误</span>
    {{# } else if (d.kgh == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>
