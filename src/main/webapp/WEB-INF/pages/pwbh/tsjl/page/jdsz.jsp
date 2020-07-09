<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/6/17
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
    <legend id="mao4">4、校对时钟</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <span>检验要求: 将装置时钟校对至当前时钟，以便于系统故障时进行分析。</span><br>
        <label for="szjcjg">检查结果:
            <input id="szjcjg" style="text-align: center;" type="text" readonly>
        </label>
    </blockquote>
</div>
</body>
<script>
    $(function () {
        $.get("${basePath}/pwbh_beizhu/selectByPrimaryKey/" + tsid, function (data) {
                data = JSON.parse(data);
                if (data.szjcjg == 1) {
                    $("#szjcjg").val('正确');
                } else if (data.szjcjg == 0) {
                    $("#szjcjg").val('错误');
                } else if (data.szjcjg == 2) {
                    $("#szjcjg").val('N/A');
                } else {
                    $("#szjcjg").val('');
                }
                if (data.szjcjg == null || data.szjcjg === "" || data.szjcjg == -1) {
                    $("#li_jdsz").css({"background-color": ""});
                } else {
                    $("#li_jdsz").css({"background-color": "#009688"});
                }
            }
        );
    });
</script>
</html>
