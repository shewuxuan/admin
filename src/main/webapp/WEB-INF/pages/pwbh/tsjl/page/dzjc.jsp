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
    <legend id="mao10">10、定值检查</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <label for="g1">（1）过流Ⅰ段定值 <input id="g1" style="text-align: center" type="text" readonly/>，</label>
        <label for="g2">过流Ⅱ段定值<input id="g2" style="text-align: center" type="text" readonly/>。</label>
        <br>
        <label for="g11" style="margin-left: 36px;">过流Ⅰ段时间<input id="g11" style="text-align: center" type="text" readonly/>秒，</label>
        <label for="g12">通电<input id="g12" style="text-align: center" type="text" readonly/>秒。</label>
        <br>
        <label for="g21" style="margin-left: 36px;">过流ⅠI段时间<input id="g21" style="text-align: center" type="text" readonly/>秒，</label>
        <label for="g22">通电<input id="g22" style="text-align: center" type="text" readonly/>秒。</label>
        <table id="dzjcgl" lay-filter="dzjcgl"></table>

        <br>

        <label for="l1">（2）零序Ⅰ段定值 <input id="l1" style="text-align: center" type="text" readonly/>，</label>
        <label for="l2">零序Ⅱ段定值<input id="l2" style="text-align: center" type="text" readonly/>。</label>
        <br>
        <label for="l11" style="margin-left: 36px;">零序Ⅰ段时间<input id="l11" style="text-align: center" type="text" readonly/>秒，</label>
        <label for="l12">通电<input id="l12" style="text-align: center" type="text" readonly/>秒。</label>
        <br>
        <label for="l21" style="margin-left: 36px;">零序ⅠI段时间<input id="l21" style="text-align: center" type="text" readonly/>秒，</label>
        <label for="l22">通电<input id="l22" style="text-align: center" type="text" readonly/>秒。</label>
        <table id="dzjclx" lay-filter="dzjclx"></table>

        <%@include file="dzjcgl.jsp" %>
        <%@include file="dzjclx.jsp" %>

        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="dzjcbeizhu" placeholder="" class="layui-textarea" readonly></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<script>

    $(function () {
        $.get("${basePath}/pwbh_dz/selectByPrimaryKey/" + tsid, function (data) {
            data = JSON.parse(data).data;
            $("#l1").val(data.l1);
            $("#l11").val(data.l11);
            $("#l12").val(data.l12);
            $("#l2").val(data.l2);
            $("#l21").val(data.l21);
            $("#l22").val(data.l22);
            $("#g1").val(data.g1);
            $("#g11").val(data.g11);
            $("#g12").val(data.g12);
            $("#g2").val(data.g2);
            $("#g21").val(data.g21);
            $("#g22").val(data.g22);
        });
    })

    function submitDz() {
        let data = {
            "tsid": tsid,
            "l1": $("#l1").val(),
            "l11": $("#l11").val(),
            "l12": $("#l12").val(),
            "l2": $("#l2").val(),
            "l21": $("#l21").val(),
            "l22": $("#l22").val(),
            "g1": $("#g1").val(),
            "g11": $("#g11").val(),
            "g12": $("#g12").val(),
            "g2": $("#g2").val(),
            "g21": $("#g21").val(),
            "g22": $("#g22").val()
        }
        $.ajax({
            type: "POST",
            async: false,
            url: "${basePath}/pwbh_dz/updateByPrimaryKey",
            data: JSON.stringify(data),//必须
            contentType: "application/json;charsetset=UTF-8",//必须
            dataType: "json",//必须
            success: function (data) {
                if (data.code !== 0) {
                    console.log("dz saved failed!");
                }
            }
        });
    }

    function editbz() {
        let beizhu = {
            tsid: tsid,
            pwbhJlDzjc: $("#dzjcbeizhu").val()
        };
        $.ajax({
            type: "POST",
            url: "${basePath}/pwbh_beizhu/updateByPrimaryKey",
            data: JSON.stringify(beizhu),//必须
            contentType: "application/json;charsetset=UTF-8",//必须
            dataType: "json",//必须
            success: function (data) {
            }
        });
    }
</script>
</body>
</html>
