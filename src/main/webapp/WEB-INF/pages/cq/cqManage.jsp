<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/6/3
  Time: 2:39 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../import.jsp" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/style/wholemain.css"/>
    <script type="text/javascript" src="/js/jquery-1.12.3.min.js"></script>
    <style>
        /* 文本超长class */
        .textEllipsis{
            /*color:red;!*颜色*!*/
            overflow: hidden;/*不允许滚动条*/
            white-space: nowrap;/*不允许文本换行*/
            text-overflow: ellipsis;/*文本超长显示省略号*/
        }

        /* 鼠标移上,显示全文class */
        .textEllipsis:hover {
            height: auto;
            word-break:break-all;
            white-space: pre-wrap;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="right_nav">
<%--    当前位置：处缺--%>
</div>
<div class="qh">
    <div class="tab" style="">
        <a href="javascript:void(0);" class="on" style="border-left:1px solid white;">处缺记录</a>
        <a href="javascript:void(0);">处缺统计</a>
    </div>
    <br/>
    <div class="content">
        <ul>
            <li style="display:none;"></li>
            <li style="display:block;">
                <%@include file="cqCount.jsp" %>
<%--                <%@include file="cqList.jsp" %>--%>
            </li>
            <li style="display: none;">
                <%@include file="cqList.jsp" %>
<%--                <%@include file="cqCount.jsp" %>--%>
            </li>
        </ul>
    </div>
</div>
<script>
    $(function () {
        $(".qh .tab a").click(function () {
            $(this).addClass('on').siblings().removeClass('on');
            var index = $(this).index();
            $('.qh .content li').hide();
            $('.qh .content li:eq(' + (index + 1) + ')').show();
            if (index === 0) {
                $('#cqtj').datagrid("load");
                // $('#dg').datagrid("load");
            } else if (index === 1) {
                $('#dg').datagrid("load");
                // $('#cqtj').datagrid("load");
            }
        });
    });


    // 鼠标悬浮显示
    function contentFormat(value){
        if(value !== undefined && value !== '' && value != null){
            return "<div title='"+value+"' class='textEllipsis'>"+value+"</div>";
        }else{
            return '';
        }
    }

    //在Jquery里格式化Date日期时间数据
    function timeStamp2DateString(time) {
        var datetime = new Date(time);
        datetime.setTime(time);
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
        var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
        return year + "-" + month + "-" + date;
    }
</script>
</body>
</html>
