<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:47 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title">
    <legend id="mao3_1">3.1 绝缘电阻测试</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <h4>用500伏摇表按下表测量绝缘电阻，摇测完毕后,将各回路对地放电:</h4>
        <table id="jydz" lay-filter="jydz" style=""></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="jydzbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 3.1 绝缘电阻测试 --%>
<script>
    let jydz = false;
    let hldz = false;

    function hlcsflag(jydz, hldz) {
        if (jydz && hldz) {
            $("#li_hlcs").css({"background-color": "#009688"});
            return;
        }
        $("#li_hlcs").css({"background-color": ""});
    }

    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#jydz'                           // 改
            , title: '绝缘电阻测试'
            , page: false
            , skin: 'row,line' //行边框风格
            // , size: 'sm'
            , even: false //开启隔行背景
            , url: '${basePath}/jljydz/selectByAll?tsid=' + tsid    // 改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                , {
                    field: 'bchl', title: '被测回路', width: '41%', align: 'center', sort: true, templet: function (d) {
                        return '<div style="text-align: left">' + d.bchl + '</div>';
                    }
                }
                , {field: 'sydy', title: '试验电压（伏）', width: '18%', align: 'center', sort: true}
                , {field: 'gcyq', title: '规程要求（兆欧）', width: '18%', align: 'center'}
                , {field: 'clzz', title: '测量阻值（兆欧）', width: '18%', align: 'center'}
            ]]
            , done: function (res) {}
        });
    });
</script>
</body>
</html>
